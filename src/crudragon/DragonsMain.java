package crudragon;

import static crudragon.DBConnexion.openConnection;
import static crudragon.DBqueryDragons.createDragon;
import static crudragon.DBqueryDragons.deleteByNameDragon;
import static crudragon.DBqueryDragons.getDragonByName;
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
        boolean flag;
        UserMethodes user = new UserMethodes();
        do {
            user.taskChoice(user.displayTaskMenu());
            flag = user.exit(user.displayTaskMenu());

        } while (flag);

//        System.out.println("------------------------- GET ALL DRAGONS -------------------------");
//        readGetAll();
//        System.out.println("------------------------- CREATE NEW DRAGON -------------------------");
//        createDragon();
//        System.out.println("------------------------- GET DRAGONS BY NAME -------------------------");
//        getDragonByName();
//        System.out.println("------------------------- MODIFY - DRAGON -------------------------");
//        System.out.println("------------------------- DELETE - DRAGON -------------------------");
//        deleteByNameDragon();
    }

}
