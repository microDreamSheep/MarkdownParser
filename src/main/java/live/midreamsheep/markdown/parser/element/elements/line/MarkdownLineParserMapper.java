package live.midreamsheep.markdown.parser.element.elements.line;

import live.midreamsheep.markdown.parser.element.elements.line.code.CodeParser;
import live.midreamsheep.markdown.parser.element.elements.line.head.HeadParser;
import live.midreamsheep.markdown.parser.element.elements.line.horizontal.HorizontalLine;
import live.midreamsheep.markdown.parser.element.elements.line.quote.QuoteParser;
import live.midreamsheep.markdown.parser.element.elements.line.table.TableParser;
import live.midreamsheep.markdown.parser.tool.str.MarkdownParserStringUntil;

import java.util.HashMap;
import java.util.Map;

/**
 * 解析行对象映射表
 * @see live.midreamsheep.markdown.parser.element.elements.line.MarkdownLineParserInter
 * */
public class MarkdownLineParserMapper {
    private static final Map<String, MarkdownLineParserInter> mapper = new HashMap<>();

    public static void register(String key, MarkdownLineParserInter parser){
        mapper.put(key, parser);
    }

    public static Map<String, MarkdownLineParserInter> getMapper() {
        return mapper;
    }
    /**
     * 通过key获取解析器
     * @param key 解析器key
     *            例如：#、-、*、`等
     *            key都为一种语法的第一个字符
     *            例如：#、##、###、####等都是标题语法，但是#是标题语法的第一个字符，所以key为#
     *            例如：-、--、---、----等都是分割线语法，但是-是分割线语法的第一个字符，所以key为-
     * @return 解析器
     * */
    public static MarkdownLineParserInter get(String key){
        return mapper.get(key);
    }

    static{
        //注册解析器
        register("|", new TableParser());
        register(">", new QuoteParser());
        register("#", new HeadParser());
        register("`", new CodeParser());
        //分割线类型
        register("-", (lines,index,elements) -> {
            if(MarkdownParserStringUntil.isAlways(lines[index].trim().toCharArray(), '-')&&lines[index].trim().length()>=3){
                elements.add(new HorizontalLine());
                return index;
            }
            return -1;
        });
        register("*", (lines,index,elements) -> {
            if(MarkdownParserStringUntil.isAlways(lines[index].trim().toCharArray(), '*')&&lines[index].trim().length()>=3){
                elements.add(new HorizontalLine());
                return index;
            }
            return -1;
        });
        register("_", (lines,index,elements) -> {
            if(MarkdownParserStringUntil.isAlways(lines[index].trim().toCharArray(), '_')&&lines[index].trim().length()>=3){
                elements.add(new HorizontalLine());
                return index;
            }
            return -1;
        });
    }
}
