package data;

public enum ColorData { // как вариант применения ENUM
    BLACK("Чёрный");

    private String name;

    ColorData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
