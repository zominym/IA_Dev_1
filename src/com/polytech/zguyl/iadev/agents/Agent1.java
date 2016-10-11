/**
 * Created by atanakar on 14/09/16.
 */

package com.polytech.zguyl.iadev.agents;

import com.polytech.zguyl.iadev.Action;
import com.polytech.zguyl.iadev.Result;

import java.util.ArrayList;

/**
 * Explication de code
 * Traces
 * Explication comportement
 *
 * Améliorations ?
 */




public class Agent1 implements IAgent {

    private Action lastAction;

    private ArrayList<Action> goodPattern = null;
    private ArrayList<ArrayList<Action>> potentialPatterns = new ArrayList<>();

    private ArrayList<Action> currentPattern = new ArrayList<>();

    public Agent1() {
        ArrayList<Action> p = new ArrayList<>(); p.add(act1);
        potentialPatterns.add(p);
        p = new ArrayList<>(); p.add(act2);
        potentialPatterns.add(p);
    }

    private boolean testGood = false;

    public Action chooseAction() {
        printPattern(currentPattern, "currentPattern");

        printPattern(goodPattern, "goodPattern");

        for (ArrayList<Action> patt : potentialPatterns)
            printPattern(patt, "potentialPattern");


        if (goodPattern != null) { //Si on suit un pattern bon
            lastAction = followPattern(goodPattern);
            testGood = true;
        }

        else if (potentialPatterns.size() > 0) { //Si on suit un pattern potentiel
            lastAction = followPattern(potentialPatterns.get(0));
        }

        else {
            lastAction = null; //Ceci n'est pas censé se produire
            System.out.println("ERROR : RETURNING NULL ACTION");
        }

        return lastAction;
    }

    public void learn(Result res) {
        // currentPattern.add(lastAction); Avant on faisait ceci ici mais dans le cas d'un pattern bon qui échoue on veut garder l'état avant échec

        if (res.value) { //Si le réultat est bon

            if (!testGood && (potentialPatterns.size() == 0 || currentPattern.size() == potentialPatterns.get(0).size() - 1)) {
                //Si on était en potentiel on passe en vérification, si on était en vérification on ne fait rien (on continue le test)
                currentPattern.add(lastAction);
                goodPattern = new ArrayList<>(currentPattern);
                potentialPatterns = new ArrayList<>();
            }
            else
                currentPattern.add(lastAction);
        }

        else { //Si le résultat est mauvais
            if (testGood) { //Si on est en vérification de pattern
                if (goodPattern.size() < currentPattern.size() ) {
                    goodPattern = new ArrayList<>(currentPattern);
                    currentPattern = new ArrayList<>();
                }
                else {
                    testGood = false;

                    ArrayList<Action> potPattern = new ArrayList<>(currentPattern);
                    if (lastAction.equals(act1))
                        potPattern.add(act2);
                    else
                        potPattern.add(act1);
                    potentialPatterns.add(potPattern); // On ajoute le fils avec Action 1



                    goodPattern = null;
                }
            }
            else { //Si on est pas en vérification de pattern alors le pattern expérimental est mauvais
                potentialPatterns.remove(0);
                System.out.println("REMOVED FIRST POTENTIAL PATTERN");
            }
            currentPattern = new ArrayList<>();
        }
    }

    private Action followPattern(ArrayList<Action> patt) {
        if (currentPattern == null || currentPattern.size() == 0)
            return patt.get(0);
        int index = 0;
        for (int i = 0; i < currentPattern.size(); i++) {
            if (currentPattern.get(i) != patt.get(i%patt.size())) {
                System.out.println("ERROR : RETURNED NULL ACTION IN FOLLOWPATTERN");
                return null;
            }
            index ++;
        }
        return patt.get(index%patt.size());
    }

    private void printPattern(ArrayList<Action> patt, String title) {
        String str = "Pattern " + title + " : ";

        if (patt == null) {
            str += "null";
        }
        else {
            for (Action a : patt)
                str += a.toString() + " -> ";
        }

        System.out.println(str);
    }

}
