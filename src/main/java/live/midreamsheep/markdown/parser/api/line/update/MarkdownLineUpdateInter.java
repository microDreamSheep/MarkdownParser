package live.midreamsheep.markdown.parser.api.line.update;

import live.midreamsheep.markdown.parser.page.MarkdownPage;
/**
 * TODO
 * */
public interface MarkdownLineUpdateInter {
    boolean update(String content, int index, MarkdownPage page);

    boolean isUpdateMatch(String content, int index, MarkdownPage page);
}
