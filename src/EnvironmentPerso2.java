/**
 * Created by atanakar on 14/09/16.
 */
public class EnvironmentPerso2 implements IEnvironment{

    static int streak = 0;

    public EnvironmentPerso2() {

    }

    @Override
    public Result eval(Action exp) {
        Result ret = null;
        if (streak < 10) {
            if(exp.tag == 1)
                ret = new Result(true);
            else {
                ret = new Result(false);
                streak = 0;
            }
            streak++;
        }
        else {
            if (exp.tag == 1) {
                ret = new Result(false);
                streak = 0;
            }
            else
                ret = new Result(true);
            streak++;
        }

        if (streak == 20)
            streak = 0;
        return ret;
    }
}
