package live.midreamsheep.markdown.parser.element.elements.span.italic;

import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.SpanElementType;
import live.midreamsheep.markdown.parser.element.span.italic.ItalicParser;
import live.midreamsheep.markdown.parser.element.span.str.StandardSpan;
import org.junit.Test;

public class ItalicParserTest {
    @Test
    public void testParse() {
        ItalicParser italicParser = new ItalicParser();
        String markdown = "*world*";
        Span span = new Span();
        italicParser.parse(markdown.toCharArray(), 0, span);
        assert span.getChildSpans().size() == 1: "italicParserTest(*) failed: size of childSpans is not 1";
        assert ((StandardSpan)span.getChildSpans().get(0).getChildSpans().get(0)).getContent().equals("world"): "italicParserTest(*) failed: text of childSpan is not world";
        assert span.getChildSpans().get(0).getType()== SpanElementType.ITALIC: "italicParserTest(*) failed: type of childSpan is not italic";

        markdown = "_world_";
        span = new Span();
        italicParser.parse(markdown.toCharArray(), 0, span);
        assert span.getChildSpans().size() == 1: "italicParserTest(_) failed: size of childSpans is not 1";
        assert ((StandardSpan)span.getChildSpans().get(0).getChildSpans().get(0)).getContent().equals("world"): "italicParserTest(_) failed: text of childSpan is not world";
        assert span.getChildSpans().get(0).getType()== SpanElementType.ITALIC: "italicParserTest(_) failed: type of childSpan is not italic";
    }
}
