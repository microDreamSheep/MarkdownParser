package live.midreamsheep.markdown.parser.tool.str;

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
}
