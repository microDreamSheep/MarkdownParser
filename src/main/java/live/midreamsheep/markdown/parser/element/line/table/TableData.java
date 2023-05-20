package live.midreamsheep.markdown.parser.element.line.table;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.MarkdownLineElement;

public class TableData extends MarkdownLineElement {

    @Override
    protected LineElementType SetType() {
        return null;
    }
    public TableData(LineElementType type) {
        super();
        this.type = type==null?LineElementType.TABLE_BODY:type;
    }
}
