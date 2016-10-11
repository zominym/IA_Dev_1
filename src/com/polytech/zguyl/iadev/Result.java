/**
 * Created by atanakar on 14/09/16.
 */
package com.polytech.zguyl.iadev;

public enum Result {

    MOVE("Move"),
    CHECK("Check"),
    HIT("Hit");

    private String tag;

    Result(String tag) {
        this.tag = tag;
    }

    public String tag() { return tag; }

    @Override
    public String toString(){ return tag(); }
}
