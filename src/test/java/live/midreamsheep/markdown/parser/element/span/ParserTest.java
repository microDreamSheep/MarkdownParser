package live.midreamsheep.markdown.parser.element.span;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParserTest {
    @Test
    public void parserTest() throws IOException {
        InputStream is = Files.newInputStream(Paths.get("D:\\mine\\临时文件\\test.md"));
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = is.read()) != -1) {
            sb.append((char) ch);
        }
        String markdown = sb.toString();


    }
}
