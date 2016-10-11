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

    public Action getAction(){return action;}
    public Result getResult(){return result;}
    public int getValue(){return value;}
    public int getWeight(){return weight;}
    public CompositeInteraction getPrevious() {return previous;}
    public CompositeInteraction getNext() {return next;}
    public void setNext(CompositeInteraction next) {this.next = next;}

    CompositeInteraction(Action action, Result result, int value) {
        this.action = action;
        this.result = result;
        weight = FIRST_WEIGHT;
        this.value = value;
    }

    public CompositeInteraction(CompositeInteraction previousInteraction, Action action, Result result, int value){
        this.action = action;
        this.result = result;
        weight = FIRST_WEIGHT;
        this.value = value;
        this.previous = previousInteraction;
    }

    CompositeInteraction(Action action, Result result, CompositeInteraction nextInteraction, int value){
        this.action = action;
        this.result = result;
        weight = FIRST_WEIGHT;
        this.value = value;
        this.next = nextInteraction;
    }

    CompositeInteraction(CompositeInteraction previousInteraction, Action action, Result result, CompositeInteraction nextInteraction, int value){
        this.action = action;
        this.result = result;
        weight = FIRST_WEIGHT;
        this.value = value;
        this.previous = previousInteraction;
        this.next = nextInteraction;
    }

    public void reinforce(){
        weight += INCREASE_WEIGHT;
    }

    public void diminish(){
        weight -= DECREASE_WEIGHT;
    }

    public boolean equals(CompositeInteraction object){
        if( object.getAction() != action
         || object.getResult() != result
         || object.getNext()   != next
         || object.getValue()  != value
         || object.getWeight() != weight)
            return false;
        return true;
    }

    public boolean isSameAsPrevious(CompositeInteraction previousInteraction) {
        if(previous == null)
            return false;
        if(previousInteraction == null)
            return false;
        if(previousInteraction.getAction() != previous.action)
            return false;
        if(previousInteraction.getResult() != previous.result)
            return false;
        return true;
    }
}
