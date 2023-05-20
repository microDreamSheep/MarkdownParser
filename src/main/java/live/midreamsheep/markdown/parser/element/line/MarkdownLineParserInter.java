package live.midreamsheep.markdown.parser.element.line;

import live.midreamsheep.markdown.parser.page.MarkdownPages;

/**
 * 解析行对象接口
 * 用于解析行对象，解析完后将会将解析结果放入elements中，方便后续使用
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see MarkdownLineParserMapper
 * */
@FunctionalInterface
public interface MarkdownLineParserInter {

    /**
     * 解析行对象接口
     * @param lines markdown文本
     * @param index 当前行数
     * @param elements 放入解析结果
     * @return 下一次解析的行数，用于解析多行元素
     * */
    int parse(String[] lines, int index, MarkdownPages elements);
}
