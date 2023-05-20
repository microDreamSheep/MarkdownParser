package live.midreamsheep.markdown.parser.element.span.str;

import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.SpanElementType;
import live.midreamsheep.markdown.parser.element.span.SpanParser;
import live.midreamsheep.markdown.parser.element.span.SpanParserMapper;

/**
 * 普通行内格式对象，没有特殊格式的行内格式对象，将会被解析为普通字符串
 * 普通行对象是一个Markdown行树的叶子节点
 * 解析器由{@link SpanParser}的addStrSpan实现
 * @see SpanParser
 * @see SpanParserMapper
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
