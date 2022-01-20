package crudragon;

import static crudragon.DBConnexion.openConnection;
import static crudragon.DBqueryDragons.getDragon;
import static crudragon.DBqueryDragons.readGetAll;

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
        boolean flag = true;
        UserMethodes user = new UserMethodes();
        do {
            user.taskChoice(user.displayTaskMenu());

//            alive = pet.checkAlive();
            flag = user.exit(user.displayTaskMenu());

        } while (flag);

//        System.out.println("------------------------- GET ALL DRAGONS -------------------------");
//        readGetAll();
//        System.out.println("------------------------- CREATE NEW DRAGON -------------------------");
//        System.out.println("------------------------- GET DRAGONS BY NAME -------------------------");
//        getDragon();
//        System.out.println("------------------------- MODIFY - DRAGON -------------------------");
    }

}
