package live.midreamsheep.markdown.parser.element.elements.span.spans;

import java.util.LinkedList;
import java.util.List;

public class Span{

    protected SpanElementType type;
    protected final List<Span> childSpans = new LinkedList<>();
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
    protected SpanElementType setType(){
        return SpanElementType.COMPOSITION;
    }
    public Span(){
        type = setType();
    }
}
