package live.midreamsheep.markdown.parser.element.elements.line.head;

import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.element.elements.span.SpanParser;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;

import java.util.List;

/**
 * 标题类型解析器
 * @author midreamsheep
 * @see live.midreamsheep.markdown.parser.element.elements.line.head.HeadLine
 * @since 2023/5/1
 * @version 1.0
 * */
public class HeadParser implements MarkdownLineParserInter {

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
     * @see live.midreamsheep.markdown.parser.element.elements.span.SpanParser
     * */
    @Override
    public int parse(String[] lines, int index, List<MarkdownLineElement> elements) {
        String line = lines[index];
        for (int i = 0; i < line.trim().toCharArray().length; i++) {
            if(line.charAt(i) != '#'){
                HeadLine head = new HeadLine();
                Span span = new Span();
                head.setLevel(HeadLevel.getHeadLevel(i));
                SpanParser.parse(line.substring(i),span);
                head.setContent(span);
                elements.add(head);
                return index;
            }
        }
        return -1;
    }
}
