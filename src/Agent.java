import java.util.ArrayList;
import java.util.List;

/**
 * Created by atanakar on 14/09/16.
 */
public class Agent {

    Action lastAction;

    ArrayList<Action> goodPattern = null;
    //ArrayList<ArrayList<Action>> badPatterns = new ArrayList<ArrayList<Action>>();
    ArrayList<ArrayList<Action>> potentialPatterns = new ArrayList<ArrayList<Action>>();

    ArrayList<Action> currentPattern = new ArrayList<Action>();

    public Agent() {
        ArrayList<Action> p = new ArrayList<Action>(); p.add(new Action(1));
        potentialPatterns.add(p);
        p = new ArrayList<Action>(); p.add(new Action(2));
        potentialPatterns.add(p);
    }

    boolean testGood = false;

    public Action chooseAction() {

        if (goodPattern != null) { //Si on suit un pattern bon
            lastAction = followPattern(goodPattern);
            testGood = true;
        }

        else if (potentialPatterns.size() > 0) { //Si on suit un pattern potentiel
            lastAction = followPattern(potentialPatterns.get(0));
            potentialPatterns.remove(0);
        }

        else lastAction = null; //Ceci n'est pas censé se produire

        return lastAction;
    }

    public void learn(Result res) {
        // currentPattern.add(lastAction); Avant on faisait ceci ici mais dans le cas d'un pattern bon qui échoue on veut garder l'état avant échec

        if (res.value) { //Si le réultat est bon

            if (!testGood) { //Si on était en potentiel on passe en bon, si on était en bon on ne fait rien (on continue le test)
                currentPattern.add(lastAction);
                goodPattern = currentPattern;
                return;
            }
        }

        else { //Si le résutat est mauvais
                if (testGood) { //Si on est en vérification de pattern
                    testGood = false;
                    potentialPatterns = new ArrayList<ArrayList<Action>>();

                    ArrayList<Action> potPattern = new ArrayList<Action>(currentPattern); potPattern.add(new Action(1));
                    potentialPatterns.add(potPattern); // On ajoute le fils avec Action 1

                    potPattern = new ArrayList<Action>(currentPattern); potPattern.add(new Action(1));
                    potentialPatterns.add(potPattern); // On ajoute le fils avec Action 2

                    goodPattern = null;
                } else //Si on est pas en vérification de pattern alors le pattern expérimental est mauvais
                    potentialPatterns.remove(0);
            }
    }

}
