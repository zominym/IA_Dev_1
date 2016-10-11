import java.util.ArrayList;

/**
 * Created by atanakar on 14/09/16.
 */


/**
 * Explication de code
 * Traces
 * Explication comportement
 *
 * Améliorations ?
 */




public class Agent2bis {

    Action act1 = new Action(1);
    Action act2 = new Action(2);

    Action lastAction;

    ArrayList<Action> goodPattern = null;
    //ArrayList<ArrayList<Action>> badPatterns = new ArrayList<ArrayList<Action>>();
    ArrayList<ArrayList<Action>> potentialPatterns = new ArrayList<ArrayList<Action>>();

    ArrayList<Action> currentPattern = new ArrayList<Action>();

    public Agent2bis() {
        ArrayList<Action> p = new ArrayList<Action>(); p.add(act1);
        potentialPatterns.add(p);
        p = new ArrayList<Action>(); p.add(act2);
        potentialPatterns.add(p);
    }

    boolean testGood = false;

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
            //potentialPatterns.remove(0);
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
                goodPattern = new ArrayList<Action>(currentPattern);
                potentialPatterns = new ArrayList<ArrayList<Action>>();
                //System.out.println("CLEARED POTENTIAL PATTERNS");
                return;
            }
            else
                currentPattern.add(lastAction);
        }

        else { //Si le résultat est mauvais
            if (testGood) { //Si on est en vérification de pattern
                if (goodPattern.size() < currentPattern.size() ) {
                    goodPattern = new ArrayList<Action>(currentPattern);
                    currentPattern = new ArrayList<Action>();
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

                    ArrayList<Action> potPattern = new ArrayList<Action>(currentPattern);
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
            currentPattern = new ArrayList<Action>();
        }
    }

    public Action followPattern(ArrayList<Action> patt) {
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

    public void printPattern(ArrayList<Action> patt, String title) {
        String str = "Pattern " + title + " : ";

        if (patt == null) {
            str += "null";
        } else {
            for (Action a : patt)
                str += a.toString() + " -> ";
        }

        System.out.println(str);
    }

}
