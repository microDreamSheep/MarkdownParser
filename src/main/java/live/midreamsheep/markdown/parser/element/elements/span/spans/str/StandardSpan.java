package live.midreamsheep.markdown.parser.element.elements.span.spans.str;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanElementType;

public class StandardSpan extends Span {
    private final String content;
    public StandardSpan(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    protected SpanElementType setType() {
        return SpanElementType.STANDARD;
    }
}
