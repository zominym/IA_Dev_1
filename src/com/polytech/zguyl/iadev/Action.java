/**
 * Created by atanakar on 14/09/16.
 */

package com.polytech.zguyl.iadev;

public enum Action {

    FOWARD("Foward"),
    BACKWARD("Backward");

    private String tag = "";

    Action(String tag) {this.tag = tag;}

    public String tag() {return tag;}

}
