
package crudragon;

import static crudragon.DBConnexion.openConnection;
import static crudragon.DBqueryDragons.readAll;

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
         readAll();
    }
    
}
