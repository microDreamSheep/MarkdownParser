package live.midreamsheep.markdown.parser.element.line.horizontal;

import live.midreamsheep.markdown.parser.element.line.mapper.update.delete.MarkdownStandardDelete;
import live.midreamsheep.markdown.parser.page.MarkdownPage;
import live.midreamsheep.markdown.parser.tool.str.MarkdownParserStringUntil;

public class HorizontalHandler extends MarkdownStandardDelete {
    @Override
    public int parse(String[] lines, int index, MarkdownPage page) {
        page.addNewLine(new HorizontalLine(lines[index]));
        return index+1;
    }

    @Override
    public boolean isMatch(String[] lines, int index, MarkdownPage page) {
        return MarkdownParserStringUntil.isAlways(lines[index].toCharArray(),'-')||
                MarkdownParserStringUntil.isAlways(lines[index].toCharArray(),'_')||
                MarkdownParserStringUntil.isAlways(lines[index].toCharArray(),'*');
    }
}
