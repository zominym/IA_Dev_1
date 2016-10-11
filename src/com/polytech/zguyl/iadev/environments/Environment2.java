/**
 * Created by vilgh on 05/10/2016.
 */

package com.polytech.zguyl.iadev.environments;

import com.polytech.zguyl.iadev.*;

public class Environment2 implements IEnvironment {

    private Action lastAction = null;

    @Override
    public Result react(Action action) {
        Result ret;
        if(lastAction == null || action != lastAction) {
            ret = Result.R2;
            lastAction = action;
        }
        else {
            ret = Result.R1;
            lastAction = null;
        }
        return ret;
    }
}
