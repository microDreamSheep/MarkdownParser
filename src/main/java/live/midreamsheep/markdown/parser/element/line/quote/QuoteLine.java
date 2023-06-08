package live.midreamsheep.markdown.parser.element.line.quote;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.MarkdownLine;
import live.midreamsheep.markdown.parser.page.MarkdownParser;

/**
 * 引用行类型，以>开头的行，表示引用内容
 * 例如：
 *      > 这是一段引用
 *      > 这是一段引用
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see QuoteHandler
 * */
public class QuoteLine extends MarkdownLine {

    private MarkdownLine line;

    private MarkdownParser page;

    private int level;

    @Override
    protected LineElementType SetType() {
        return LineElementType.QUOTE;
    }

    public MarkdownLine getLineElement() {
        return line;
    }

    public void setElement(MarkdownLine line) {
        this.line = line;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public MarkdownParser getPage() {
        return page;
    }

    public void setPage(MarkdownParser page) {
        this.page = page;
    }
}
