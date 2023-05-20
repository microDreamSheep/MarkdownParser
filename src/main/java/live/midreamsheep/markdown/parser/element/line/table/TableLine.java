package live.midreamsheep.markdown.parser.element.line.table;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.span.Span;

import java.util.ArrayList;
import java.util.List;

/**
 * 表格行类型，由表格解析器解析后传入，包含表格头、表格规则、表格内容等信息
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see TableParser
 * @see TableRules
 * */
public class TableLine extends MarkdownLineElement {

    private Span[] tableHeads;
    private TableRules[] tableRules;
    private List<Span[]> tableBody;
    @Override
    protected LineElementType SetType() {
        return LineElementType.TABLE;
    }
    /**
     * 表格头构造器
     * 将会通过表格头的数量来确定表格规则和下面行数据的数量
     * @param tableHeads 表格头
     * */
    public void setTableHeads(Span[] tableHeads) {
        int size = tableHeads.length;
        this.tableHeads = tableHeads;
        tableRules = new TableRules[size];
        tableBody = new ArrayList<>();
    }
    /**
     * 表格规则构造器
     * @param tableRules 表格规则
     * */
    public void setTableRules(TableRules[] tableRules) {
        this.tableRules = tableRules;
    }
    /**
     * 表格内容构造器
     * @param tableBody 表格内容
     *                  表格内容的数量必须和表格头的数量相同
     * */
    public boolean addTableBody(Span[] tableBody) {
        if (tableBody.length != tableHeads.length) {
            return false;
        }
        this.tableBody.add(tableBody);
        return true;
    }


    public Span[] getTableHeads() {
        return tableHeads;
    }
    public TableRules[] getTableRules() {
        return tableRules;
    }

    public List<Span[]> getTableBody() {
        return tableBody;
    }
}
