package live.midreamsheep.markdown.parser.element.elements.line.head;

import live.midreamsheep.markdown.parser.element.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.element.elements.span.SpanParser;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;

import java.util.List;

public class HeadParser implements MarkdownLineParserInter {

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
