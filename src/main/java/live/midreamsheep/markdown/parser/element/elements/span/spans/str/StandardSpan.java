package live.midreamsheep.markdown.parser.element.elements.span.spans.str;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanElementType;

/**
 * 普通行内格式对象，没有特殊格式的行内格式对象，将会被解析为普通字符串
 * 普通行对象是一个Markdown行树的叶子节点
 * 解析器由{@link live.midreamsheep.markdown.parser.element.elements.span.SpanParser}的addStrSpan实现
 * @see live.midreamsheep.markdown.parser.element.elements.span.SpanParser
 * @see live.midreamsheep.markdown.parser.element.elements.span.spans.SpanParserMapper
 * */
public class StandardSpan extends Span {

    private final String content;
    /**
     * 默认构造器
     * @param content 行内容，由解析器解析后传入
     * */
    public StandardSpan(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    protected SpanElementType setType() {
        return SpanElementType.STANDARD;
    }
}
