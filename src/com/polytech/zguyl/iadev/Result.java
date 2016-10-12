/**
 * Created by atanakar on 14/09/16.
 */
package com.polytech.zguyl.iadev;

public enum Result {

    R1("R1", 1),
    R2("R2", 2);

    private String tag;
    private int numb;

    Result(String tag, int numb) { this.tag = tag; this.numb = numb; }

    @Override
    public String toString(){ return tag; }

    public int toInt() { return numb; }
}
