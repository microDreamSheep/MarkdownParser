package live.midreamsheep.markdown.parser.element.line.table;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.MarkdownLine;

public class TableRule extends MarkdownLine {

    private TableRules[] rules;

    /**
     * 解析表格规则
     * @param tableRules 表格规则文本数组<br/>
     *                   表格规则文本格式：<br/>
     *                     1. --------- 左对齐<br/>
     *                     2. :--------: 居中对齐<br/>
     *                     3. --------: 右对齐<br/>
     *                     4. :--------  左对齐<br/>
     * @return 解析成功返回true，解析失败返回false
     * */
    public boolean parseTableRules(String[] tableRules){
        this.rules = new TableRules[tableRules.length];
        for (int i = 0; i < tableRules.length; i++) {
            String rule = tableRules[i].trim();
            if (rule.length() == 0) {
                return false;
            }else if(rule.startsWith(":")&&rule.endsWith(":")&&rule.contains("-")) {
                rules[i] = TableRules.CENTER;
            }else if(rule.startsWith(":")&&rule.endsWith("-")) {
                rules[i] = TableRules.LEFT;
            }else if(rule.startsWith("-")&&rule.endsWith(":")) {
                rules[i] = TableRules.RIGHT;
            }else{
                rules[i] = TableRules.LEFT;
            }
        }
        return true;
    }

    public TableRules[] getRules() {
        return rules;
    }

    @Override
    protected LineElementType SetType() {
        return LineElementType.TABLE_ROW;
    }

}
