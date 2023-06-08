package live.midreamsheep.markdown.parser.element.span.bold;

import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.SpanElementType;
import live.midreamsheep.markdown.parser.element.span.bold.BoldParser;
import live.midreamsheep.markdown.parser.element.span.str.StandardSpan;
import org.junit.Test;

import java.util.List;

public class BoldParserTest {
    @Test
    public void ParserTest(){
        BoldParser boldParser = new BoldParser();
        String markdown = "__hello__";
        Span span = new Span();
        boldParser.parse(markdown.toCharArray(), 0, span);
        List<Span> childSpans = span.getChildSpans();
        assert childSpans.size() == 1 : "boldParser(_) parse error:length of childSpans is not 1";
        assert ((StandardSpan)childSpans.get(0).getChildSpans().get(0)).getContent().equals("hello") : "boldParser(_) parse error:childSpans[0] is not hello";
        assert childSpans.get(0).getType()== SpanElementType.BOLD : "boldParser(_) parse error:childSpans[0] is not SpanElementType.BOLD";

        markdown = "**hello**";
        span = new Span();
        boldParser.parse(markdown.toCharArray(), 0, span);
        childSpans = span.getChildSpans();
        assert childSpans.size() == 1 : "boldParser(*) parse error:length of childSpans is not 1";
        assert ((StandardSpan)childSpans.get(0).getChildSpans().get(0)).getContent().equals("hello") : "boldParser(*) parse error:childSpans[0] is not hello";
        assert childSpans.get(0).getType()== SpanElementType.BOLD : "boldParser(*) parse error:childSpans[0] is not SpanElementType.BOLD";
    }
}
