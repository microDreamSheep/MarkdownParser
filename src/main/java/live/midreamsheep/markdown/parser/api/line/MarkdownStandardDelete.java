package live.midreamsheep.markdown.parser.api.line;

import live.midreamsheep.markdown.parser.element.line.MarkdownLine;
import live.midreamsheep.markdown.parser.page.MarkdownPage;

import java.util.List;

public abstract class MarkdownStandardDelete implements MarkdownLineHandlerInter {
    @Override
    public void delete(int line, List<MarkdownLine> lines) {
        lines.remove(line-1);
    }

    @Override
    public abstract int parse(String[] lines, int index, MarkdownPage page);

    @Override
    public boolean isUpdateMatch(String content, int index, MarkdownPage page) {
        return isParseMatch(new String[]{content},0,page);
    }
}
