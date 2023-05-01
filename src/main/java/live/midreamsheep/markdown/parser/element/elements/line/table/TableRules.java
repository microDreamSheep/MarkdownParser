package live.midreamsheep.markdown.parser.element.elements.line.table;

/**
 * 表格对齐标准枚举类
 * 用于标识表格的对齐方式
 * 标记有: 左对齐(LEFT)，居中(CENTER)，右对齐(RIGHT)
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see live.midreamsheep.markdown.parser.element.elements.line.table.TableParser
 * @see live.midreamsheep.markdown.parser.element.elements.line.table.TableLine
 * */
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
