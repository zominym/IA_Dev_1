package com.polytech.zguyl.iadev;

/**
 * Created by Vil on 11/10/2016.
 */
public class CompositeInteraction {

    private static final int FIRST_WEIGHT = 1, INCREASE_WEIGHT = 1, DECREASE_WEIGHT = 1;

    private int value, weight;
    private CompositeInteraction previous, next;
    private Action action;
    private Result result;
    private String label;

    public Action getAction(){return action;}
    public Result getResult(){return result;}
    public int getValue(){return value;}
    public int getWeight(){return weight;}
    public String getLabel(){return label;}
    public CompositeInteraction getPrevious() {
        if(previous == null)
            previous = new CompositeInteraction();
        return previous;
    }
    public CompositeInteraction getNext() {return next;}
    public void setNext(CompositeInteraction next) {this.next = next;}

    public CompositeInteraction(){

    }
    public CompositeInteraction(CompositeInteraction previousInteraction, Action action, Result result, int value){
        this.action = action;
        this.result = result;
        this.label = action.toString()+result.toString();
        weight = FIRST_WEIGHT;
        this.value = value;
        this.previous = previousInteraction;
    }

    public void reinforce(){
        weight += INCREASE_WEIGHT;
    }

    public boolean isSameAsPrevious(CompositeInteraction previousInteraction) {
        if(previous == null || previousInteraction == null)
            return false;
        if(previousInteraction.label != previous.label)
            return false;
        return true;
    }
}
