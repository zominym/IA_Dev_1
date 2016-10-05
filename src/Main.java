public class Main {

    public static void main(String[] args) {

        Agent agt = new Agent();
        IEnvironment env = new Environment3();

        for (int i = 0; i < 20; i++) {
            System.out.println("LOOP NUMBER ------------ " + i);

            Action a = agt.chooseAction();
            Result res = env.eval(a);
            agt.learn(res);

            System.out.println(a.toString() + " -> " + res.toString());

        }

    }
}
