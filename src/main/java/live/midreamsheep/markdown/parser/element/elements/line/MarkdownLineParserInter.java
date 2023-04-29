package live.midreamsheep.markdown.parser.element.elements.line;

import live.midreamsheep.markdown.parser.element.MarkdownLineElement;

import java.util.List;

@FunctionalInterface
public interface MarkdownLineParserInter {

    /**
     * @param lines markdown文本
     * @param index 当前行数
     * @return 下一次解析的行数，用于解析多行元素
     * */
    int parse(String[] lines, int index, List<MarkdownLineElement> elements);
}
