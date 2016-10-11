package com.polytech.zguyl.iadev;

import com.polytech.zguyl.iadev.agents.*;
import com.polytech.zguyl.iadev.environments.*;
import com.polytech.zguyl.iadev.motivations.*;

public class Main {

    public static void main(String[] args) {

        IEnvironment environment = new Environment1();
        IAgent agent = new Agent1();
        IMotivation motivation = new Motivation1();

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

            System.out.println(action.toString() + " -> " + result.toString());

            actionString += action.toInt() + " ";
            resultString += result.toInt() + " ";
            valueString += interactionValue + " ";
        }

        System.out.println(actionString);
        System.out.println(resultString);
        System.out.println(valueString);
    }
}
