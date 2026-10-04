import java.util.ArrayList;
import java.util.List;

public class Selection {

    private Relation tableau;
    private List<Attribut> attributsSelected;

    public Selection(Relation tableau, List<Attribut> attributsSelected) {
        this.tableau = tableau;
        this.attributsSelected = attributsSelected;
    }

    public static Relation distinct(Relation relation, List<Attribut> attSelected){
        Relation result = new Relation(relation.getNom());

        List<Integer> index = Projection.getIndex(relation, attSelected);
        List<Attribut> attributs = Projection.getAttributByIndex(relation, attSelected);
        List<List<Object>> contenus = Selection.getUnionContenus(relation, index);

        result.getAttributs().addAll(attributs);
        result.getContenus().addAll(contenus);

        return result;
    }

    public static List<List<Object>> getUnionContenus(Relation relation, List<Integer> indexes) {
        List<List<Object>> results = new ArrayList<>();

        for (List<Object> line : relation.getContenus()) {
            List<Object> newLine = new ArrayList<>();
            for (Integer index : indexes) {
                newLine.add(line.get(index));
            }
            results.add(newLine);
        }

        return supprimerDoublon(results);
    }

    public static List<List<Object>> supprimerDoublon(List<List<Object>> contenus) {
        List<List<Object>> result = new ArrayList<>();

        for (List<Object> line : contenus) {
            if (!result.contains(line)) {
                result.add(line);
            }
        }
        return result;
    }
}