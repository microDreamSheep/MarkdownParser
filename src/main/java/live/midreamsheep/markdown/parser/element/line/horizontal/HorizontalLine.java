package live.midreamsheep.markdown.parser.element.line.horizontal;

import live.midreamsheep.markdown.parser.element.line.MarkdownLine;
import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.mapper.parser.MarkdownLineParserMapper;
import live.midreamsheep.markdown.parser.element.span.Span;

/**
 * 分割线类型
 * 分割线格式为：
 *      ---
 *      ***
 *      ___
 * 解析器由lambda表达式实现，不需要单独的解析器
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see MarkdownLineParserMapper
 * */
public class HorizontalLine extends MarkdownLine {

    public HorizontalLine(String lineContent) {
        this.lineContent = lineContent;
    }

    @Override
    protected LineElementType SetType() {
        return LineElementType.HORIZONTAL;
    }

    /**
     * 分割线没有内容，返回null
     * 重写父类方法返回null
     * @return null
     * */
    @Override
    public Span getContent() {return null;}

    /**
     * 分割线没有内容，不需要设置内容
     * 重写父类方法留空
     * */
    @Override
    public void setContent(Span content) {}
}
