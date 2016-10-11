/**
 * Created by atanakar on 14/09/16.
 */
package com.polytech.zguyl.iadev;

public enum Result {

    R1("R1"),
    R2("R2");

    private String tag;

    Result(String tag) {
        this.tag = tag;
    }

    public String tag() { return tag; }

    @Override
    public String toString(){ return tag(); }

    public int toInt() {
        if (this == R1)
            return 1;
        if (this == R2)
            return 2;
        else return 0;
    }
}
