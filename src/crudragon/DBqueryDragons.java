package crudragon;

import static crudragon.DBConnexion.accessDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rulls
 */
public class DBqueryDragons {

    public static void readAll() {
        try {
            String query = "SELECT * FROM dragons;";

            PreparedStatement declaration = accessDataBase.prepareStatement(query);

            ResultSet resultat = declaration.executeQuery(query);
            /* Récupération des données */
            while (resultat.next()) {
                Dragons dra = new Dragons();
                dra.setId_dragon(resultat.getInt("id_dragon"));
                dra.setDragon(resultat.getString("dragon"));
                dra.setSexe(resultat.getString("sexe"));
                dra.setLongueur(resultat.getInt("longueur"));
                dra.setNombre_ecailles(resultat.getInt("nombre_ecailles"));
                dra.setCrache_feu(resultat.getString("crache_feu"));
                dra.setComportement_amoureux(resultat.getString("comportement_amoureux"));
                System.out.println("Dragon" + dra.getDragon());
            }
        } catch (Exception e) {
            System.err.println(
                    "Erreur d'affichage dragon: " + e.getMessage()
            );
        }
    }

}
