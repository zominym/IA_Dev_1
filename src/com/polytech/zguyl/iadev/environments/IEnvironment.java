package com.polytech.zguyl.iadev.environments;

import com.polytech.zguyl.iadev.*;

/**
 * Created by vilgh on 05/10/2016.
 */
public interface IEnvironment {

    Action[] expected = {Action.A1, Action.A2};

    Result react(Action action);


}
