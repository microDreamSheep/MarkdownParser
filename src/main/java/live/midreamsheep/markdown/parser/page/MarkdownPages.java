package live.midreamsheep.markdown.parser.page;

import live.midreamsheep.markdown.parser.element.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.line.mapper.LineTypeFunction;

import java.util.LinkedList;
import java.util.List;

/**
 * 页面markdown解析结果
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see MarkdownLineElement
 * @see MarkdownPage
 * */
public class MarkdownPages {

    private final List<MarkdownLineElement> elements = new LinkedList<>();

    public List<MarkdownLineElement> getElements() {
        return elements;
    }

    public MarkdownLineElement getByIndex(int lineNumber){
        return elements.get(lineNumber);
    }

    public void addNewLine(MarkdownLineElement element){
        elements.add(element);
    }

    public void addNewLine(int lineNumber, MarkdownLineElement element){
        elements.add(lineNumber, element);
    }

    public void removeLine(int lineNumber){
        MarkdownLineElement markdownLineElement = elements.get(lineNumber-1);
        if(LineTypeFunction.isSingleLine(markdownLineElement.getType())){
            elements.remove(lineNumber-1);
        }

        elements.remove(lineNumber);
    }

    public void removeLine(MarkdownLineElement element){
        removeLine(elements.indexOf(element)+1);
    }

}
