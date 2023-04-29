package live.midreamsheep.markdown.parser.element.elements.span.spans;

public enum SpanElementType {
    COMPOSITION(0),
    BOLD(1),
    ITALIC(2),
    LINK(3),
    STANDARD(4),
    STRIKETHROUGH(5),
    IMAGE(6),;
    private final int type;

    public int getType() {
        return type;
    }
    SpanElementType(int type){
        this.type = type;
    }
    public static SpanElementType getSpanElementType(int type) {
        for (SpanElementType value : SpanElementType.values()) {
            if (value.getType() == type) {
                return value;
            }
        }
        return null;
    }
}
