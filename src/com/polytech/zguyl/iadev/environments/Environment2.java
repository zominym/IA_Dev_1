/**
 * Created by vilgh on 05/10/2016.
 */

package com.polytech.zguyl.iadev.environments;

import com.polytech.zguyl.iadev.*;

public class Environment2 implements IEnvironment {

    private Action lastAction = Action.FOWARD;

    @Override
    public Result react(Action action) {
        if(action == lastAction)
            return Result.STAND;
        return Result.MOVE;
    }
}
