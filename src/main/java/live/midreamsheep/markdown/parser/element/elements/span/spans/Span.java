package live.midreamsheep.markdown.parser.element.elements.span.spans;

import java.util.LinkedList;
import java.util.List;

/**
 * 行内元素公共父类
 * 用于存储行内元素的公共属性和方法，一般作为一个行内对象的树节点
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see live.midreamsheep.markdown.parser.element.elements.span.SpanParser
 * @see live.midreamsheep.markdown.parser.element.elements.span.spans.SpanParserMapper
 * */
public class Span{

    protected SpanElementType type;
    protected final List<Span> childSpans = new LinkedList<>();
    /**
     * 字面上的意思，用于构建树，不解释
     * childSpans是对子节点的引用
     * */
    public Span addChildSpan(Span child){
        childSpans.add(child);
        return this;
    }

    public SpanElementType getType() {
        return type;
    }

    public List<Span> getChildSpans() {
        return childSpans;
    }

    @Override
    public String toString() {
        return "Span{" +
                "type=" + type +
                ", childSpans=" + childSpans +
                '}';
    }
    /**
     * 设置行内元素类型
     * 子类必须重写此方法
     * @return type
     * */
    protected SpanElementType setType(){
        return SpanElementType.COMPOSITION;
    }
    /**
     * 默认构造器
     * 调用抽象方法SetType()方法设置type
     * */
    public Span(){
        type = setType();
    }
}
