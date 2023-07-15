package live.midreamsheep.markdown.parser.element.line.table;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.MarkdownLine;
import live.midreamsheep.markdown.parser.api.line.MarkdownLineHandlerInter;
import live.midreamsheep.markdown.parser.element.line.standard.Standard;
import live.midreamsheep.markdown.parser.element.span.SpanParser;
import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.page.MarkdownPage;
import live.midreamsheep.markdown.parser.tool.str.MarkdownParserStringUntil;

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
public class TableHandler implements MarkdownLineHandlerInter {

    /**
     * 具体解析方法
     * 解析步骤：
     *  1.解析表格头
     *  2.解析表格规则
     *  3.解析表格内容
     * */
    @Override
    public int parse(String[] lines, int index, MarkdownPage page) {
        //解析表格头
        String line = lines[index].trim();
        TableLine tableLine = new TableLine();
        TableData data = new TableData(parseSpan(MarkdownParserStringUntil.split(line.substring(1, line.length() - 1),'|')), LineElementType.TABLE_HEAD);
        data.setLineContent(lines[index]);
        tableLine.setTableHeads(data);
        index++;
        if(lines.length <= index){
            return -1;
        }

        //解析表格规则
        line = lines[index].trim();
        String[] tableRules = MarkdownParserStringUntil.split(line.substring(1, line.length() - 1),'|');
        if(tableRules.length != tableLine.getTableHeads().getLength()){
            return -1;
        }
        TableRule tableRule = new TableRule();
        if(!tableRule.parseTableRules(tableRules)){
            return -1;
        }
        tableRule.setLineContent(lines[index]);
        tableLine.setTableRules(tableRule);

        //解析表格内容
        page.addNewLine(data);
        page.addNewLine(tableRule);
        index++;
        index = parseBody(tableLine,lines,index, page);
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
     * 解析表格内容
     * @param tableLine 表格行类型
     * @param lines 将要解析的文本
     * @param index 解析开始的行数
     * @return 解析结束的行数
     * */
    private int parseBody(TableLine tableLine, String[] lines, int index, MarkdownPage page){
        for (int i = index; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.length() < 3 || line.charAt(0) != '|' || line.charAt(line.length() - 1) != '|') {
                break;
            }
            String[] tableBody = MarkdownParserStringUntil.split(line.substring(1, line.length() - 1),'|');
            if(tableBody.length != tableLine.getTableHeads().getLength()){
                break;
            }
            TableData data = new TableData(parseSpan(tableBody), LineElementType.TABLE_BODY);
            data.setLineContent(lines[i]);
            page.addNewLine(data);
            if(!tableLine.addTableBody(data)){
                break;
            }
            index++;
        }
        return index;
    }

    @Override
    public void delete(int line, List<MarkdownLine> lines) {
        MarkdownLine markdownLine = lines.get(line - 1);
        if(markdownLine.getType() == LineElementType.TABLE_HEAD||markdownLine.getType() == LineElementType.TABLE_ROW){
            if(markdownLine.getType() == LineElementType.TABLE_ROW){
                //删除表格规则及表格内容
                lines.add(line-2, new Standard(SpanParser.parse(lines.get(line-2).getLineContent(),new Span()),lines.get(line-2).getLineContent()));
                lines.remove(line-1);
            }
            //删除表格头并将表格规则及表格内容转化为普通行
            lines.remove(line-1);
            for (int i = line-1; i < lines.size(); i++) {
                if (lines.get(i).getType() != LineElementType.TABLE_ROW&&lines.get(i).getType() != LineElementType.TABLE_BODY){
                    break;
                }
                lines.add(i, new Standard(SpanParser.parse(lines.get(i).getLineContent(),new Span()),lines.get(i).getLineContent()));
            }
            return;
        }
        if(markdownLine.getType() == LineElementType.TABLE_BODY){
            //删除表格内容
            lines.remove(line-1);
        }
    }

    @Override
    public boolean isParseMatch(String[] lines, int index, MarkdownPage page) {
        String line = lines[index].trim();
        if (line.length() < 3 || line.charAt(0) != '|' || line.charAt(line.length() - 1) != '|') {
            return false;
        }
        return line.split("\\|").length == lines[index + 1].trim().split("\\|").length;
    }

    @Override
    public boolean update(String content, int index, MarkdownPage page) {
        //TODO
        return false;
    }

    @Override
    public boolean isUpdateMatch(String content, int index, MarkdownPage page) {
        //TODO
        return false;
    }
}
