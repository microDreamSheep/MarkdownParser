package live.midreamsheep.markdown.parser.element.line.quote;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.MarkdownLine;
import live.midreamsheep.markdown.parser.element.line.mapper.MarkdownLineHandlerInter;
import live.midreamsheep.markdown.parser.page.MarkdownParser;
import live.midreamsheep.markdown.parser.page.MarkdownPage;

import java.util.LinkedList;
import java.util.List;

/**
 * 引用行解析器
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see QuoteLine
 * @see MarkdownParser
 * */
public class QuoteHandler implements MarkdownLineHandlerInter {

    /**
     * 解析引用行
     * 引用行格式为：
     *   > content
     *   > content
     *引用行内部可以包含任意类型的行，本身是一个独立的页面，将会在行解析完后交给PageParser解析
     * */
    @Override
    public int parse(String[] lines, int index, MarkdownPage page) {
        int result = index;
        List<String> lineList = new LinkedList<>();
        while (result < lines.length){
            char[] chars = lines[result].trim().toCharArray();
            boolean isStartWithQuote = ((chars.length > 2 && chars[0] == '>'&&chars[1] == ' ')||(chars.length == 1&&chars[0] == '>'));
            if(!(isStartWithQuote)){
                break;
            }
            result++;
            if(lines[result].trim().length()>2) {
                lineList.add(lines[result].trim().substring(2));
                continue;
            }
            lineList.add("");
        }
        if(lineList.size() == 0){
            return -1;
        }
        MarkdownParser markdownPage = new MarkdownParser();
        setQuote(page,markdownPage.parse(lineList.toArray(new String[0])).getLines());
        return result-1;
    }

    //计算引用的层级
    private void setQuote(MarkdownPage rootPage, List<MarkdownLine> page){
        for (MarkdownLine element : page) {
            QuoteLine quoteLine = new QuoteLine();
            int level = 1;
            if(element.getType() == LineElementType.QUOTE){
                QuoteLine quote = (QuoteLine) element;
                level = quote.getLevel()+1;
            }
            quoteLine.setLevel(level);
            quoteLine.setElement(element);
            rootPage.addNewLine(quoteLine);
        }
    }

    @Override
    public void delete(int line, List<MarkdownLine> lines) {
        //TODO
    }

    @Override
    public boolean isMatch(String[] lines, int index, MarkdownPage page) {
        return lines[index].trim().startsWith(">");
    }
}
