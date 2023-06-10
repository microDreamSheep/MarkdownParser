package live.midreamsheep.markdown.parser.element.line.head;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.page.MarkdownPage;
import org.junit.Test;

public class HeadHandlerTest {
    @Test
    public void test(){
        String[] test = new String[]{"# h1","## h2","### h3","#### h4","##### h5","###### h6","####### h7","###h8"};
        HeadHandler headHandler = new HeadHandler();
        assert headHandler.isMatch(test,0,null):"h1匹配失败";
        assert headHandler.isMatch(test,1,null):"h2匹配失败";
        assert headHandler.isMatch(test,2,null):"h3匹配失败";
        assert headHandler.isMatch(test,3,null):"h4匹配失败";
        assert headHandler.isMatch(test,4,null):"h5匹配失败";
        assert headHandler.isMatch(test,5,null):"h6匹配失败";
        assert !headHandler.isMatch(test,6,null):"h7匹配失败";
        assert !headHandler.isMatch(test,7,null):"h8匹配失败";
        MarkdownPage page = new MarkdownPage();
        headHandler.parse(test,0,page);
        assert page.getLines().size() == 1:"h1解析失败";
        headHandler.parse(test,1,page);
        assert page.getLines().size() == 2:"h2解析失败";
        headHandler.parse(test,2,page);
        assert page.getLines().size() == 3:"h3解析失败";
        headHandler.parse(test,3,page);
        assert page.getLines().size() == 4:"h4解析失败";
        headHandler.parse(test,4,page);
        assert page.getLines().size() == 5:"h5解析失败";
        headHandler.parse(test,5,page);
        assert page.getLines().size() == 6:"h6解析失败";
        assert page.getLines().get(0).getType() == LineElementType.HEAD:"h1类型错误";
        assert page.getLines().get(1).getType() == LineElementType.HEAD:"h2类型错误";
        assert page.getLines().get(2).getType() == LineElementType.HEAD:"h3类型错误";
        assert page.getLines().get(3).getType() == LineElementType.HEAD:"h4类型错误";
        assert page.getLines().get(4).getType() == LineElementType.HEAD:"h5类型错误";
        assert page.getLines().get(5).getType() == LineElementType.HEAD:"h6类型错误";

    }
}
