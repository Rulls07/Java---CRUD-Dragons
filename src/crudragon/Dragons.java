package crudragon;

/**
 *
 * @author Rulls
 */
public class Dragons {

    private int id_dragon;
    private String dragon;
    private String sexe;
    private int longueur;
    private int nombre_ecailles;
    private String crache_feu;
    private String comportement_amoureux;

    public Dragons() {
    }

    public Dragons(int id_dragon, String dragon, String sexe, int longueur, int nombre_ecailles, String crache_feu, String comportement_amoureux) {
        this.id_dragon = id_dragon;
        this.dragon = dragon;
        this.sexe = sexe;
        this.longueur = longueur;
        this.nombre_ecailles = nombre_ecailles;
        this.crache_feu = crache_feu;
        this.comportement_amoureux = comportement_amoureux;
    }

    public int getId_dragon() {
        return id_dragon;
    }

    public void setId_dragon(int id_dragon) {
        this.id_dragon = id_dragon;
    }

    public String getDragon() {
        return dragon;
    }

    public void setDragon(String dragon) {
        this.dragon = dragon;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getNombre_ecailles() {
        return nombre_ecailles;
    }

    public void setNombre_ecailles(int nombre_ecailles) {
        this.nombre_ecailles = nombre_ecailles;
    }

    public String getCrache_feu() {
        return crache_feu;
    }

    public void setCrache_feu(String crache_feu) {
        this.crache_feu = crache_feu;
    }

    public String getComportement_amoureux() {
        return comportement_amoureux;
    }

    public void setComportement_amoureux(String comportement_amoureux) {
        this.comportement_amoureux = comportement_amoureux;
    }

    @Override
    public String toString() {
        return "Dragons{" + "id_dragon=" + id_dragon + ", dragon=" + dragon + ", sexe=" + sexe + ", longueur=" + longueur + ", nombre_ecailles=" + nombre_ecailles + ", crache_feu=" + crache_feu + ", comportement_amoureux=" + comportement_amoureux + '}';
    }

    
    
}
