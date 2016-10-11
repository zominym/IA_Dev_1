package com.polytech.zguyl.iadev.environments;

import com.polytech.zguyl.iadev.*;

/**
 * Created by atanakar on 14/09/16.
 */
public class EnvironmentPerso2 implements IEnvironment{

    private static int streak = 0;


    @Override
    public Result react(Action action) {
        Result ret;
        if (streak < 10) {
            if(action == expected[0])
                ret = Result.MOVE;
            else {
                ret = Result.CHECK;
                streak = 0;
            }
            streak++;
        }
        else {
            if (action == expected[1]) {
                ret = Result.CHECK;
                streak = 0;
            }
            else
                ret = Result.MOVE;
            streak++;
        }

        if (streak == 20)
            streak = 0;
        return ret;
    }
}
