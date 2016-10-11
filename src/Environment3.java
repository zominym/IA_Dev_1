/**
 * Created by atanakar on 14/09/16.
 */
public class Environment3 implements IEnvironment{

    int lastAction = 0;

    @Override
    public Result eval(Action exp) {
        if(exp.tag == lastAction)
            return new Result(false);
        return new Result(true);
    }

}
