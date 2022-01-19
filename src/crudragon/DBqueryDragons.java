package crudragon;

import static crudragon.DBConnexion.accessDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Rulls
 */
public class DBqueryDragons {

    /**
     * Query returns all dragons
     */
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

    /**
     * Query returns a dragon by id
     */
    public static void getDragonById(int id_dragon) {

    }

    /**
     * Query returns a dragon by Name
     */
    public static void getDragon() {
        Scanner scanner = new Scanner(System.in);
        String nameDragon = scanner.nextLine();
        try {
            String query = "SELECT * FROM dragons WHERE nom = ?";
            PreparedStatement declaration = accessDataBase.prepareStatement(query);
            declaration.setString(1, nameDragon);
            int executeUpdate = declaration.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur Dragon: "
                    + e.getMessage());
        }

    }

}
