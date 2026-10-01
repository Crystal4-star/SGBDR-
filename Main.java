import java.util.ArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Domaine plat = new Domaine("plat");
        plat.getType().add("ragout");
        plat.getType().add("caviar");
        plat.getType().add("poulet");
        plat.getType().add("viande");

        Domaine personne = new Domaine("personne");
        personne.getType().add("Maya");
        personne.getType().add("Luck");
        personne.getType().add("Yuan");
        personne.getType().add("Shyon");

        Attribut client = new Attribut("personne", personne);
        Attribut dinner = new Attribut("dinner", plat);

        Relation table = new Relation("restaurant");
        table.getAttributs().addAll(List.of(client, dinner));
        table.getContenus().add(new ArrayList<>(List.of("Maya", "caviar")));

        System.out.println(table.getAttributs());
        System.out.println(table.getContenus());
    }
}
