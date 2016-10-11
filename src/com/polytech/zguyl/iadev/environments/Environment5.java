/**
 * Created by vilgh on 06/10/2016.
 */

package com.polytech.zguyl.iadev.environments;

import com.polytech.zguyl.iadev.*;

public class Environment5 implements IEnvironment {

    private int cpt = -1;

    @Override
    public Result eval(Action action) {
        cpt++;
        if(cpt < 10){
            if(action == expected[0])
                return new Result(true);
            return new Result(false);
        }
        else if (cpt == 10){
            if(action == expected[1])
                return new Result(true);
            return new Result(false);
        }
        else if (action == expected[0])
            return new Result(true);
        return new Result(false);
    }
}
