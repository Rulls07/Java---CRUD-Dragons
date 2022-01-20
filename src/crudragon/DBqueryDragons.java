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

    public static boolean createDragon() {
        boolean flag = false;
        System.out.println("Create a new dragon");
        Dragons dragonNew = new Dragons();
        dragonNew.newDragon();
        try {

            String query = "INSERT INTO dragons (id_dragon , dragon, sexe, longueur, nombre_ecailles, crache_feu,comportement_amoureux) VALUES ( ?, ? , ? , ? , ? , ?, ? )";
            PreparedStatement declaration = accessDataBase.prepareStatement(query);
            declaration.setInt(1, dragonNew.getId_dragon());
            declaration.setString(2, dragonNew.getDragon());
            declaration.setString(3, dragonNew.getSexe());
            declaration.setInt(4, dragonNew.getLongueur());
            declaration.setInt(5, dragonNew.getNombre_ecailles());
            declaration.setString(6, dragonNew.getCrache_feu());
            declaration.setString(7, dragonNew.getComportement_amoureux());
            
            int executeUpdate = declaration.executeUpdate();
            flag = (executeUpdate == 1);
        } catch (Exception e) {
            System.err.println(
                    "Erreur d'insertion Dragons: " + e.getMessage()
            );
        }
        return flag;
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
