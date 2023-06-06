package live.midreamsheep.markdown.parser.page;

import live.midreamsheep.markdown.parser.element.line.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.element.line.MarkdownLineParserMapper;
import live.midreamsheep.markdown.parser.element.line.standard.Standard;
import live.midreamsheep.markdown.parser.element.span.SpanParser;
import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.str.StandardSpan;

/**
 * 一个markdown解析的页面，由多个行元素组成，每个行元素由多个span组成，每个span由多个字符组成
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * */
public class MarkdownPage {
    private final MarkdownPages elements = new MarkdownPages();
    /**
     * 解析markdown文本为MarkdownPages
     *     1. 遍历每一行
     *     2. 判断首个非空字符
     *     3. 根据首个非空字符调用对应的解析器
     *     4. 解析器解析后返回下一行的行号
     *     5. 重复2-4
     * @param lines markdown文本
     *              @see MarkdownLineParserInter
     *              @see MarkdownLineParserMapper
     * elements在集合中的顺序即为markdown的行号
     * */
    public void parse(String[] lines){
        for (int i = 0; i < lines.length; i++) {
            //获取首个非空字符
            if(lines[i].trim().equals("")){
                elements.addNewLine(new Standard(new StandardSpan(lines[i])));//空行
                continue;
            }
            char firstChar = lines[i].trim().charAt(0);
            MarkdownLineParserInter markdownLineParserInter = MarkdownLineParserMapper.get(String.valueOf(firstChar));
            if(markdownLineParserInter == null){
                elements.addNewLine(new Standard(SpanParser.parse(lines[i],new Span())));
                continue;
            }
            int result = MarkdownLineParserMapper.get(String.valueOf(firstChar)).parse(lines, i,elements);
            if(result==-1){
                elements.addNewLine(new Standard(SpanParser.parse(lines[i],new Span())));
                continue;
            }
            i = result;
        }
    }
    public MarkdownPages getPages() {
        return elements;
    }

}
