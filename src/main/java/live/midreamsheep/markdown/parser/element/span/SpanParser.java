package live.midreamsheep.markdown.parser.element.span;

import live.midreamsheep.markdown.parser.api.SpanParserInter;
import live.midreamsheep.markdown.parser.element.span.str.StandardSpan;

/**
 * 行内格式解析器
 * 用于解析行内格式
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see SpanParserInter
 * @see SpanParserMapper
 * @see Span
 * */
public class SpanParser {
    /**
     * 解析行内格式
     * @param markdown 用于解析的行内容
     * @param span 传入的行内格式对象
     *             用于存储解析后的行内格式，解析后的行内格式将会存储在span中，作为他的子节点
     * @return span 返回传入的span对象
     * */
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
    /**
     * 处理标准字符串
     * @param sb 用于存储标准字符串的StringBuilder
     *           用于存储标准字符串，当遇到行内格式时，将会把StringBuilder中的字符串加入到span中
     *           并清空StringBuilder
     *           当解析完毕后，将会把StringBuilder中的字符串加入到span中
     *           并清空StringBuilder
     * @param span 传入的行内格式对象，用于存储解析后的行内格式，解析后的行内格式将会存储在span中，作为他的子节点
     * */
    private static void addStrSpan(StringBuilder sb, Span span){
        if(!sb.toString().equals("")){
            StandardSpan strSpan = new StandardSpan(sb.toString());
            span.addChildSpan(strSpan);
            sb.delete(0,sb.length());
        }
    }
}
