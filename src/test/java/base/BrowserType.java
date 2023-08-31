package base;

public enum BrowserType {
    CHROME("chrome"),
    FIREFOX("firefox");

    private final String text;

    BrowserType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static BrowserType fromString(String text) {
        for (BrowserType browserType : BrowserType.values()) {
            if (browserType.text.equalsIgnoreCase(text)) {
                return browserType;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}
