package com.polytech.zguyl.iadev.environments;

import com.polytech.zguyl.iadev.*;

/**
 * Created by vilgh on 05/10/2016.
 */
public interface IEnvironment {

    Action[] expected = {Action.FOWARD, Action.BACKWARD};

    Result eval(Action exp);


}
