package live.midreamsheep.markdown.parser.element.elements.line.code;

import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.str.StandardSpan;
import live.midreamsheep.markdown.parser.page.MarkdownPages;

import java.util.List;

/**
 * 代码块类型解析器
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see live.midreamsheep.markdown.parser.element.elements.line.code.CodeLine
 * */
public class CodeParser implements MarkdownLineParserInter {

    /**
     * 用于解析代码块节点
     * 格式为：
     * ```type
     * content
     * ```
     * */
    @Override
    public int parse(String[] lines, int index, MarkdownPages elements) {
        String startLine = lines[index];
        if(startLine.trim().startsWith("```")){
            CodeLine code = new CodeLine(startLine.replace("```", ""));
            int i = index+1;
            for (; i < lines.length; i++) {
                String line = lines[i];
                if(line.trim().startsWith("```")){
                    break;
                }
                elements.addNewLine(new CodeDataLine(new StandardSpan(line),code));
            }
            elements.addNewLine(code);
            return i;
        }
        return -1;
    }
}
