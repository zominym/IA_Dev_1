/**
 * Created by vilgh on 05/10/2016.
 */
public class Environment1 implements IEnvironment {

    int val = 1;

    @Override
    public Result eval(Action exp) {
        return (exp.tag == val) ? new Result(true) : new Result(false);
    }
}
