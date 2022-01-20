package crudragon;

import static crudragon.DBConnexion.accessDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rulls
 */
public class DBqueryDragons {

    /**
     * @return all dragons from DB - ArrayList
     */
    public static List<Dragons> readGetAll() {
        List<Dragons> dragonsList = new ArrayList<>();

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
                dragonsList.add(dra);
                System.out.println("Dragon =====> " + dra.getDragon());
            }

        } catch (Exception e) {
            System.err.println(
                    "Erreur d'affichage dragon: " + e.getMessage()
            );
        }
        return dragonsList;
    }

    /**
     *
     * @param dragon
     * @return
     */
    public static boolean createDragon(String dragon) {
        boolean success = false;
        try {
            String query = "INSERT INTO `dragons` VALUES (?)";
            PreparedStatement declaration = accessDataBase.prepareStatement(query);
            declaration.setString(1, dragon);
            boolean executeCreate = declaration.execute();
            success = (executeCreate);
        } catch (SQLException e) {
            System.err.println("Erreur ajout de dragon: " + e.getMessage());
        }
        return success;
    }

    /**
     * Query returns a dragon by id
     */
    public static void getDragonById(int id_dragon) {

    }

    /**
     * Query returns a dragon by Name
     *
     * @return a dragon
     */
    public static Dragons getDragon() {
        Dragons dra = new Dragons();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the dragon's name: ");
        String nameDragon = scanner.nextLine();
        try {
            String query = "SELECT * FROM dragons WHERE dragon = ?";
            PreparedStatement declaration = accessDataBase.prepareStatement(query);
            declaration.setString(1, nameDragon);
            ResultSet resultat = declaration.executeQuery();
            while (resultat.next()) {

                dra.setId_dragon(resultat.getInt("id_dragon"));
                dra.setDragon(resultat.getString("dragon"));
                dra.setSexe(resultat.getString("sexe"));
                dra.setLongueur(resultat.getInt("longueur"));
                dra.setNombre_ecailles(resultat.getInt("nombre_ecailles"));
                dra.setCrache_feu(resultat.getString("crache_feu"));
                dra.setComportement_amoureux(resultat.getString("comportement_amoureux"));
                System.out.println("Dragon =====> " + dra.toString());
            }
        } catch (Exception e) {
            System.err.println(
                    "Erreur d'affichage dragon: " + e.getMessage()
            );
        }
        return dra;
    }
    
        public static boolean deleteByNameDragon() {
        boolean success = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the dragon's name: ");
        String nameDragon = scanner.nextLine();
        try {
            String query = "DELETE FROM dragons WHERE nom = ?";
            PreparedStatement declaration = accessDataBase.prepareStatement(query);
            declaration.setString(1, nameDragon);
            int executeUpdate = declaration.executeUpdate();
            success = (executeUpdate == 1);
        } catch (SQLException e) {
            System.err.println("Error remove dragons: "
                    + e.getMessage());
        }
        return success;
    }

}
