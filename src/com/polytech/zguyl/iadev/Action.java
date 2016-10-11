/**
 * Created by atanakar on 14/09/16.
 */

package com.polytech.zguyl.iadev;

public enum Action {

    A1("A1"),
    A2("A2");

    private String tag;

    Action(String tag) { this.tag = tag; }

    public String tag() { return tag; }

    @Override
    public String toString(){ return tag(); }

    public int toInt() {
        if (this == A1)
            return 1;
        if (this == A2)
            return 2;
        else return 0;
    }

}
