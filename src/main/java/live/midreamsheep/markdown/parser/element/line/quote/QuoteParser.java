package live.midreamsheep.markdown.parser.element.line.quote;

import live.midreamsheep.markdown.parser.element.line.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.page.MarkdownPage;
import live.midreamsheep.markdown.parser.page.MarkdownPages;

import java.util.LinkedList;
import java.util.List;

/**
 * 引用行解析器
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see QuoteLine
 * @see MarkdownPage
 * */
public class QuoteParser implements MarkdownLineParserInter {

    /**
     * 解析引用行
     * 引用行格式为：
     *   > content
     *   > content
     *引用行内部可以包含任意类型的行，本身是一个独立的页面，将会在行解析完后交给PageParser解析
     * */
    @Override
    public int parse(String[] lines, int index, MarkdownPages elements) {
        int result = index;
        List<String> lineList = new LinkedList<>();
        while (result < lines.length){
            char[] chars = lines[result].trim().toCharArray();
            if(!((chars.length > 2 && chars[0] == '>'&&chars[1] == ' ')||(chars.length == 1&&chars[0] == '>'))){
                break;
            }
            if(lines[result].trim().length()>2) {
                lineList.add(lines[result].trim().substring(2));
            }else{
                lineList.add("");
            }
            result++;
        }
        if(lineList.size() > 0){
            MarkdownPage subPage = new MarkdownPage();
            QuoteLine quote = new QuoteLine(subPage);
            subPage.parse(lineList.toArray(new String[0]));
            elements.addNewLine(quote);
        }
        return result-1;
    }
}
