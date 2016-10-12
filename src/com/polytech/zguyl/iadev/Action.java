/**
 * Created by atanakar on 14/09/16.
 */

package com.polytech.zguyl.iadev;

public enum Action {

    A1("A1", 1),
    A2("A2", 2);

    private int numb;
    private String tag;

    Action(String tag, int numb) { this.tag = tag; this.numb = numb; }

    public String tag() { return tag; }

    @Override
    public String toString(){ return tag(); }

    public int toInt() { return numb; }

}
