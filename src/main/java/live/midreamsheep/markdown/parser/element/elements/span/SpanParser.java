package live.midreamsheep.markdown.parser.element.elements.span;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanParserInter;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanParserMapper;
import live.midreamsheep.markdown.parser.element.elements.span.spans.str.StandardSpan;

public class SpanParser {
    public static Span parse(String markdown,Span span) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < markdown.toCharArray().length;i++) {
            char c = markdown.toCharArray()[i];
            SpanParserInter spanParserInter = SpanParserMapper.get(String.valueOf(c));

            if(i==markdown.toCharArray().length-1){
                spanParserInter=null;
            }

            if(spanParserInter==null){
                sb.append(c);
                continue;
            }

            //讲之前的字符串加入到span中
            addStrSpan(sb,span);
            int result = spanParserInter.parse(markdown.toCharArray(),i,span);
            if(result==-1){
                sb.append(c);
                continue;
            }
            i = result;
        }
        addStrSpan(sb,span);
        return span;
    }
    private static void addStrSpan(StringBuilder sb, Span span){
        if(!sb.toString().equals("")){
            StandardSpan strSpan = new StandardSpan(sb.toString());
            span.addChildSpan(strSpan);
            sb.delete(0,sb.length());
        }
    }
}
