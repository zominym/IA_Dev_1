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
        ArrayList<CompositeInteraction> activesInteractions = new ArrayList<>();

        //We're looking for every composites interactions who have the same previos interaction as we do
        activesInteractions
                .addAll(interactions.stream()
                        .filter(i -> (i.isSameAsPrevious(previousInteraction)))
                        .collect(Collectors.toList()));

        ArrayList<Proposal> proposals = new ArrayList<>();
        for(CompositeInteraction active: activesInteractions) {
            Proposal tmp = new Proposal(active.getAction(), active.getWeight(), active.getNext().getValue());
            int index = proposals.indexOf(tmp);
            if(index < 0)
                proposals.add(tmp);
            else{
                proposals
                        .get(index)
                        .addProclivity(active.getWeight() * active.getNext().getNext().getValue());
            }
        }
        Collections.sort(proposals);

        if(proposals.size() > 0) {
            for(int i = 0; i < proposals.size(); i++)
                if(proposals.get(i).proclivity > 0)
                    return proposals.get(i).action;
        }

        Action tmp = actionsToTry.remove(0);
        actionsToTry.add(tmp);
        return tmp;
    }

    @Override
    public void learn(Action action, Result result, int interactionValue) {
        boolean reinforced = false;

        ArrayList<CompositeInteraction> existingInteractions = new ArrayList<>();
        CompositeInteraction tmp = null;

        //We're looking if the interaction exist already
        for (CompositeInteraction i: interactions) {
            if(i.getAction() == action && i.getResult() == result){
                i.reinforce();
                reinforced = true;
                tmp = i;
                break;
            }
        }
        //If it's not, we gonna create a new one
        if(!reinforced){
            tmp = new CompositeInteraction(previousInteraction, action, result, interactionValue);
            interactions.add(tmp);
        }

        if(previousInteraction != null) {
            previousInteraction.setNext(tmp);
        }

        previousInteraction = tmp;
    }

}

class Proposal implements Comparable<Proposal> {

    Proposal(Action a, int w, int v) {
        action = a;
        proclivity = w * v;
    }

    Action action;
    Integer proclivity;

    public int compareTo(Proposal p2){
        return proclivity.compareTo(p2.proclivity);
    }

    void addProclivity(int val){
        proclivity += val;
    }
}