import java.util.ArrayList;
import java.util.List;

public class Domaine{
    private String nom;
    private List<Object> type;

    public Domaine(String nom) {
        this.nom = nom;
        this.type = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }
    public List<Object> getType() {
        return type;
    }

    public String toString(){
        return nom;
    }
}