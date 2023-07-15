package live.midreamsheep.markdown.parser.element.span;

import live.midreamsheep.markdown.parser.api.SpanParserInter;
import live.midreamsheep.markdown.parser.element.span.bold.BoldParser;
import live.midreamsheep.markdown.parser.element.span.image.ImageParser;
import live.midreamsheep.markdown.parser.element.span.italic.ItalicParser;
import live.midreamsheep.markdown.parser.element.span.link.LinkParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Span解析器映射表
 * 用于存储Span解析表
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see Span
 * @see SpanParserMapper
 * @see SpanParserInter
 * @see SpanElementType
 * */
public class SpanParserMapper {
    private static final Map<String, SpanParserInter> mapper = new HashMap<>();

    public static void register(String key, SpanParserInter parser){
        mapper.put(key, parser);
    }

    /**
     * 获取解析器，通过key
     * @param key 解析器key
     *            用于获取解析器
     *            内部存储两种解析器，一种是通过标识符存储，一种是通过标识符的第一个字符存储
     *            例如：标识符为link，那么通过link和[都可以获取到解析器
     *            多个首字母冲突则通过Lambda表达式解决
     * @return 解析器
     * */
    public static SpanParserInter get(String key){
        return mapper.get(key);
    }

    static{
        register("bold",new BoldParser());
        register("italic",new ItalicParser());
        register("link",new LinkParser());
        register("image",new ImageParser());

        register("!",(content,index,span)->mapper.get("image").parse(content,index,span));
        register("[",(content,index,span)->mapper.get("link").parse(content,index,span));
        register("*",(content,index,span)->{
            if(content[index+1] == '*'){
                return mapper.get("bold").parse(content,index,span);
            }
            return mapper.get("italic").parse(content,index,span);
        });
        register("_",(content,index,span)->{
            if(content[index+1] == '_'){
                return mapper.get("bold").parse(content,index,span);
            }
            return mapper.get("italic").parse(content,index,span);
        });

    }
}
