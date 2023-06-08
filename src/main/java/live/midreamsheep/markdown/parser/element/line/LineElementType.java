package live.midreamsheep.markdown.parser.element.line;

import live.midreamsheep.markdown.parser.element.line.code.CodeLine;
import live.midreamsheep.markdown.parser.element.line.head.HeadLine;
import live.midreamsheep.markdown.parser.element.line.horizontal.HorizontalLine;
import live.midreamsheep.markdown.parser.element.line.standard.Standard;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 行元素类型枚举类
 * 用于标识行元素类型
 *   标题、代码块、引用、列表、表格、分割线、普通行
 * @see CodeLine
 * @see HeadLine
 * @see HorizontalLine
 * @see Standard
 * */
@AllArgsConstructor
@Getter
public enum LineElementType {
    HEAD(1, "HEAD"),
    STANDARD(7,"STANDARD"),
    HORIZONTAL(6,"HORIZONTAL"),

    QUOTE(3,"QUOTE"),
    LIST(4,"LIST"),

    CODE(2,"CODE"),
    CODE_DATA(8,"CODE_DATA"),

    TABLE(5,"TABLE"),
    TABLE_HEAD(9,"TABLE_HEAD"),
    TABLE_BODY(10,"TABLE_BODY"),
    TABLE_ROW(11,"TABLE_ROW"),
    ;
    private final int type;
    private final String identifier;

    public int getType() {
        return type;
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
