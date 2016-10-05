public class Main {

    public static void main(String[] args) {

        IEnvironment env = new Environment3();
        Agent2 agt = new Agent2();

        for (int i = 0; i < 20; i++) {
            System.out.println("LOOP NUMBER ------------ " + i);

            Action a = agt.chooseAction();
            Result res = env.eval(a);
            agt.learn(res);

            System.out.println(a.toString() + " -> " + res.toString());

        }

    }
}
