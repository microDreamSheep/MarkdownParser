package live.midreamsheep.markdown.parser.element.elements.line.code;

import live.midreamsheep.markdown.parser.element.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.str.StandardSpan;

import java.util.List;

public class CodeParser implements MarkdownLineParserInter {
    @Override
    public int parse(String[] lines, int index, List<MarkdownLineElement> elements) {
        String startLine = lines[index];
        if(startLine.trim().startsWith("```")){
            CodeLine code = new CodeLine();
            Span span = new Span();
            code.setContent(span);
            int i = index+1;
            for (; i < lines.length; i++) {
                String line = lines[i];
                if(line.trim().startsWith("```")){
                    break;
                }
                span.addChildSpan(new StandardSpan(line));
            }
            elements.add(code);
            return i;
        }
        return -1;
    }
}
