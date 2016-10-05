/**
 * Created by vilgh on 05/10/2016.
 */
public class Environment2 implements IEnvironment {

    int lastAction = 0;

    @Override
    public Result eval(Action exp) {
        if(exp.tag == lastAction)
            return new Result(false);
        return new Result(true);
    }
}
