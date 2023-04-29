package live.midreamsheep.markdown.parser.element.elements.line;

import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanElementType;

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
