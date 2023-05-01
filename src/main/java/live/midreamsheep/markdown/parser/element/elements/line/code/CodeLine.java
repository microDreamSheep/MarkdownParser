package live.midreamsheep.markdown.parser.element.elements.line.code;

import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.line.LineElementType;

/**
 * 代码块节点
 * @author midreamsheep
 * @see live.midreamsheep.markdown.parser.element.elements.line.code.CodeParser
 * @since 2023/5/1
 * @version 1.0
 * */
public class CodeLine extends MarkdownLineElement {

    private final String codeType;

    /**
     * 默认构造器
     * @param codeType 代码块类型，用于实现代码块高亮
     *                 例如：java、python、c等
     *                 如果不需要高亮，闯入参数为""
     *                 ```
     *                 content
     *                 ```
     *                 代码块类型不区分大小写也不包括前后空格,将会统一转为小写
     *                 例如：new CodeLine("Java ")和new CodeLine("java")效果相同
     * */
    public CodeLine(String codeType) {
        //转小写
        this.codeType = codeType.trim().toLowerCase();
    }

    public String getCodeType() {
        return codeType;
    }

    @Override
    protected LineElementType SetType() {
        return LineElementType.CODE;
    }
}
