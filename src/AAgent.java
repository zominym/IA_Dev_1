import java.util.ArrayList;

/**
 * Created by Vil on 11/10/2016.
 */
public abstract class AAgent {

    Action act1 = new Action(1);
    Action act2 = new Action(2);

    ArrayList<Action> currentPattern = new ArrayList<Action>();

    public abstract Action chooseAction();

}
