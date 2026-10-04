import java.util.ArrayList;

import java.util.List;
import java.util.Map;

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

        Attribut client = new Attribut("client", personne);
        Attribut dinner = new Attribut("dinner", plat);
        Attribut serveur = new Attribut("serveur", personne);

        Relation table = new Relation("restaurant");
        table.getAttributs().addAll(List.of(client, dinner, serveur));

        table.addContenu(List.of(
                List.of("Maya", "poulet", "Luck"),
                List.of("Yuan", "viande", "Shyon"),
                List.of("Yuan", "viande", "Shyon")

        ));

        // List de column a selectionner
        List<Attribut> attSelected = new ArrayList<Attribut>();
        attSelected.add(dinner);
        attSelected.add(serveur);
        attSelected.add(client);

        List<Integer> index = Projection.getIndex(table, attSelected);
        // System.out.println(index);

        // SELECT column(attSelected) FROM table (table)
        List<Attribut> attributs = Projection.getAttributByIndex(table, attSelected);
        // System.out.println(attributs);

        List<List<Object>> contenus = Projection.getContenusByIndex(table, index);
        // System.out.println(contenus);

        Relation projection = Projection.projeter(table, attributs);
        // projection.showTable();
        // table.showTable();

        Relation selection = Selection.distinct(table, attributs);
        selection.showTable();

        String requete = "SELECT * FROM restaurant";

    }
}
