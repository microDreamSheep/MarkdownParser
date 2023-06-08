package live.midreamsheep.markdown.parser.element.line.mapper.parser;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.mapper.update.delete.MarkdownLineDeleteInter;
import live.midreamsheep.markdown.parser.element.line.code.CodeHandler;
import live.midreamsheep.markdown.parser.element.line.head.HeadHandler;
import live.midreamsheep.markdown.parser.element.line.horizontal.HorizontalLine;
import live.midreamsheep.markdown.parser.element.line.quote.QuoteParser;
import live.midreamsheep.markdown.parser.element.line.table.TableParser;
import live.midreamsheep.markdown.parser.tool.str.MarkdownParserStringUntil;

import java.util.HashMap;
import java.util.Map;

/**
 * 解析行对象映射表
 * @see MarkdownLineParserInter
 * */
public class MarkdownLineParserMapper {
    private static final Map<String, MarkdownLineParserInter> PARSER_INTER_HASH_MAP = new HashMap<>();
    private static final Map<LineElementType, MarkdownLineDeleteInter> DELETE_INTER_HASH_MAP = new HashMap<>();

    public static void register(LineElementType type, MarkdownLineDeleteInter deleteInter){
        DELETE_INTER_HASH_MAP.put(type, deleteInter);
    }

    public static void register(String key, MarkdownLineParserInter parser){
        PARSER_INTER_HASH_MAP.put(key, parser);
    }

    public static Map<String, MarkdownLineParserInter> getParserInterHashMap() {
        return PARSER_INTER_HASH_MAP;
    }
    public static Map<LineElementType, MarkdownLineDeleteInter> getDeleteInterHashMap() {
        return DELETE_INTER_HASH_MAP;
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
        return PARSER_INTER_HASH_MAP.get(key);
    }
    public static MarkdownLineDeleteInter get(LineElementType type) {return DELETE_INTER_HASH_MAP.get(type);}


    static{
        //注册解析器
        register("|", new TableParser());
        register(">", new QuoteParser());
        register("#", new HeadHandler());
        register("`", new CodeHandler());
        //分割线类型
        register("-", (lines,index,page) -> {
            if(MarkdownParserStringUntil.isAlways(lines[index].trim().toCharArray(), '-')&&lines[index].trim().length()>=3){
                page.addNewLine(new HorizontalLine());
                return index;
            }
            return -1;
        });
        register("*", (lines,index,page) -> {
            if(MarkdownParserStringUntil.isAlways(lines[index].trim().toCharArray(), '*')&&lines[index].trim().length()>=3){
                page.addNewLine(new HorizontalLine());
                return index;
            }
            return -1;
        });
        register("_", (lines,index,page) -> {
            if(MarkdownParserStringUntil.isAlways(lines[index].trim().toCharArray(), '_')&&lines[index].trim().length()>=3){
                page.addNewLine(new HorizontalLine());
                return index;
            }
            return -1;
        });
    }
}
