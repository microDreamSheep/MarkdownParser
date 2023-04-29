package live.midreamsheep.markdown.parser;

import live.midreamsheep.markdown.parser.page.MarkdownPage;

public class MarkdownParser {
    public static MarkdownPage parse(String markdown) {
        MarkdownPage page = new MarkdownPage();
        page.parse(markdown.split("\n"));
        return page;
    }
}
