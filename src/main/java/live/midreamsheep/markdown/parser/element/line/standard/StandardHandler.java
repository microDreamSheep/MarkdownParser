package live.midreamsheep.markdown.parser.element.line.standard;

import live.midreamsheep.markdown.parser.api.line.MarkdownStandardDelete;
import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.SpanParser;
import live.midreamsheep.markdown.parser.page.MarkdownPage;

public class StandardHandler extends MarkdownStandardDelete {
    @Override
    public int parse(String[] lines, int index, MarkdownPage page) {
        page.addNewLine(new Standard(SpanParser.parse(lines[index],new Span()),lines[index]));
        return index+1;
    }

    @Override
    public boolean isParseMatch(String[] lines, int index, MarkdownPage page) {
        return true;
    }

    @Override
    public boolean update(String content, int index, MarkdownPage page) {
        page.addNewLine(index,new Standard(SpanParser.parse(content,new Span()),content));
        return true;
    }

}
