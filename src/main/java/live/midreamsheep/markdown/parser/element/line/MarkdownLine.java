package live.midreamsheep.markdown.parser.element.line;

import live.midreamsheep.markdown.parser.api.line.parse.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.element.span.Span;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * 行对象抽象类
 * 用于存储行对象的类型和内容
 * 由于行对象的类型和内容都是不可变的，所以使用抽象类
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see MarkdownLineParserInter
 * */
@Getter
@Setter
public abstract class MarkdownLine {

    //行类型
    @Setter(AccessLevel.NONE)
    protected LineElementType type;

    //行内内容
    protected Span content;

    //源内容
    protected String lineContent;

    /**
     * 默认构造器
     * 调用抽象方法SetType()方法设置type
     * */
    protected MarkdownLine() {
        type = SetType();
    }
    /**
     * 抽象方法，用于子类重写，设置格式类型
     * @return type
     * */
    protected abstract LineElementType SetType();

}
