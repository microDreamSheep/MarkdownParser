package live.midreamsheep.markdown.parser.element.line.standard;

import live.midreamsheep.markdown.parser.element.line.mapper.update.delete.MarkdownStandardDelete;
import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.SpanParser;
import live.midreamsheep.markdown.parser.page.MarkdownPage;

public class StandardHandler extends MarkdownStandardDelete {
    @Override
    public int parse(String[] lines, int index, MarkdownPage page) {
        page.addNewLine(new Standard(SpanParser.parse(lines[index],new Span())));
        return index+1;
    }

    @Override
    public boolean isMatch(String[] lines, int index, MarkdownPage page) {
        return true;
    }
}
