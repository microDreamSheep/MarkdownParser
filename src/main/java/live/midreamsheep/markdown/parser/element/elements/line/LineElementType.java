package live.midreamsheep.markdown.parser.element.elements.line;

/**
 * 行元素类型枚举类
 * 用于标识行元素类型
 *   标题、代码块、引用、列表、表格、分割线、普通行
 * @see live.midreamsheep.markdown.parser.element.elements.line.code.CodeLine
 * @see live.midreamsheep.markdown.parser.element.elements.line.head.HeadLine
 * @see live.midreamsheep.markdown.parser.element.elements.line.horizontal.HorizontalLine
 * @see live.midreamsheep.markdown.parser.element.elements.line.standard.Standard
 * */
public enum LineElementType {
    HEAD(1),
    CODE(2),
    QUOTE(3),
    LIST(4),
    TABLE(5),
    HORIZONTAL(6),
    STANDARD(7),
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
