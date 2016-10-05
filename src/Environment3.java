/**
 * Created by atanakar on 14/09/16.
 */
public class Environment3 implements IEnvironment{

    static int streak = 0;

    public Environment3() {

    }

    @Override
    public Result eval(Action exp) {

        if (streak == 0 && exp.tag == 2) {
            streak++;
            return new Result(true);
        }
        else if (streak == 0){
            streak = 0;
            return new Result(false);
        }

        if (streak == 1 && exp.tag == 2) {
            streak++;
            return new Result(true);
        }
        else if (streak == 1){
            streak = 0;
            return new Result(false);
        }

        if (streak == 2 && exp.tag == 1) {
            streak = 0;
            return new Result(true);
        }
        else {
            streak = 0;
            return new Result(false);
        }


    }

}
