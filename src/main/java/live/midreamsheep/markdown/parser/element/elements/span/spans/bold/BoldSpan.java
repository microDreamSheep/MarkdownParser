package live.midreamsheep.markdown.parser.element.elements.span.spans.bold;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanElementType;

public class BoldSpan extends Span {
    @Override
    protected SpanElementType setType() {
        return SpanElementType.BOLD;
    }
}
