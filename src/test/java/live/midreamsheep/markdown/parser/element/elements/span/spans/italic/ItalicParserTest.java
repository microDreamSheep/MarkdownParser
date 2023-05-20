package live.midreamsheep.markdown.parser.element.elements.span.spans.italic;

import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.italic.ItalicParser;
import org.junit.Test;

public class ItalicParserTest {
    @Test
    public void testParse() {
        ItalicParser boldParser = new ItalicParser();
        String markdown = "hello *world*";
        Span span = new Span();
        int parse = boldParser.parse(markdown.toCharArray(), 6, span);
        System.out.println(parse);
        System.out.println(span);
    }
}
