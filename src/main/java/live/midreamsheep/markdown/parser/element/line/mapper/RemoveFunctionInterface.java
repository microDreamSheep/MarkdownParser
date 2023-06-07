package live.midreamsheep.markdown.parser.element.line.mapper;

import live.midreamsheep.markdown.parser.page.MarkdownPage;

@FunctionalInterface
public interface RemoveFunctionInterface {
    void remove(MarkdownPage page, int index);
}
