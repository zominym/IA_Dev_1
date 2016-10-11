/**
 * Created by vilgh on 05/10/2016.
 */
public class Environment2 implements IEnvironment {

    int val = 2;

    @Override
    public Result eval(Action exp) {
        return (exp.tag == val) ? new Result(true) : new Result(false);
    }
}
