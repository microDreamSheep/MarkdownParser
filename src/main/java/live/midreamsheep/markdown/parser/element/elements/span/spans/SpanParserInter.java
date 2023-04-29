package live.midreamsheep.markdown.parser.element.elements.span.spans;

@FunctionalInterface
public interface SpanParserInter {
    int parse(char[] chars, int i, Span span);
}
