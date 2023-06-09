package live.midreamsheep.markdown.parser.page;

import live.midreamsheep.markdown.parser.element.line.MarkdownLine;
import live.midreamsheep.markdown.parser.element.line.mapper.MarkdownHandlerMapper;

import java.util.LinkedList;
import java.util.List;

/**
 * 页面markdown解析结果
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see MarkdownLine
 * @see MarkdownParser
 * */
public class MarkdownPage {

    private final List<MarkdownLine> lines = new LinkedList<>();

    /**
     * 获取指定行
     * @param lineNumber 行号<br/>
     *                   行号是真实行号，不是数组下标 从1开始计数
     * @return MarkdownLine 指定行具体内容
     * @see MarkdownLine
     * */
    public MarkdownLine getByIndex(int lineNumber){
        return lines.get(lineNumber-1);
    }

    public void addNewLine(String line){}

    public void addNewLine(MarkdownLine element){
        addNewLine(lines.size(), element);
    }

    public void addNewLine(int lineNumber, MarkdownLine element){
        lines.add(lineNumber-1, element);
    }


    public void removeLine(int lineNumber){
        MarkdownLine markdownLine = lines.get(lineNumber - 1);
        MarkdownHandlerMapper.get(markdownLine.getType()).delete(lineNumber, lines);
    }

    public void removeLine(MarkdownLine element){
        removeLine(lines.indexOf(element)+1);
    }

    /**
     * 不建议直接获取lines，建议使用getByIndex()方法获取指定行，要对行进行操作时使用addNewLine()、removeLine()方法
     * 获取页面解析结果
     * @return lines
     * */
    public List<MarkdownLine> getLines() {
        return lines;
    }
}
