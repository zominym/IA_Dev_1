package com.polytech.zguyl.iadev;

import com.polytech.zguyl.iadev.agents.*;
import com.polytech.zguyl.iadev.environments.*;
import com.polytech.zguyl.iadev.motivations.*;

public class Main {

    public static void main(String[] args) {

        IEnvironment environment = new Environment2();
        IAgent agent = new Agent1();
        IMotivation motivation = new Motivation4();

        Action action;
        Result result;
        Interaction interaction;
        int interactionValue;

        String actionString = "";
        String resultString = "";
        String valueString = "";

        for (int i = 0; i < 100; i++) {
            System.out.println("LOOP NUMBER ------------ " + i);

            action = agent.chooseAction();
            result = environment.react(action);
            interaction = new Interaction(action, result);
            interactionValue = motivation.evaluate(interaction);
            agent.learn(interaction, interactionValue);

            System.out.println(action.toString() + " -> " + result.toString() + " : " + interactionValue);

            actionString += action.toInt() + " ";
            resultString += result.toInt() + " ";
            if (interactionValue == 1)
                valueString += "1 ";
            else
                valueString += "0 ";
        }

        System.out.println("ACTION | " + actionString);
        System.out.println("RESULT | " + resultString);
        System.out.println("VALUE  | " + valueString);
    }
}
