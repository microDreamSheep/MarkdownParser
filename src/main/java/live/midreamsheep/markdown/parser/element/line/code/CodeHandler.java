package live.midreamsheep.markdown.parser.element.line.code;

import live.midreamsheep.markdown.parser.element.line.MarkdownLine;
import live.midreamsheep.markdown.parser.element.line.mapper.MarkdownLineHandlerInter;
import live.midreamsheep.markdown.parser.element.line.mapper.parser.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.element.span.str.StandardSpan;
import live.midreamsheep.markdown.parser.page.MarkdownPage;

import java.util.List;

/**
 * 代码块类型解析器
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see CodeLine
 * */
public class CodeHandler implements MarkdownLineHandlerInter {

    /**
     * 用于解析代码块节点
     * 格式为：
     * ```type
     * content
     * ```
     * */
    @Override
    public int parse(String[] lines, int index, MarkdownPage page) {
        String startLine = lines[index];
        if(startLine.trim().startsWith("```")){
            CodeLine code = new CodeLine(startLine.replace("```", ""));
            page.addNewLine(code);
            int i = index+1;
            for (; i < lines.length; i++) {
                String line = lines[i];
                if(line.trim().startsWith("```")){
                    CodeLine endLine = new CodeLine(line);
                    page.addNewLine(endLine);
                    break;
                }
                page.addNewLine(new CodeDataLine(new StandardSpan(line),code));
            }
            return i;
        }
        return -1;
    }

    @Override
    public void delete(int line, List<MarkdownLine> lines) {
        //TODO
    }

    @Override
    public boolean isMatch(String line) {
        //TODO
        return false;
    }
}
