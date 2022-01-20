package crudragon;

import static crudragon.DBqueryDragons.createDragon;
import static crudragon.DBqueryDragons.deleteByNameDragon;
import static crudragon.DBqueryDragons.getDragonByName;
import static crudragon.DBqueryDragons.readGetAll;
import java.util.Scanner;

/**
 *
 * @author Rulls
 */
public class UserMethodes {

    /**
     * Display the task menu to the user
     *
     * @return
     */
    public int displayTaskMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What activity do you want to do with: ");
        System.out.println("[0] -- Create a new dragon, [1] = Show all dragons, [2] = Find a dragon by name, [3] = Modify a dragon , [4] = Remove a dragon, [5] = Exit");
        int choiseUser = scanner.nextInt();
        scanner.nextLine();
        return choiseUser;
    }

    /**
     * user choice activity
     *
     * @param choiseUser
     */
    public void taskChoice(int choiseUser) {

        switch (choiseUser) {
            case 0:
                createDragon();
                break;
            case 1:
                readGetAll();
                break;
            case 2:
                getDragonByName();
                break;
            case 4:
                deleteByNameDragon();
                break;
            case 5:
                System.out.println("Goodbye, Thanks you!!!");
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
    public boolean exit(int choiseUser){
        boolean exitFlag = true;
        if (choiseUser == 5 ){
            exitFlag = false;
        }
        return exitFlag;
    }
    
    

}
