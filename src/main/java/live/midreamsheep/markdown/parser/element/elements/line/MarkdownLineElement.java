package live.midreamsheep.markdown.parser.element.elements.line;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;

/**
 * 行对象抽象类
 * 用于存储行对象的类型和内容
 * 由于行对象的类型和内容都是不可变的，所以使用抽象类
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineParserMapper
 * @see live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineParserInter
 * */
public abstract class MarkdownLineElement {

    protected final LineElementType type;

    protected Span content;

    /**
     * 默认构造器
     * 调用抽象方法SetType()方法设置type
     * */
    protected MarkdownLineElement() {
        type = SetType();
    }
    /**
     * 抽象方法，用于子类重写，设置格式类型
     * @return type
     * */
    protected abstract LineElementType SetType();

    public LineElementType getType() {
        return type;
    }

    public Span getContent() {
        return content;
    }
    /**
     * 设置行内内容
     * */
    public void setContent(Span content) {
        this.content = content;
    }
}
