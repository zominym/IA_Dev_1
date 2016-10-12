package com.polytech.zguyl.iadev;

/**
 * Created by Vil on 11/10/2016.
 */
public class Coupling {

    private static final int FIRST_WEIGHT = 1, INCREASE_WEIGHT = 1;

    public int value, weight;
    public Interaction previous, next;

    public int getValue(){return value;}
    public int getWeight(){return weight;}

    public String getLabel(){
        return previous.getLabel() + next.getLabel();
    }

    private Coupling(){

    }

    public Coupling(Interaction prev, Interaction nex, int val){
        this.previous = prev;
        this.next = nex;
        this.value = val;
        weight = FIRST_WEIGHT;
    }

    public void reinforce(){
        weight += INCREASE_WEIGHT;
    }

    public boolean equals (Coupling coup) {
        return getLabel().equals(coup.getLabel());
    }
}
