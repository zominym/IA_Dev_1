package com.polytech.zguyl.iadev.agents;

import com.polytech.zguyl.iadev.*;

/**
 * Created by Vil on 11/10/2016.
 */
public interface IAgent {

    Action act1 = Action.FOWARD;
    Action act2 = Action.BACKWARD;

    Action chooseAction();
    void learn(Interaction interaction, int interactionValue);

}
