/**
 * Created by atanakar on 14/09/16.
 */

package com.polytech.zguyl.iadev.environments;

import com.polytech.zguyl.iadev.*;

public class Environment3 implements IEnvironment{

    private static int streak = 0;

    @Override
    public Result react(Action action) {

        if (streak == 0) {
            if (action == expected[1]) {
                streak++;
                return Result.R1;
            }
            else{
                streak = 0;
                return Result.R2;
            }
        }

        if (streak == 1) {
            if (action == expected[1]) {
                streak++;
                return Result.R1;
            }
            else{
                streak = 0;
                return Result.R2;
            }
        }

        if (streak == 2) {
            if (action == expected[0]) {
                streak = 0;
                return Result.R1;
            }
            else{
                streak = 0;
                return Result.R2;
            }
        }

        return null;
    }
}
