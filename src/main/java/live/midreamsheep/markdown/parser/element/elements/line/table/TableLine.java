package live.midreamsheep.markdown.parser.element.elements.line.table;

import live.midreamsheep.markdown.parser.element.elements.line.LineElementType;
import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;

import java.util.ArrayList;
import java.util.List;

public class TableLine extends MarkdownLineElement {

    private Span[] tableHeads;
    private TableRules[] tableRules;
    private List<Span[]> tableBody;
    @Override
    protected LineElementType SetType() {
        return LineElementType.TABLE;
    }
    public void setTableHeads(Span[] tableHeads) {
        int size = tableHeads.length;
        this.tableHeads = tableHeads;
        tableRules = new TableRules[size];
        tableBody = new ArrayList<>();
    }
    public void setTableRules(TableRules[] tableRules) {
        this.tableRules = tableRules;
    }

    public boolean addTableBody(Span[] tableBody) {
        this.tableBody.add(tableBody);
        return true;
    }
    public Span[] getTableHeads() {
        return tableHeads;
    }
    public TableRules[] getTableRules() {
        return tableRules;
    }

}
