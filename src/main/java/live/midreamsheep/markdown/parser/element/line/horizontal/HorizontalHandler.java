package live.midreamsheep.markdown.parser.element.line.horizontal;

import live.midreamsheep.markdown.parser.element.line.mapper.update.delete.MarkdownStandardDelete;
import live.midreamsheep.markdown.parser.page.MarkdownPage;

public class HorizontalHandler extends MarkdownStandardDelete {
    @Override
    public int parse(String[] lines, int index, MarkdownPage page) {
        return 0;
    }

    @Override
    public boolean isMatch(String line) {
        // TODO
        return false;
    }
}
