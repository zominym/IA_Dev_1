/**
 * Created by vilgh on 05/10/2016.
 */

package com.polytech.zguyl.iadev.environments;

import com.polytech.zguyl.iadev.*;

public class Environment1 implements IEnvironment {

    @Override
    public Result eval(Action action) {
        return (action == expected[0]) ? new Result(true) : new Result(false);
    }
}
