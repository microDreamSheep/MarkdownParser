package live.midreamsheep.markdown.parser.element.line.code;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.MarkdownLine;
import live.midreamsheep.markdown.parser.element.span.str.StandardSpan;

/**
 * 代码块内部数据节点
 * 内部存储代码块内部的数据，为一个标准的StandardSpan对象
 * @author midreamsheep
 * @since 2023/5/13
 * @see CodeHandler
 * @see CodeLine
 * @version 1.0
 * */
public class CodeDataLine extends MarkdownLine {

    private final StandardSpan codeData;
    private final CodeLine parentCodeLine;

    /**
     * 默认构造器
     * @param codeData 代码块内部数据 用于后期渲染具体数据
     * @param parentLine 父节点 用于后期获取代码渲染类型
     * */
    public CodeDataLine(StandardSpan codeData, CodeLine parentLine,String lineContent) {
        this.parentCodeLine = parentLine;
        this.codeData = codeData;
        this.lineContent = lineContent;
    }

    public StandardSpan getCodeData() {
        return codeData;
    }

    public CodeLine getParentLine() {
        return parentCodeLine;
    }

    @Override
    protected LineElementType SetType() {
        return LineElementType.CODE_DATA;
    }
}
