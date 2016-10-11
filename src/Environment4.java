/**
 * Created by vilgh on 06/10/2016.
 */
public class Environment4 implements IEnvironment {

    private int cpt = -1;

    @Override
    public Result eval(Action exp) {
        cpt++;
        if((exp.tag == 1 && cpt < 10) || (exp.tag == 2 && cpt >= 10))
            return new Result(true);
        return new Result(false);
    }
}
