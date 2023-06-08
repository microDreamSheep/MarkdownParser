package live.midreamsheep.markdown.parser.element.span.strikethrough;

import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.SpanElementType;
import live.midreamsheep.markdown.parser.element.span.str.StandardSpan;
import live.midreamsheep.markdown.parser.element.span.strikethrough.StrikethroughParser;
import org.junit.Test;

public class StrikethroughParserTest {
    @Test
    public void strikethroughParserTest() {
        String markdown = "~~hello~~";
        StrikethroughParser strikethroughParser = new StrikethroughParser();
        Span span = new Span();
        strikethroughParser.parse(markdown.toCharArray(), 0, span);
        assert span.getChildSpans().size() == 1: "strikethroughParserTest failed: size of childSpans is not 1";
        assert ((StandardSpan)span.getChildSpans().get(0).getChildSpans().get(0)).getContent().equals("hello"): "strikethroughParserTest failed: text of childSpan is not hello";
        assert span.getChildSpans().get(0).getType()== SpanElementType.STRIKETHROUGH: "strikethroughParserTest failed: type of childSpan is not strikethrough";
    }
}
