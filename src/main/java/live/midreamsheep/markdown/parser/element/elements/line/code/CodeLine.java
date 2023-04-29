package live.midreamsheep.markdown.parser.element.elements.line.code;

import live.midreamsheep.markdown.parser.element.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.line.LineElementType;

public class CodeLine extends MarkdownLineElement {
    @Override
    protected LineElementType SetType() {
        return LineElementType.CODE;
    }
}
