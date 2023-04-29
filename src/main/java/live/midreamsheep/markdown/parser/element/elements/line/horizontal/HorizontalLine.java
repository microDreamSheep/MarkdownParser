package live.midreamsheep.markdown.parser.element.elements.line.horizontal;

import live.midreamsheep.markdown.parser.element.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.line.LineElementType;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;

public class HorizontalLine extends MarkdownLineElement {

    @Override
    protected LineElementType SetType() {
        return LineElementType.HORIZONTAL;
    }

    @Override
    public Span getContent() {
        return super.getContent();
    }

    @Override
    public void setContent(Span content) {
        super.setContent(content);
    }
}
