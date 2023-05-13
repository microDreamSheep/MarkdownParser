package live.midreamsheep.markdown.parser.element.elements.line.code;

import live.midreamsheep.markdown.parser.element.elements.line.LineElementType;
import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.str.StandardSpan;

/**
 * 代码块内部数据节点
 * 内部存储代码块内部的数据，为一个标准的StandardSpan对象
 * @author midreamsheep
 * @since 2023/5/13
 * @see live.midreamsheep.markdown.parser.element.elements.line.code.CodeParser
 * @see live.midreamsheep.markdown.parser.element.elements.line.code.CodeLine
 * @version 1.0
 * */
public class CodeDataLine extends MarkdownLineElement {

    private final StandardSpan codeData;
    private final CodeLine parentCodeLine;

    /**
     * 默认构造器
     * @param codeData 代码块内部数据 用于后期渲染具体数据
     * @param parentLine 父节点 用于后期获取代码渲染类型
     * */
    public CodeDataLine(StandardSpan codeData, CodeLine parentLine) {
        this.parentCodeLine = parentLine;
        this.codeData = codeData;
    }

    public Span getCodeData() {
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
