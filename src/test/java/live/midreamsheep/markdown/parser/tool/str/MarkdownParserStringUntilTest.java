package live.midreamsheep.markdown.parser.tool.str;

import org.junit.Test;

import static live.midreamsheep.markdown.parser.tool.str.MarkdownParserStringUntil.findChar;

public class MarkdownParserStringUntilTest {

    @Test
    public void findCharTest(){
        int aChar = findChar("1234567891".toCharArray(), 0, '1');
        int aChar1 = findChar("1234567891".toCharArray(), 1, '1');
        assert aChar == 0 && aChar1 == 9 : "MarkdownParserStringUntilTest:findCharTest error";
    }

    @Test
    public void findStringInStartAndEndTest(){
        StringBuilder stringBuilder = new StringBuilder();
        MarkdownParserStringUntil.findStringInStartAndEnd("1234567891".toCharArray(),0,'2','5',stringBuilder);
        assert stringBuilder.toString().equals("34") : "MarkdownParserStringUntilTest:findStringInStartAndEndTest error";
    }

    @Test
    public void isAlwaysTest(){
        boolean always = MarkdownParserStringUntil.isAlways("1234567891".toCharArray(), '1');
        boolean always1 = MarkdownParserStringUntil.isAlways("11111111111".toCharArray(), '1');
        assert !always && always1 : "MarkdownParserStringUntilTest:isAlwaysTest error";
    }


    @Test
    public void splitTest(){
        String source = "\n\n4878\n\n45\n";
        String[] split = MarkdownParserStringUntil.split(source, '\n');
        assert split.length == 6&&split[2].equals("4878")&&split[4].equals("45") : "MarkdownParserStringUntilTest:split error";

    }
}
