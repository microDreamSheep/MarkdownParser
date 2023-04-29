package live.midreamsheep.markdown.parser.element;

import live.midreamsheep.markdown.parser.element.elements.line.LineElementType;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;

public abstract class MarkdownLineElement {

    protected final LineElementType type;

    protected Span content;

    protected MarkdownLineElement() {
        type = SetType();
    }

    protected abstract LineElementType SetType();

    public LineElementType getType() {
        return type;
    }

    public Span getContent() {
        return content;
    }

    public void setContent(Span content) {
        this.content = content;
    }
}
