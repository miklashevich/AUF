package enums;

public enum ProjectTypeBd {
    SINGLE_FOR_ALL_CASES(1),
    SINGLE_WITH_BASELINE(2),
    MULTIPLE(3);

    private final int value;

    ProjectTypeBd(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static ProjectTypeBd getEnumValue(int value) {
        for (ProjectTypeBd mod : ProjectTypeBd.values()) {
            if (mod.getValue() == value)
                return mod;
        }
        throw new IllegalArgumentException("No enum constant with value" + value);
    }
}