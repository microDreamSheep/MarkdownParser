package live.midreamsheep.markdown.parser.element.elements.line.table;

import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.element.elements.span.SpanParser;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;

import java.util.List;


public class TableParser implements MarkdownLineParserInter {

    @Override
    public int parse(String[] lines, int index, List<MarkdownLineElement> elements) {
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
        elements.add(tableLine);
        return index;
    }

    private Span[] parseSpan(String[] spans) {
        Span[] tableHead = new Span[spans.length];
        for (int i = 0; i < spans.length; i++) {
            tableHead[i] = SpanParser.parse(spans[i], new Span());
        }
        return tableHead;
    }

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
