package live.midreamsheep.markdown.parser.element.line.mapper;

import live.midreamsheep.markdown.parser.page.MarkdownPages;

@FunctionalInterface
public interface RemoveFunctionInterface {
    void remove(MarkdownPages page, int index);
}
