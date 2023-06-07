package live.midreamsheep.markdown.parser.element.line.quote;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.page.MarkdownParser;

/**
 * 引用行类型，以>开头的行，表示引用内容
 * 例如：
 *      > 这是一段引用
 *      > 这是一段引用
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see QuoteParser
 * */
public class QuoteLine extends MarkdownLineElement {

    private MarkdownLineElement line;

    private MarkdownParser page;

    private int level;

    @Override
    protected LineElementType SetType() {
        return LineElementType.QUOTE;
    }

    public MarkdownLineElement getLineElement() {
        return line;
    }

    public void setElement(MarkdownLineElement line) {
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
