package com.polytech.zguyl.iadev.agents;

import com.polytech.zguyl.iadev.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Vil on 11/10/2016.
 */
public class Agent2 implements IAgent {

    private CompositeInteraction previousInteraction;
    private ArrayList<CompositeInteraction> interactions = new ArrayList<>();
    private ArrayList<Action> actionsToTry = new ArrayList<>();

    public Agent2(){
        super();
        actionsToTry.add(Action.A1);
        actionsToTry.add(Action.A2);
    }

    @Override
    public Action chooseAction() {

        if(actionsToTry.isEmpty()){
            actionsToTry.add(Action.A1);
            actionsToTry.add(Action.A2);
        }

        ArrayList<CompositeInteraction> activesInteractions = new ArrayList<>();

        //We're looking for every composites interactions who have the same previos interaction as we do
        activesInteractions
                .addAll(interactions.stream()
                        .filter(i -> i.getPrevious().getLabel().equals(previousInteraction.getLabel()))
                        .collect(Collectors.toList()));


        ArrayList<Proposal> proposals = new ArrayList<>();
        for(CompositeInteraction active: activesInteractions) {
            Proposal tmp = findByInteraction(proposals, active);
            if(tmp == null){
                tmp = new Proposal(active);
                proposals.add(tmp);
            }
            else{
                 tmp.addProclivity(active);
            }
        }
        Collections.sort(proposals);

        //If the proposals are good, we chose one
        if(proposals.size() > 0) {
            for (Proposal proposal : proposals)
                if (proposal.getProclivity() > 0)
                    return proposal.getAction();
                else
                    actionsToTry.remove(proposal.getAction());
        }

        if(actionsToTry.isEmpty()){
            actionsToTry.add(Action.A1);
            actionsToTry.add(Action.A2);
        }

        Action tmp = actionsToTry.remove(0);
        actionsToTry.add(tmp);
        return tmp;
    }

    @Override
    public void learn(Action action, Result result, int interactionValue) {
        //We're looking if the interaction exist already
        CompositeInteraction tmp = findByLabel(action, result);

        //If it's not, we gonna create a new one
        if(tmp == null){
            tmp = new CompositeInteraction(previousInteraction, action, result, interactionValue);
            interactions.add(tmp);
        }
        else {
            tmp.setValue(interactionValue);
            tmp.reinforce();
        }

        //If we have a previous interaction, we set the current to next
        if(previousInteraction != null)
            previousInteraction.setNext(tmp);

        previousInteraction = tmp;
    }

    private Proposal findByInteraction(ArrayList<Proposal> proposals, CompositeInteraction interaction){
        for (Proposal p:proposals)
            if(p.getAction() == interaction.getAction())
                return p;
        return null;
    }

    private CompositeInteraction findByLabel(Action action, Result result){
        String label = action.toString()+result.toString();
        for (CompositeInteraction i: interactions) {
            if(label.equals(i.getLabel()))
                return i;
        }
        return null;
    }

}

class Proposal implements Comparable<Proposal> {

    private Action action;
    private Integer proclivity;

    public Action getAction() {
        return action;
    }

    Integer getProclivity() {
        System.out.println("PROCLIVITY A:"+action+" - P:"+proclivity);
        return proclivity;
    }

    Proposal(CompositeInteraction interaction) {
        action = interaction.getAction();
        proclivity = interaction.getValue() * interaction.getWeight();
    }

    void addProclivity(CompositeInteraction interaction){
        proclivity +=interaction.getNext().getValue() * interaction.getWeight();
    }

    public int compareTo(Proposal p2){
        return proclivity.compareTo(p2.proclivity);
    }

}