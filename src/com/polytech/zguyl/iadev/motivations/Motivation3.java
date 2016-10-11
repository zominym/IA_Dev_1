/**
 * Created by Vil on 11/10/2016.
 */

package com.polytech.zguyl.iadev.motivations;

import com.polytech.zguyl.iadev.*;

public class Motivation3 implements IMotivation {
    @Override
    public int evaluate(Action action, Result result) {
        if(action == Action.FOWARD)
            return 1;
        return -1;
    }
}
