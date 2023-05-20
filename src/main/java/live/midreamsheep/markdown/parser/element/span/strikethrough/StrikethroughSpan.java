package live.midreamsheep.markdown.parser.element.span.strikethrough;

import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.SpanElementType;

/**
 * 删除线行内格式对象
 * 删除线行对象是一个Markdown行树的树节点
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see StrikethroughParser
 * */
public class StrikethroughSpan extends Span {
    @Override
    protected SpanElementType setType() {
        return SpanElementType.STRIKETHROUGH;
    }
}
