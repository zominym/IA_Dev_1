/**
 * Created by atanakar on 14/09/16.
 */
public class Environment {

    public Environment() {

    }

    public Result eval(Action exp) {

        if (exp.tag == 1)
            return new Result(true);
        else
            return new Result(false);
    }

}
