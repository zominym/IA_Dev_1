public class Main {

    public static void main(String[] args) {

        IEnvironment env = new EnvironmentPerso2();
        Agent2bis agt = new Agent2bis();
        String actionString = "";
        String resultString = "";

        for (int i = 0; i < 100; i++) {
            System.out.println("LOOP NUMBER ------------ " + i);

            Action a = agt.chooseAction();
            Result res = env.eval(a);
            agt.learn(res);

            System.out.println(a.toString() + " -> " + res.toString());

            actionString += a.toString() + " ";
            resultString += res.toInt() + " ";
        }

        System.out.println(actionString);
        System.out.println(resultString);

    }
}
