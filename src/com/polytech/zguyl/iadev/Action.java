/**
 * Created by atanakar on 14/09/16.
 */

package com.polytech.zguyl.iadev;

public enum Action {

    FOWARD("Foward"),
    BACKWARD("Backward");

    private String tag;

    Action(String tag) { this.tag = tag; }

    public String tag() { return tag; }

    @Override
    public String toString(){ return tag(); }

    public int toInt() {
        if (this == FOWARD)
            return 1;
        if (this == BACKWARD)
            return 2;
        else return 0;
    }

}
