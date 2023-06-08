package live.midreamsheep.markdown.parser.element.line.head;

import live.midreamsheep.markdown.parser.element.line.mapper.parser.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.element.line.mapper.update.delete.MarkdownStandardDelete;
import live.midreamsheep.markdown.parser.element.span.SpanParser;
import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.page.MarkdownPage;

/**
 * 标题类型解析器
 * @author midreamsheep
 * @see HeadLine
 * @since 2023/5/1
 * @version 1.0
 * */
public class HeadHandler extends MarkdownStandardDelete {

    /**
     * 用于解析标题节点
     * 标题格式为：
     *    # content
     *    ## content
     *    ### content
     *    #### content
     *    ##### content
     *    ###### content
     * 解析完后将会生成一个HeadLine行节点，其中包含一个Span节点，Span节点中包含标题内容，Span将会在行等级解析完后交给SpanParser解析
     * @see SpanParser
     * */
    @Override
    public int parse(String[] lines, int index, MarkdownPage page) {
        String line = lines[index];
        for (int i = 0; i < line.trim().toCharArray().length; i++) {
            if(line.charAt(i) != '#'){
                HeadLine head = new HeadLine();
                Span span = new Span();
                head.setLevel(HeadLevel.getHeadLevel(i));
                SpanParser.parse(line.substring(i),span);
                head.setContent(span);
                page.addNewLine(head);
                return index;
            }
        }
        return -1;
    }
}
