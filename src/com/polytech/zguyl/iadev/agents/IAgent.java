package com.polytech.zguyl.iadev.agents;

import com.polytech.zguyl.iadev.Action;

import java.util.ArrayList;

/**
 * Created by Vil on 11/10/2016.
 */
public interface IAgent {

    Action act1 = Action.FOWARD;
    Action act2 = Action.BACKWARD;

    ArrayList<Action> currentPattern = new ArrayList<Action>();

    Action chooseAction();

}
