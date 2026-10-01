import java.util.ArrayList;
import java.util.List;

public class Relation {
    private String nom;
    private List<Attribut> attributs;
    private List<List<Object>> contenus;

    public Relation(String nom) {
        this.nom = nom;
        this.attributs = new ArrayList<>();
        this.contenus = new ArrayList<>(new ArrayList<>());
    }
    
    public String getNom() {
        return nom;
    }
    public List<Attribut> getAttributs() {
        return attributs;
    }
    public List<List<Object>> getContenus() {
        return contenus;
    }
    
}
