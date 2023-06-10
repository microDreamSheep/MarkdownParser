package live.midreamsheep.markdown.parser.element.line.code;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.MarkdownLine;
import live.midreamsheep.markdown.parser.element.line.mapper.MarkdownLineHandlerInter;
import live.midreamsheep.markdown.parser.element.line.standard.Standard;
import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.SpanParser;
import live.midreamsheep.markdown.parser.element.span.str.StandardSpan;
import live.midreamsheep.markdown.parser.page.MarkdownPage;

import java.util.List;

/**
 * 代码块类型解析器
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see CodeLine
 * */
public class CodeHandler implements MarkdownLineHandlerInter {

    /**
     * 用于解析代码块节点
     * 格式为：
     * ```type
     * content
     * ```
     * */
    @Override
    public int parse(String[] lines, int index, MarkdownPage page) {
        String startLine = lines[index];
        CodeLine code = new CodeLine(startLine.replace("```", ""),startLine);
        page.addNewLine(code);
        //找到下一个```的位置
        int end = index+1;
        for (int i = index+1; i < lines.length; i++) {
            String line = lines[i];
            if(line.trim().startsWith("```")){
                end = i;
                page.addNewLine(new CodeLine(startLine.replace("```", ""),startLine));
                break;
            }
        }
        if (end == index+1){
            return end;
        }
        //解析代码块中的内容
        int i = index+1;
        for (; i < end; i++) {
            //在倒数第二位置处插入数据
            page.addNewLine( page.getLines().size()-2,new CodeDataLine(new StandardSpan(lines[i]),code,lines[i]));
        }
        return i;
    }

    @Override
    public void delete(int line, List<MarkdownLine> lines) {

        MarkdownLine markdownLine = lines.get(line - 1);
        lines.remove(markdownLine);
        if (markdownLine.getType()== LineElementType.CODE_DATA){
            return;
        }
        //向下合并
        int i = line;
        for (; i < lines.size(); i++) {
            MarkdownLine nextLine = lines.get(i);
            if(nextLine.getType()== LineElementType.CODE_DATA){
                String content = ((CodeDataLine) nextLine).getCodeData().getContent();
                lines.remove(nextLine);
                lines.add(i-1, new Standard(SpanParser.parse(content,new Span()),nextLine.getLineContent()));
            }else{
                break;
            }
        }
        //向上合并
        i = line-2;
        for (; i >=0; i--) {
            MarkdownLine preLine = lines.get(i);
            if(preLine.getType()== LineElementType.CODE_DATA){
                String content = ((CodeDataLine) preLine).getCodeData().getContent();
                lines.remove(preLine);
                lines.add(i, new Standard(SpanParser.parse(content,new Span()),preLine.getLineContent()));
            }else{
                break;
            }
        }


    }

    @Override
    public boolean isMatch(String[] lines, int index, MarkdownPage page) {
        return lines[index].trim().startsWith("```");
    }
}
