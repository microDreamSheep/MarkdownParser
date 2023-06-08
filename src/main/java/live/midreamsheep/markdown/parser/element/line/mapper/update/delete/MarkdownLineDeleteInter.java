package live.midreamsheep.markdown.parser.element.line.mapper.update.delete;

import live.midreamsheep.markdown.parser.element.line.MarkdownLine;

import java.util.List;

@FunctionalInterface
public interface MarkdownLineDeleteInter {
    void delete(int line, List<MarkdownLine> lines);
}
