package live.midreamsheep.markdown.parser.element.elements.span.spans.strikethrough;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanElementType;

public class StrikethroughSpan extends Span {
    @Override
    protected SpanElementType setType() {
        return SpanElementType.STRIKETHROUGH;
    }
}
