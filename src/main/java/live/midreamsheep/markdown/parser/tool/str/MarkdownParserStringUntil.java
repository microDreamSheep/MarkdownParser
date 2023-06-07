package live.midreamsheep.markdown.parser.tool.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串工具类
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * */
public class MarkdownParserStringUntil {
    /**
     * 从字符串中查找某个字符
     * @param chars 字符串
     * @param i 开始位置
     * @param c 字符
     * @return 字符位置，如果没有找到返回-1
     * */
    private static int findChar(char[] chars,int i,char c){
        for (int i1 = i; i1 < chars.length; i1++) {
            if(chars[i1] == c){
                return i1;
            }
        }
        return -1;
    }
    /**
     * 从字符串中查找两个字符中间的内容
     * @param chars 字符串
     * @param i 开始位置
     * @param start 开始字符
     * @param end 结束字符
     * @param sb 用于存储结果
     *           例如：findStringInStartAndEnd("123456789",0,'1','9') 将{@code sb}赋值为"2345678"
     * @return end字符位置，如果没有找到返回-1
     * */
    public static int findStringInStartAndEnd(char[] chars,int i,char start,char end,StringBuilder sb){
        int startChar = findChar(chars, i, start);
        if(startChar == -1){
            return -1;
        }
        int endChar = findChar(chars, startChar+1, end);
        if(endChar == -1){
            return -1;
        }
        sb.append(chars, startChar+1, endChar - startChar-1);
        return endChar;
    }
    /**
     * 判断字符串是否全由某个字符组成
     * @param chars 字符串
     * @param a 字符
     * @return 全为某个字符返回true，否则返回false
     * */
    public static boolean isAlways(char[] chars,char a){
        for (char aChar : chars) {
            if(!(aChar ==a)){
                return false;
            }
        }
        return true;
    }
    /**
     * 字符串按行切割
     * @param content 字符串
     * @return 切割后的字符串数组
     * @see #split(String, char)
     * */
    public static String[] split(String content){
        return split(content,'\n');
    }
    /**
     * 字符串切割
     * 当字符串中有多个分隔符时，将字符串切割为多个子字符串，当重复出现时，用空字符串代替
     * @param content 字符串
     * @param c 分隔符.例如：split("1  2  3",' ')将返回["1","","2","","3"]<br/>
     *          如果存在多个连续的分隔符，将会被切割为多个空字符串，如：split("1\n\n\n2")将返回["1","","","2"]
     * @return 切割后的字符串数组
     * */
    public static String[] split(String content,char c){
        List<String> list = new ArrayList<>();
        //对str根据c分割，当多个c连续出现时，用空字符串代替
        char[] chars = content.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==c){
                list.add(start==i?"":content.substring(start,i));
                start = i+1;
            }
        }
        if (start-1!=chars.length){
            list.add(content.substring(start));
        }
        return list.toArray(new String[0]);
    }
}
