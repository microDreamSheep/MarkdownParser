package live.midreamsheep.markdown.parser.page;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.mapper.MarkdownHandlerMapper;
import live.midreamsheep.markdown.parser.api.MarkdownLineHandlerInter;
import live.midreamsheep.markdown.parser.element.line.mapper.parser.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.element.line.mapper.parser.MarkdownLineParserMapper;
import live.midreamsheep.markdown.parser.element.line.standard.Standard;
import live.midreamsheep.markdown.parser.element.span.str.StandardSpan;
import live.midreamsheep.markdown.parser.tool.str.MarkdownParserStringUntil;
import lombok.AllArgsConstructor;

import java.util.*;

/**
 * 一个markdown解析的页面，由多个行元素组成，每个行元素由多个span组成，每个span由多个字符组成
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * */
@AllArgsConstructor
public class MarkdownParser {

    private Map<Character, List<MarkdownLineHandlerInter>> parseTypeHandler;
    private List<MarkdownLineHandlerInter> contextTypeHandler;

    public MarkdownPage parse(String content){
        return parse(MarkdownParserStringUntil.split(content));
    }

    /**
     * 解析markdown文本为MarkdownPages<br/>
     *     1. 遍历每一行<br/>
     *     2. 空判断<br/>
     *     3. 按上下文形式解析<br/>
     *     4. 终结符形式解析<br/>
     *     5. 标准形式解析<br/>
     * @param contents markdown文本
     *              @see MarkdownLineParserInter
     *              @see MarkdownLineParserMapper
     * page在集合中的顺序即为markdown的行号
     * */
    public MarkdownPage parse(String[] contents){
        MarkdownPage page = new MarkdownPage();
        for (int i = 0; i < contents.length; i++) {
            //空行判断
            if(exceptNull(page,contents[i])){continue;}
            //上下文解析
            MarkdownLineHandlerInter context = contextParse(page,contents,i);
            if (context!=null){
                i = context.parse(contents,i,page);
                continue;
            }
            //关键字解析
            MarkdownLineHandlerInter parse = parseParse(page,contents,i);
            if (parse!=null){
                i = parse.parse(contents,i,page);
                continue;
            }
            //解析失败，将其作为标准行解析
            MarkdownHandlerMapper.get(LineElementType.STANDARD).parse(contents,i,page);
        }

        return page;
    }

    private boolean exceptNull(MarkdownPage page,String content){
        if(content.trim().equals("")) {
            page.addNewLine(new Standard(new StandardSpan(content),""));
            return true;
        }
        return false;
    }

    private MarkdownLineHandlerInter contextParse(MarkdownPage page,String[] lines,int index){
        for (MarkdownLineHandlerInter inter : contextTypeHandler) {
            if (inter.isMatch(lines,index,page)){
                return inter;
            }
        }
        return null;
    }

    private MarkdownLineHandlerInter parseParse(MarkdownPage page,String[] lines,int index){
        char first = lines[index].trim().charAt(0);
        if (!parseTypeHandler.containsKey(first)){
            return null;
        }
        List<MarkdownLineHandlerInter> markdownLineHandlerInters = parseTypeHandler.get(first);
        for (MarkdownLineHandlerInter markdownLineHandlerInter : markdownLineHandlerInters) {
            if(markdownLineHandlerInter.isMatch(lines,index,page)){
                return markdownLineHandlerInter;
            }
        }
        return null;
    }
}
