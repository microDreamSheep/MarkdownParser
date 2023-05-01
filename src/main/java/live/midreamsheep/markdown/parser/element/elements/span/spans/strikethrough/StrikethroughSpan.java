package live.midreamsheep.markdown.parser.element.elements.span.spans.strikethrough;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanElementType;

/**
 * 删除线行内格式对象
 * 删除线行对象是一个Markdown行树的树节点
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see live.midreamsheep.markdown.parser.element.elements.span.spans.strikethrough.StrikethroughParser
 * */
public class StrikethroughSpan extends Span {
    @Override
    protected SpanElementType setType() {
        return SpanElementType.STRIKETHROUGH;
    }
}
