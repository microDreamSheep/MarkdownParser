package live.midreamsheep.markdown.parser.element.elements.span.spans;

/**
 * 行内格式枚举类
 * 用于标识行内格式的类型
 * 主要的行内格式有：
 *      1. 加粗
 *      2. 斜体
 *      3. 链接
 *      4. 删除线
 *      5. 图片
 *      6. 普通字符串
 * @see live.midreamsheep.markdown.parser.element.elements.span.spans.bold.BoldSpan
 * @see live.midreamsheep.markdown.parser.element.elements.span.spans.italic.ItalicSpan
 * @see live.midreamsheep.markdown.parser.element.elements.span.spans.link.LinkSpan
 * @see live.midreamsheep.markdown.parser.element.elements.span.spans.strikethrough.StrikethroughSpan
 * @see live.midreamsheep.markdown.parser.element.elements.span.spans.image.ImageSpan
 * @see live.midreamsheep.markdown.parser.element.elements.span.spans.str.StandardSpan
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see live.midreamsheep.markdown.parser.element.elements.span.SpanParser
 * */
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
