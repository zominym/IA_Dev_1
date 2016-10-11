/**
 * Created by atanakar on 14/09/16.
 */
package com.polytech.zguyl.iadev;

public class Result {

    public boolean value;

    public Result(boolean val) {
        value = val;
    }

    public String toString() {
        return "" + value;
    }

    public int toInt() {if (value) return 1; else return 0;}
}
