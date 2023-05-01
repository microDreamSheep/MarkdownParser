package live.midreamsheep.markdown.parser.page;

import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineParserMapper;
import live.midreamsheep.markdown.parser.element.elements.line.standard.Standard;
import live.midreamsheep.markdown.parser.element.elements.span.SpanParser;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.str.StandardSpan;

import java.util.LinkedList;
import java.util.List;

public class MarkdownPage {
    private final List<MarkdownLineElement> elements = new LinkedList<>();
    public void parse(String[] lines){
        for (int i = 0; i < lines.length; i++) {
            //获取首个非空字符
            if(lines[i].trim().equals("")){
                elements.add(new Standard(new StandardSpan(lines[i])));//空行
                continue;
            }
            char firstChar = lines[i].trim().charAt(0);
            MarkdownLineParserInter markdownLineParserInter = MarkdownLineParserMapper.get(String.valueOf(firstChar));
            if(markdownLineParserInter == null){
                elements.add(new Standard(SpanParser.parse(lines[i],new Span())));
                continue;
            }
            int result = MarkdownLineParserMapper.get(String.valueOf(firstChar)).parse(lines, i,elements);
            if(result==-1){
                elements.add(new Standard(SpanParser.parse(lines[i],new Span())));
                continue;
            }
            i = result;
        }
        System.out.println("asdasd");
    }
}
