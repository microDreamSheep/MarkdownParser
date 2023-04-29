package live.midreamsheep.markdown.parser.element.elements.span.spans.italic;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanElementType;

public class ItalicSpan extends Span {
    @Override
    protected SpanElementType setType() {
        return SpanElementType.ITALIC;
    }
}
