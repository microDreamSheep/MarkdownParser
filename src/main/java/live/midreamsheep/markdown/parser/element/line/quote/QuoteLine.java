package live.midreamsheep.markdown.parser.element.line.quote;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.page.MarkdownPage;

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

    private final MarkdownPage page;
    @Override
    protected LineElementType SetType() {
        return LineElementType.QUOTE;
    }
    /**
     *引用行内部可以包含任意类型的行，本身是一个独立的页面，将会在行解析完后交给PageParser解析
     * @param page 引用行内部的页面
     * */
    public QuoteLine(MarkdownPage page) {
        this.page = page;
    }
    public MarkdownPage getPage() {
        return page;
    }
}
