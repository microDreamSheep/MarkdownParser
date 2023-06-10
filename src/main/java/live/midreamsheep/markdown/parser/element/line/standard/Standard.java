package live.midreamsheep.markdown.parser.element.line.standard;

import live.midreamsheep.markdown.parser.element.line.MarkdownLine;
import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.span.SpanParser;
import live.midreamsheep.markdown.parser.element.span.Span;

/**
 * 普通行类型，没有特殊格式的行
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see SpanParser
 * */
public class Standard extends MarkdownLine {
    /**
     * 默认构造器
     * @param parse 行内容，由解析器解析后传入
     * */
    public Standard(Span parse,String lineContent) {
        this.content = parse;
        this.lineContent = lineContent;
    }

    @Override
    protected LineElementType SetType() {
        return LineElementType.STANDARD;
    }
}
