/**
 * Created by atanakar on 14/09/16.
 */
public class Action {

    public int tag;

    public Action(int t) {
        tag = t;
    }

    public String toString() {
        return "" + tag;
    }

    public boolean equals(Action act) {
        return act.tag == this.tag;
    }
}
