/**
 * Created by atanakar on 14/09/16.
 */

package com.polytech.zguyl.iadev.agents;

import com.polytech.zguyl.iadev.*;
import java.util.ArrayList;

/**
 * Explication de code
 * Traces
 * Explication comportement
 *
 * Améliorations ?
 */




public class Agent1bis extends Agent1 {

    public Agent1bis() {
        super();
    }

    private boolean testGood = false;

    @Override
    public void learn(Action action, Result result, int interactionValue) {
        // currentPattern.add(lastAction); Avant on faisait ceci ici mais dans le cas d'un pattern bon qui échoue on veut garder l'état avant échec

        if (interactionValue > 0) { //Si le réultat est bon

            if (!testGood && (potentialPatterns.size() == 0 || currentPattern.size() == potentialPatterns.get(0).size() - 1)) {
                //Si on était en potentiel on passe en vérification, si on était en vérification on ne fait rien (on continue le test)
                currentPattern.add(lastAction);
                goodPattern = new ArrayList<>(currentPattern);
                potentialPatterns = new ArrayList<>();
                //System.out.println("CLEARED POTENTIAL PATTERNS");
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

//                    ArrayList<Action> potPattern = new ArrayList<Action>(currentPattern);
//                    potPattern.add(act1);
//                    potentialPatterns.add(potPattern); // On ajoute le fils avec Action 1
//
//                    potPattern = new ArrayList<Action>(currentPattern);
//                    potPattern.add(act2);
//                    potentialPatterns.add(potPattern); // On ajoute le fils avec Action 2

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

    public Action surveyPattern(ArrayList<Action> patt, int depth) {
        System.out.println("SURVEYING");
        if (patt.size() < depth)
            return null; // ERREUR
        int cpt1 = 0;
        int cpt2 = 0;
        for (int i = patt.size() - depth; i < patt.size(); i++) {
            if (patt.get(i) == act1)
                cpt1++;
            else
                cpt2++;
        }
        if (cpt2 > cpt1)
            return act2;
        else
            return act1;
    }

}
