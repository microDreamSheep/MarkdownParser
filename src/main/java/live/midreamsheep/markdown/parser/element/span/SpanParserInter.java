package live.midreamsheep.markdown.parser.element.span;

/**
 * 行内元素处理接口
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see SpanParser
 * @see SpanParserMapper
 * @see Span
 * */
@FunctionalInterface
public interface SpanParserInter {
    /**
     * 处理函数式接口
     * @param chars 用于解析的行内容
     * @param i 当前字符的下标
     * @param span 传入的行内格式对象
     * @return int 返回下一个字符的下标
     *        如果返回-1，则表示没有解析到行内格式,将进入标准字符串处理
     * */
    int parse(char[] chars, int i, Span span);
}
