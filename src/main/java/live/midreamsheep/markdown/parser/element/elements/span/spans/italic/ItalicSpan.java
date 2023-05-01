package live.midreamsheep.markdown.parser.element.elements.span.spans.italic;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanElementType;

/**
 * 斜体行内格式对象
 * 斜体行对象是一个Markdown行树的树节点
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see live.midreamsheep.markdown.parser.element.elements.span.spans.italic.ItalicParser
 * */
public class ItalicSpan extends Span {
    @Override
    protected SpanElementType setType() {
        return SpanElementType.ITALIC;
    }
}
