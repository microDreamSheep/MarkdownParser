package live.midreamsheep.markdown.parser.element.span.italic;

import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.SpanElementType;

/**
 * 斜体行内格式对象
 * 斜体行对象是一个Markdown行树的树节点
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see ItalicParser
 * */
public class ItalicSpan extends Span {
    @Override
    protected SpanElementType setType() {
        return SpanElementType.ITALIC;
    }
}
