/**
 * Created by vilgh on 05/10/2016.
 */

package com.polytech.zguyl.iadev.environments;

import com.polytech.zguyl.iadev.*;

public class Environment2 implements IEnvironment {

    Action lastAction = Action.FOWARD;

    @Override
    public Result eval(Action action) {
        if(action == lastAction)
            return new Result(false);
        return new Result(true);
    }
}
