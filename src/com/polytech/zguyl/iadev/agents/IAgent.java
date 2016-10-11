package com.polytech.zguyl.iadev.agents;

import com.polytech.zguyl.iadev.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Vil on 11/10/2016.
 */
public interface IAgent {

    Action act1 = Action.A1;
    Action act2 = Action.A2;

    Action chooseAction();
    void learn(Action action, Result result, int interactionValue);
}
