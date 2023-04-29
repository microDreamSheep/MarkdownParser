package live.midreamsheep.markdown.parser.element.elements.line.head;

public enum HeadLevel {
    H1(1),
    H2(2),
    H3(3),
    H4(4),
    H5(5),
    H6(6);

    private final int level;

    HeadLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public static HeadLevel getHeadLevel(int level) {
        for (HeadLevel value : HeadLevel.values()) {
            if (value.getLevel() == level) {
                return value;
            }
        }
        return null;
    }
}
