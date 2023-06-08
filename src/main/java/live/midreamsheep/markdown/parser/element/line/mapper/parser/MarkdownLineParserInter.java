package live.midreamsheep.markdown.parser.element.line.mapper.parser;

import live.midreamsheep.markdown.parser.page.MarkdownPage;

/**
 * 解析行对象接口
 * 用于解析行对象，解析完后将会将解析结果放入page中，方便后续使用
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see MarkdownLineParserMapper
 * */
public interface MarkdownLineParserInter {

    /**
     * 解析行对象接口
     * @param lines markdown文本
     * @param index 当前行数
     * @param page 放入解析结果
     * @return 下一次解析的行数，用于解析多行元素
     * */
    int parse(String[] lines, int index, MarkdownPage page);
    boolean isMatch(String[] lines,int index, MarkdownPage page);
}
