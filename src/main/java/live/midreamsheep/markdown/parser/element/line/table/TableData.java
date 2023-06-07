package live.midreamsheep.markdown.parser.element.line.table;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.MarkdownLine;
import live.midreamsheep.markdown.parser.element.span.Span;

public class TableData extends MarkdownLine {

    private Span[] data;

    public int getLength() {
        return data.length;
    }

    public Span[] getData() {
        return data;
    }

    public void setData(Span[] data) {
        this.data = data;
    }

    public TableData(Span[] data,LineElementType type) {
        super();
        setData(data);
        this.type = type==null?LineElementType.TABLE_BODY:type;
    }

    @Override
    protected LineElementType SetType() {
        return LineElementType.TABLE_HEAD;
    }
}
