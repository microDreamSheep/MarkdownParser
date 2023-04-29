package live.midreamsheep.markdown.parser.element.elements.line.head;

import live.midreamsheep.markdown.parser.element.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.line.LineElementType;

public class HeadLine extends MarkdownLineElement {
    private HeadLevel level;

    public HeadLevel getLevel() {
        return level;
    }

    public void setLevel(HeadLevel level) {
        this.level = level;
    }

    @Override
    protected LineElementType SetType() {
        return LineElementType.HEAD;
    }
}
