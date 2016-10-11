/**
 * Created by vilgh on 06/10/2016.
 */

package com.polytech.zguyl.iadev.environments;

import com.polytech.zguyl.iadev.*;

public class Environment4 implements IEnvironment {

    private int cpt = -1;

    @Override
    public Result eval(Action action) {
        cpt++;
        if((action == expected[0] && cpt < 10) || (action == expected[1] && cpt >= 10))
            return new Result(true);
        return new Result(false);
    }
}
