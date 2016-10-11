/**
 * Created by Vil on 11/10/2016.
 */
package com.polytech.zguyl.iadev.motivations;

import com.polytech.zguyl.iadev.Interaction;
import com.polytech.zguyl.iadev.Result;

public class Motivation4 implements IMotivation {
    @Override
    public int evaluate(Interaction interaction) {
        if(interaction.getResult() == Result.R2)
            return 1;
        return -1;
    }
}
