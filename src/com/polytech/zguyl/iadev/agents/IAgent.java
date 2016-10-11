package com.polytech.zguyl.iadev.agents;

import com.polytech.zguyl.iadev.*;

/**
 * Created by Vil on 11/10/2016.
 */
public interface IAgent {

    Action act1 = Action.A1;
    Action act2 = Action.A2;

    Action chooseAction();
    void learn(Interaction interaction, int interactionValue);

}
