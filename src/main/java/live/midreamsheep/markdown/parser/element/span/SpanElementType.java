package live.midreamsheep.markdown.parser.element.span;

import live.midreamsheep.markdown.parser.element.span.bold.BoldSpan;
import live.midreamsheep.markdown.parser.element.span.image.ImageSpan;
import live.midreamsheep.markdown.parser.element.span.italic.ItalicSpan;
import live.midreamsheep.markdown.parser.element.span.link.LinkSpan;
import live.midreamsheep.markdown.parser.element.span.str.StandardSpan;
import live.midreamsheep.markdown.parser.element.span.strikethrough.StrikethroughSpan;

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
 * @see BoldSpan
 * @see ItalicSpan
 * @see LinkSpan
 * @see StrikethroughSpan
 * @see ImageSpan
 * @see StandardSpan
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see SpanParser
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
