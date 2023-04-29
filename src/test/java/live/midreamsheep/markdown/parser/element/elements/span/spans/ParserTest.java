package live.midreamsheep.markdown.parser.element.elements.span.spans;

import live.midreamsheep.markdown.parser.MarkdownParser;
import org.junit.Test;

public class ParserTest {
    @Test
    public void parserTest() {
        Span span = new Span();
        MarkdownParser.parse("## _hello_ **world**\n__你好[]![团网](asdsadasd \"阿斯顿萨达\")__\n*__[百度](www.baidu.com \"你好\")__* 你好*大宋*打死都—"+
                "## RobotUtil类(没什么玩的了)\n" +
                "\n----------------------\n" +
                "\n```java" +
                "\t\n" +
                "\timport javax.imageio.ImageIO;\n" +
                "import java.awt.*;\n" +
                "import java.awt.image.BufferedImage;\n" +
                "import java.io.*;\n" +
                "\n" +
                "public class RobotUtil {\n" +
                "    Robot robot;\n" +
                "    public RobotUtil(Robot robot){\n" +
                "         this.robot = robot;\n" +
                "    }\n" +
                "    public void clickKey(int Key,int sleep) throws InterruptedException {\n" +
                "        robot.keyPress(Key);\n" +
                "        Thread.sleep(sleep);\n" +
                "        robot.keyRelease(Key);\n" +
                "    }\n" +
                "    public void clickMore(int[] keys,int sleep) throws InterruptedException {\n" +
                "        for (int i : keys) {\n" +
                "            robot.keyPress(i);\n" +
                "        }\n" +
                "        Thread.sleep(sleep);\n" +
                "        for (int i : keys) {\n" +
                "            robot.keyRelease(i);\n" +
                "        }\n" +
                "    }\n" +
                "    public void clickMouse(int x,int y,int Key,int count,int sleep){\n" +
                "        robot.mouseMove(x,y);\n" +
                "        for(int i = 0;i<count;i++){\n" +
                "            robot.mousePress(Key);\n" +
                "            robot.mouseRelease(Key);\n" +
                "            try {\n" +
                "                Thread.sleep(sleep);\n" +
                "            } catch (InterruptedException e) {\n" +
                "                e.printStackTrace();\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "    public boolean screenshot(int x,int y,int _X,int _Y,String file) throws FileNotFoundException {\n" +
                "        BufferedImage screenCapture = robot.createScreenCapture(new Rectangle(x, y, _X, _Y));\n" +
                "        File file1 = new File(file);\n" +
                "        OutputStream os = new FileOutputStream(file1);\n" +
                "        try {\n" +
                "            ImageIO.write(screenCapture,\"png\",os);\n" +
                "        } catch (IOException e) {\n" +
                "            return false;\n" +
                "        }\n" +
                "        return true;\n" +
                "    }\n" +
                "}\n" +
                "```");
    }
}
