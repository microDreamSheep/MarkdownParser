package live.midreamsheep.markdown.parser.element.elements.line.table;

import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.element.elements.span.SpanParser;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.page.MarkdownPages;

import java.util.List;

/**
 * 表格数据解析器，将表格数据解析为表格行类型
 * 表格行类型由表格头、表格规则、表格内容组成
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see TableLine
 * @see TableRules
 * */
public class TableParser implements MarkdownLineParserInter {

    /**
     * 具体解析方法
     * 解析步骤：
     *  1.解析表格头
     *  2.解析表格规则
     *  3.解析表格内容
     * */
    @Override
    public int parse(String[] lines, int index, MarkdownPages elements) {
        //解析表格头
        String line = lines[index].trim();
        if (line.length() < 3 || line.charAt(0) != '|' || line.charAt(line.length() - 1) != '|') {
            return -1;
        }
        TableLine tableLine = new TableLine();
        tableLine.setTableHeads(parseSpan(line.substring(1, line.length() - 1).split("\\|")));
        index++;
        if(lines.length <= index){
            return -1;
        }
        //解析表格规则
        line = lines[index].trim();
        if (line.length() < 3 || line.charAt(0) != '|' || line.charAt(line.length() - 1) != '|') {
            return -1;
        }
        String[] tableRules = line.substring(1, line.length() - 1).split("\\|");
        if(tableRules.length != tableLine.getTableHeads().length){
            return -1;
        }
        TableRules[] tableRule = new TableRules[tableRules.length];
        if(parseTableRules(tableRule,tableRules) == -1){
            return -1;
        }
        tableLine.setTableRules(tableRule);
        //解析表格内容
        index++;
        index = parseBody(tableLine,lines,index);
        elements.addNewLine(tableLine);
        return index;
    }
    /**
     * 对表格中的内容进行行内解析
     * @param spans 将要解析的文本
     * @return 解析后的Span数组,其中Span为组合类型
     * */
    private Span[] parseSpan(String[] spans) {
        Span[] tableHead = new Span[spans.length];
        for (int i = 0; i < spans.length; i++) {
            tableHead[i] = SpanParser.parse(spans[i], new Span());
        }
        return tableHead;
    }
    /**
     * 解析表格规则
     * @param tableRule 表格规则数组
     * @param tableRules 表格规则文本数组
     *                   表格规则文本格式：
     *                     1. --------- 左对齐
     *                     2. :--------: 居中对齐
     *                     3. --------: 右对齐
     *                     4. :--------  左对齐
     * @return 解析成功返回1，解析失败返回-1
     * */
    private int parseTableRules(TableRules[] tableRule,String[] tableRules){
        for (int i = 0; i < tableRules.length; i++) {
            String rule = tableRules[i].trim();
            if (rule.length() == 0) {
                return -1;
            }else if(rule.startsWith(":")&&rule.endsWith(":")&&rule.contains("-")) {
                tableRule[i] = TableRules.CENTER;
            }else if(rule.startsWith(":")&&rule.endsWith("-")) {
                tableRule[i] = TableRules.LEFT;
            }else if(rule.startsWith("-")&&rule.endsWith(":")) {
                tableRule[i] = TableRules.RIGHT;
            }else{
                tableRule[i] = TableRules.LEFT;
            }
        }
        return 1;
    }
    /**
     * 解析表格内容
     * @param tableLine 表格行类型
     * @param lines 将要解析的文本
     * @param index 解析开始的行数
     * @return 解析结束的行数
     * */
    private int parseBody(TableLine tableLine, String[] lines, int index) {
        for (int i = index; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.length() < 3 || line.charAt(0) != '|' || line.charAt(line.length() - 1) != '|') {
                break;
            }
            String[] tableBody = line.substring(1, line.length() - 1).split("\\|");
            if(tableBody.length != tableLine.getTableHeads().length){
                break;
            }
            if(!tableLine.addTableBody(parseSpan(tableBody))){
                break;
            }
            index++;
        }
        return index;
    }
}
