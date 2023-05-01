package live.midreamsheep.markdown.parser.element.elements.line.table;

public enum TableRules {
    LEFT(0), CENTER(1), RIGHT(2);
    private final int id;

    TableRules(int id) {
        this.id = id;
    }
    public static TableRules getTableRules(int id) {
        for (TableRules tableRules : TableRules.values()) {
            if (tableRules.id == id) {
                return tableRules;
            }
        }
        return null;
    }
}
