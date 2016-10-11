/**
 * Created by atanakar on 14/09/16.
 */
package com.polytech.zguyl.iadev;

public enum Result {

    MOVE("Move"),
    STAND("Stand"),
    HIT("Hit");

    private String tag;

    Result(String tag) {
        this.tag = tag;
    }

    public String tag() { return tag; }

    @Override
    public String toString(){ return tag(); }

    public int toInt() {
        if (this == MOVE)
            return 1;
        if (this == CHECK)
            return 2;
        else return 0;
    }
}
