package live.midreamsheep.markdown.parser.element.elements.line.standard;

import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.line.LineElementType;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;

/**
 * 普通行类型，没有特殊格式的行
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see live.midreamsheep.markdown.parser.element.elements.span.SpanParser
 * */
public class Standard extends MarkdownLineElement {
    /**
     * 默认构造器
     * @param parse 行内容，由解析器解析后传入
     * */
    public Standard(Span parse) {
        this.content = parse;
    }

    @Override
    protected LineElementType SetType() {
        return LineElementType.STANDARD;
    }
}
