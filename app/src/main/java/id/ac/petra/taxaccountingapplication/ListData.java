package id.ac.petra.taxaccountingapplication;

public class ListData {
    String name;
    int concept, types, coa, equations;

    public ListData(String name, int concept, int types, int coa, int equations) {
        this.name = name;
        this.concept = concept;
        this.types = types;
        this.coa = coa;
        this.equations = equations;
    }
}
