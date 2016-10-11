package com.polytech.zguyl.iadev;

import com.polytech.zguyl.iadev.agents.Agent1;
import com.polytech.zguyl.iadev.environments.Environment5;
import com.polytech.zguyl.iadev.environments.IEnvironment;

public class Main {

    public static void main(String[] args) {

        IEnvironment env = new Environment5();
        Agent1 agt = new Agent1();

        for (int i = 0; i < 20; i++) {
            System.out.println("LOOP NUMBER ------------ " + i);

            Action a = agt.chooseAction();
            Result res = env.eval(a);
            agt.learn(res);

            System.out.println(a.toString() + " -> " + res.toString());

        }

    }
}
