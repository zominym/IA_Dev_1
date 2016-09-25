public class Main {

    public static void main(String[] args) {

        Agent agt = new Agent();
        Environment env = new Environment();

        for (int i = 0; i < 10; i++) {

            Action a = agt.chooseAction();
            Result res = env.eval(a);
            agt.learn(res);

            System.out.println(a.toString() + " -> " + res.toString());

        }

    }
}
