package crudragon;

import static crudragon.DBConnexion.openConnection;

/**
 *
 * @author Rulls
 */
public class DragonsMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        openConnection();
        boolean flag;
        int userChoice;

        UserMethodes user = new UserMethodes();
        do {
            userChoice = user.displayTaskMenu();
            user.taskChoice(userChoice);
            flag = user.exit(userChoice);

        } while (flag);
    }

}
