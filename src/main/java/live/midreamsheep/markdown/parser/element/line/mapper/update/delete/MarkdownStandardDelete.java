package live.midreamsheep.markdown.parser.element.line.mapper.update.delete;

import live.midreamsheep.markdown.parser.element.line.MarkdownLine;
import live.midreamsheep.markdown.parser.element.line.mapper.MarkdownLineHandlerInter;
import live.midreamsheep.markdown.parser.page.MarkdownPage;

import java.util.List;

public abstract class MarkdownStandardDelete implements MarkdownLineHandlerInter {
    @Override
    public void delete(int line, List<MarkdownLine> lines) {
        lines.remove(line-1);
    }

    @Override
    public abstract int parse(String[] lines, int index, MarkdownPage page);
}
