/**
 * Created by atanakar on 14/09/16.
 */

package com.polytech.zguyl.iadev;

public class Interaction {
    private Action action;
    private Result result;

    Interaction(Action action, Result result){
        this.action = action;
        this.result = result;
    }

    public Action getAction(){return action;}
    public Result getResult(){return result;}
}
