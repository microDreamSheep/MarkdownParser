package live.midreamsheep.markdown.parser.tool.str;

public class MarkdownParserStringUntil {
    private static int findChar(char[] chars,int i,char c){
        for (int i1 = i; i1 < chars.length; i1++) {
            if(chars[i1] == c){
                return i1;
            }
        }
        return -1;
    }
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
    public static boolean isAlways(char[] chars,char a){
        for (char aChar : chars) {
            if(!(aChar ==a)){
                return false;
            }
        }
        return true;
    }
}
