package live.midreamsheep.markdown.parser.page;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.mapper.MarkdownHandlerMapper;
import live.midreamsheep.markdown.parser.element.line.mapper.MarkdownLineHandlerInter;
import live.midreamsheep.markdown.parser.element.line.mapper.parser.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.element.line.mapper.parser.MarkdownLineParserMapper;
import live.midreamsheep.markdown.parser.element.line.standard.Standard;
import live.midreamsheep.markdown.parser.element.span.str.StandardSpan;
import live.midreamsheep.markdown.parser.tool.str.MarkdownParserStringUntil;

/**
 * 一个markdown解析的页面，由多个行元素组成，每个行元素由多个span组成，每个span由多个字符组成
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * */
public class MarkdownParser {

    public MarkdownPage parse(String content){
        return parse(MarkdownParserStringUntil.split(content));
    }

    /**
     * 解析markdown文本为MarkdownPages
     *     1. 遍历每一行
     *     2. 判断首个非空字符
     *     3. 根据首个非空字符调用对应的解析器
     *     4. 解析器解析后返回下一行的行号
     *     5. 重复2-4
     * @param contents markdown文本
     *              @see MarkdownLineParserInter
     *              @see MarkdownLineParserMapper
     * page在集合中的顺序即为markdown的行号
     * */
    public MarkdownPage parse(String[] contents){
        MarkdownPage page = new MarkdownPage();
        for (int i = 0; i < contents.length; i++) {

            //获取首个非空字符
            if(contents[i].trim().equals("")){
                page.addNewLine(new Standard(new StandardSpan(contents[i]),""));//空行
                continue;
            }
            char firstChar = contents[i].trim().charAt(0);
            //获取对应的解析器
            MarkdownLineHandlerInter markdownLineParserInter = MarkdownHandlerMapper.get(LineElementType.STANDARD);
            for (MarkdownLineHandlerInter lineParserInter : MarkdownLineParserMapper.get(String.valueOf(firstChar))) {
                if(!lineParserInter.isMatch(contents,i,page)){
                    continue;
                }
                markdownLineParserInter = lineParserInter;
                break;
            }
            //解析
            int result = markdownLineParserInter.parse(contents, i,page);
            //结果为-1则说明解析失败，将其作为标准行解析
            if(result==-1){
                MarkdownHandlerMapper.get(LineElementType.STANDARD).parse(contents,i,page);
                continue;
            }
            //解析成功，将行号移动到解析成功的行
            i = result;
        }

        return page;
    }

}
