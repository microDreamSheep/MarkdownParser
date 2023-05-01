package live.midreamsheep.markdown.parser.element.elements.span.spans;

import live.midreamsheep.markdown.parser.MarkdownParser;
import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.page.MarkdownPage;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ParserTest {
    @Test
    public void parserTest() throws IOException {
        InputStream is = Files.newInputStream(Paths.get(""));
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = is.read()) != -1) {
            sb.append((char) ch);
        }
        String markdown = sb.toString();
        MarkdownPage page = MarkdownParser.parse(markdown);
        List<MarkdownLineElement> elements = page.getElements();
    }
}
