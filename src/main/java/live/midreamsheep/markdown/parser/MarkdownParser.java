package live.midreamsheep.markdown.parser;

import live.midreamsheep.markdown.parser.page.MarkdownPage;

/**
 * Markdown解析器
 * 对外提供解析接口，解析Markdown字符串为MarkdownPage对象
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see live.midreamsheep.markdown.parser.page.MarkdownPage
 * */
public class MarkdownParser {
    /**
     * 解析Markdown字符串为MarkdownPage对象
     * @param markdown Markdown字符串
     * @return MarkdownPage对象
     * */
    public static MarkdownPage parse(String markdown) {
        MarkdownPage page = new MarkdownPage();
        page.parse(markdown.split("\n"));
        return page;
    }
}
