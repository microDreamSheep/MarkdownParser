package live.midreamsheep.markdown.parser.element.elements.line.sdandard;

import live.midreamsheep.markdown.parser.element.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.line.LineElementType;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;

public class Standard extends MarkdownLineElement {

    public Standard(Span parse) {
        this.content = parse;
    }

    @Override
    protected LineElementType SetType() {
        return LineElementType.STANDARD;
    }
}
