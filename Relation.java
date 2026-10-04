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

    public void showTable() {
        for (Attribut attribut : attributs) {
            System.out.print(attribut.getNom() + " ");
        }
        System.out.println();

        for (List<Object> contenu : contenus) {
            for (Object valeur : contenu) {
                System.out.print(valeur + "\t");
            }
            System.out.println();
        }
    }

    public void addContenu(List<List<Object>> individus){
        for(List<Object> individu : individus){
            if(individu.size() != attributs.size()){
                throw new IllegalArgumentException("nombre die valeur dans" + individu + "est incorrect");
            } else {
               if(appartenance(individu, attributs) == true) {
                this.getContenus().add(individu);
               }
            }
        }

    }

    public static boolean appartenance(List<Object> val, List<Attribut> att){
        for(int i = 0; i < att.size(); i++){
            Attribut attribut = att.get(i);
            Object valeur = val.get(i);

            if(!attribut.getDomaine().getType().contains(valeur)){
                throw new IllegalArgumentException("le valeur [" + valeur + "] ne contient pas dans le domaine [" + attribut.getDomaine() + "] de l'attribut [" + attribut.getNom() + "]. ");
            }
        }
        return true;
    }


}
