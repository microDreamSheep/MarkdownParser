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

    private TableData tableHeads;
    private TableRule tableRule;
    private List<TableData> tableBody;
    @Override
    protected LineElementType SetType() {
        return LineElementType.TABLE;
    }
    /**
     * 表格头构造器
     * 将会通过表格头的数量来确定表格规则和下面行数据的数量
     * @param tableHead 表格头 内部枚举类型为TableData<br/>
     *                  存储表格头的数据为Span对象,用于后期渲染<br/>
     *
     * */
    public void setTableHeads(TableData tableHead) {
        this.tableHeads = tableHead;
        tableBody = new ArrayList<>();
    }
    /**
     * 表格规则构造器
     * @param tableRule 表格规则
     * */
    public void setTableRules(TableRule tableRule) {
        this.tableRule = tableRule;
    }
    /**
     * 表格内容构造器
     * @param tableBody 表格内容
     *                  表格内容的数量必须和表格头的数量相同
     * */
    public boolean addTableBody(TableData tableBody) {
        if (tableBody.getLength() != tableHeads.getLength()) {
            return false;
        }
        this.tableBody.add(tableBody);
        return true;
    }


    public TableData getTableHeads() {
        return tableHeads;
    }
    public TableRule getTableRules() {
        return tableRule;
    }

    public List<TableData> getTableBody() {
        return tableBody;
    }
}
