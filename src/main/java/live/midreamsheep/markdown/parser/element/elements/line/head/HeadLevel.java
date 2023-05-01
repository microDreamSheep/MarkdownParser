package live.midreamsheep.markdown.parser.element.elements.line.head;


/**
 * 标题类型枚举类
 * 用于标识标题等级
 * 例如 # 一级标题  H1
 *     ## 一级标题  H2
 *     ### 一级标题  H3
 *     #### 一级标题  H4
 *     ##### 一级标题  H5
 *     ###### 一级标题  H6
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see live.midreamsheep.markdown.parser.element.elements.line.head.HeadLine
 * @see live.midreamsheep.markdown.parser.element.elements.line.head.HeadParser
 * */
public enum HeadLevel {
    H1(1),
    H2(2),
    H3(3),
    H4(4),
    H5(5),
    H6(6);
    //等级标识
    private final int level;
    HeadLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }
    /**
     * 根据等级获取枚举类
     * @param level 等级 范围1-6 分别对应H1-H6
     * @return HeadLevel
     * */
    public static HeadLevel getHeadLevel(int level) {
        for (HeadLevel value : HeadLevel.values()) {
            if (value.getLevel() == level) {
                return value;
            }
        }
        return null;
    }
}
