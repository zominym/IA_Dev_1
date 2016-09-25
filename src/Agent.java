/**
 * Created by atanakar on 14/09/16.
 */
public class Agent {

    Action nextAction = new Action(1);
    Action lastAction;

    public int eval(Action act, Result res) {
        if (act.tag == 1)
            return 0;
        return 1;
    }

    public Action chooseAction() {
        lastAction = nextAction;
        return nextAction;
    }

    public void learn(Result r) {
        if (r.value)
            nextAction = new Action(lastAction.tag);
        else
            nextAction = new Action(3-lastAction.tag);
    }

}
