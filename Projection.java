import java.util.ArrayList;
import java.util.List;

public class Projection {
    private Relation tableau;
    private Attribut[] colSelected;

    public Projection(Relation tableau, Attribut[] colSelected) {
        this.tableau = tableau;
        this.colSelected = colSelected;
    }

    public static Relation projeter(Relation table, List<Attribut> column) {
        Relation result = new Relation(table.getNom());

        List<Integer> index = Projection.getIndex(table, column);
        List<Attribut> attributResult = Projection.getAttributByIndex(table, column);
        List<List<Object>> contenusResult = Projection.getContenusByIndex(table, index);

        result.getAttributs().addAll(attributResult);
        result.getContenus().addAll(contenusResult);

        return result;
    }

    public static List<Integer> getIndex(Relation relation, List<Attribut> att) {
        List<Integer> index = new ArrayList<Integer>();

        for (Attribut attribut : att) {
            int position = -1;
            for (int i = 0; i < relation.getAttributs().size(); i++) {
                if (relation.getAttributs().get(i).getNom().equals(attribut.getNom())) {
                    position = i;
                    break;
                }
            }
            if (position == -1) {
                throw new IllegalArgumentException("Attribut [" + attribut.getNom() + "] introuvable");
            }
            index.add(position);
        }
        return index;
    }

    public static  List<Attribut> getAttributByIndex(Relation relation, List<Attribut> att) {
        List<Integer> index = Projection.getIndex(relation, att);
        List<Attribut> attributs = new ArrayList<Attribut>();

        for (Integer ind : index) {
            for (int i = 0; i < relation.getAttributs().size(); i++) {
                if (ind == i) {
                    attributs.add(relation.getAttributs().get(i));
                }
            }
        }
        return attributs;
    }

    public static List<List<Object>> getContenusByIndex(Relation relation, List<Integer> indexes){
        List<List<Object>> results = new ArrayList<>();

        for(List<Object> line : relation.getContenus()){
            List<Object> newLine = new ArrayList<>();
            for(Integer index : indexes){
                newLine.add(line.get(index));
            }
            results.add(newLine);
        }
        return results;
    }
 

}
