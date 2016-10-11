/**
 * Created by Vil on 11/10/2016.
 */
package com.polytech.zguyl.iadev.motivations;

import com.polytech.zguyl.iadev.Action;
import com.polytech.zguyl.iadev.Interaction;

public class Motivation3 implements IMotivation {
    @Override
    public int evaluate(Interaction interaction) {
        if(interaction.getAction() == Action.FOWARD)
            return 1;
        return -1;
    }
}
