package live.midreamsheep.markdown.parser.element.span.bold;

import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.SpanElementType;

/**
 * 加粗行内格式对象
 * 加粗行对象是一个Markdown行树的树节点
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see BoldParser
 * */
public class BoldSpan extends Span {
    @Override
    protected SpanElementType setType() {
        return SpanElementType.BOLD;
    }
}
