package live.midreamsheep.markdown.parser.element.line;

import live.midreamsheep.markdown.parser.element.line.code.CodeLine;
import live.midreamsheep.markdown.parser.element.line.head.HeadLine;
import live.midreamsheep.markdown.parser.element.line.horizontal.HorizontalLine;
import live.midreamsheep.markdown.parser.element.line.standard.Standard;

/**
 * 行元素类型枚举类
 * 用于标识行元素类型
 *   标题、代码块、引用、列表、表格、分割线、普通行
 * @see CodeLine
 * @see HeadLine
 * @see HorizontalLine
 * @see Standard
 * */
public enum LineElementType {
    HEAD(1),
    CODE(2),
    QUOTE(3),
    LIST(4),
    TABLE(5),
    HORIZONTAL(6),
    STANDARD(7),
    CODE_DATA(8),
    TABLE_HEAD(9),
    TABLE_BODY(10),
    TABLE_ROW(11),
    ;
    private final int type;

    public int getType() {
        return type;
    }
    LineElementType(int type) {
        this.type = type;
    }
    public static LineElementType getSpanElementType(int type) {
        for (LineElementType value : LineElementType.values()) {
            if (value.getType() == type) {
                return value;
            }
        }
        return null;
    }

}
