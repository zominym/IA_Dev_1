/**
 * Created by vilgh on 06/10/2016.
 */
public class Environment5 implements IEnvironment {

    int cpt = -1;

    @Override
    public Result eval(Action exp) {
        cpt++;
        if(cpt < 10){
            if(exp.tag == 1)
                return new Result(true);
            return new Result(false);
        }
        else if (cpt == 10){
            if(exp.tag == 2)
                return new Result(true);
            return new Result(false);
        }
        else if (exp.tag == 1)
            return new Result(true);
        return new Result(false);
    }
}
