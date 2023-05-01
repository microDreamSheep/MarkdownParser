package live.midreamsheep.markdown.parser.element.elements.span.spans;

import live.midreamsheep.markdown.parser.MarkdownParser;
import org.junit.Test;

public class ParserTest {
    @Test
    public void parserTest() {
        Span span = new Span();
        MarkdownParser.parse(
                "\n|hello|dawd|\n" +
                "|:--:|:---|\n" +
                "|**asdsda**|阿斯顿萨asd达|\n" +
                "|dsa||\n" +
                "|asd|asd|dsad|asdsads|"+
                "> sadsad\n" +
                        ">\n" +
                        "> hello **word** _你好_ \n" +
                        ">\n" +
                        "> > ```java\n" +
                        "> > 和嗯咯哦按实际的撒旦\n" +
                        "> > ```\n" +
                        ">\n" +
                        "> > asdsdad\n" +
                        ">\n" +
                        "> > [百度](www.baidu.com \"百度\")");
    }
}
