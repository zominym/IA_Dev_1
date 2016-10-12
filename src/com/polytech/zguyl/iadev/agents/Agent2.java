package com.polytech.zguyl.iadev.agents;

import com.polytech.zguyl.iadev.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Vil on 11/10/2016.
 */
public class Agent2 implements IAgent {

    private Interaction previousInteraction;
    private ArrayList<Coupling> couplings = new ArrayList<>();
    private ArrayList<Action> actionsToTry = new ArrayList<>();

    public Agent2(){
        super();
        actionsToTry.add(Action.A1);
        actionsToTry.add(Action.A2);
    }

    @Override
    public Action chooseAction() {

        actionsToTry = new ArrayList<>();
        actionsToTry.add(Action.A1);
        actionsToTry.add(Action.A2);

        ArrayList<Coupling> activeCouplings = new ArrayList<>();

        //We're looking for every composites interctions who have the same previos interaction as we do
        if (previousInteraction != null)
            activeCouplings
                    .addAll(couplings.stream()
                            .filter(c -> c.previous.equals(previousInteraction))
                            .collect(Collectors.toList()));

        ArrayList<Proposal> proposals = new ArrayList<>();
        for(Coupling active: activeCouplings) {
            Proposal tmp = findByInteraction(proposals, active.next);
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
                else {
                    actionsToTry.remove(proposal.getAction());
                }
        }

        if(actionsToTry.isEmpty()){
            actionsToTry.add(proposals.get(0).getAction());
        }

        Action tmp = actionsToTry.remove(0);
        actionsToTry.add(tmp);
        return tmp;
    }

    @Override
    public void learn(Action action, Result result, int interactionValue) {
        //We're looking if the interaction exist already
        Coupling tmp = null;
        if (previousInteraction != null)
            tmp = findByLabel(previousInteraction, new Interaction(action, result));

        //If it doesn't exist, we gonna create a new one
        if(tmp == null && previousInteraction != null){
            tmp = new Coupling(previousInteraction, new Interaction(action, result), interactionValue);
            couplings.add(tmp);
        }
        else if (tmp != null)//If it exists e increse the weight
            tmp.reinforce();

        previousInteraction = new Interaction(action, result);

        printCouplings();
    }

    private void printCouplings() {
        for (Coupling c : couplings) {
            System.out.println(c.getLabel() + ";" + c.value + ";" + c.weight);
        }
    }

    private Proposal findByInteraction(ArrayList<Proposal> proposals, Interaction interaction){
        for (Proposal p:proposals)
            if(p.getAction() == interaction.action)
                return p;
        return null;
    }

    private Coupling findByLabel(Interaction iter1, Interaction iter2){
        String label = iter1.getLabel()+iter2.getLabel();
        for (Coupling c: couplings) {
            if(label.equals(c.getLabel()))
                return c;
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

    Proposal(Coupling coupling) {
        action = coupling.next.action;
        proclivity = coupling.value * coupling.weight;
    }

    void addProclivity(Coupling coupling){
        proclivity += coupling.value * coupling.weight;
    }

    public int compareTo(Proposal p2){
        return proclivity.compareTo(p2.proclivity);
    }

}