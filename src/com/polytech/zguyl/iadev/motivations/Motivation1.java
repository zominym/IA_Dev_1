/**
 * Created by Vil on 11/10/2016.
 */

package com.polytech.zguyl.iadev.motivations;

import com.polytech.zguyl.iadev.*;

public class Motivation1 implements IMotivation {
    @Override
    public int evaluate(Action action, Result result) {
        if(action == Action.A1)
            return 1;
        return -1;
    }
}
