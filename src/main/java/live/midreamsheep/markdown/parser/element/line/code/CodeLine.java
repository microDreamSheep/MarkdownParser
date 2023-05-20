package live.midreamsheep.markdown.parser.element.line.code;

import live.midreamsheep.markdown.parser.element.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.line.LineElementType;

/**
 * 代码块节点
 * @author midreamsheep
 * @since 2023/5/1
 * @see CodeParser
 * @version 1.0
 * */
public class CodeLine extends MarkdownLineElement {

    private final String codeType;

    /**
     * 默认构造器
     * @param codeType 代码块类型，用于实现代码块高亮<br/>
     *                 例如：java、python、c等<br/>
     *                 如果不需要高亮，闯入参数为""<br/>
     *                 ```<br/>
     *                 content<br/>
     *                 ```<br/>
     *                 代码块类型不区分大小写也不包括前后空格,将会统一转为小写<br/>
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
