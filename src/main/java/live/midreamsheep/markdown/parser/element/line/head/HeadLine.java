package live.midreamsheep.markdown.parser.element.line.head;

import live.midreamsheep.markdown.parser.element.line.MarkdownLine;
import live.midreamsheep.markdown.parser.element.line.LineElementType;

/**
 * 标题节点
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see HeadHandler
 * @see HeadLevel
 * */
public class HeadLine extends MarkdownLine {
    private HeadLevel level;

    public HeadLevel getLevel() {
        return level;
    }
    /**
     * 设置标题等级
     * @param level 标题等级
     *              # 一级标题  H1
     *              ## 一级标题  H2
     *              ### 一级标题  H3
     *              #### 一级标题  H4
     *              ##### 一级标题  H5
     *              ###### 一级标题  H6
     * @see HeadLevel
     * */
    public void setLevel(HeadLevel level) {
        this.level = level;
    }

    @Override
    protected LineElementType SetType() {
        return LineElementType.HEAD;
    }
}
