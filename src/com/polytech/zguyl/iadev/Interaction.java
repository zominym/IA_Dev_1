package com.polytech.zguyl.iadev;

/**
 * Created by atanakar on 12/10/16.
 */
public class Interaction {
    public Action action;
    public Result result;

    public Interaction(Action act, Result res) {
        action = act;
        result = res;
    }

    public String getLabel() {
        return action.toString() + result.toString();
    }

    public boolean equals(Interaction iter) {
        return getLabel().equals(iter.getLabel());
    }
}
