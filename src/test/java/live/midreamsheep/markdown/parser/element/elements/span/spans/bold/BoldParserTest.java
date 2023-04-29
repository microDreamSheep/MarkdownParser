package live.midreamsheep.markdown.parser.element.elements.span.spans.bold;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import org.junit.Test;

public class BoldParserTest {
    @Test
    public void ParserTest(){
        BoldParser boldParser = new BoldParser();
        String markdown = "hello **world**";
        Span span = new Span();
        int parse = boldParser.parse(markdown.toCharArray(), 6, span);
        System.out.println(parse);
        System.out.println(span);

    }
}
