package design_pattern;

public class SingletonPatternEager {
    private static final SingletonPatternEager instance = new SingletonPatternEager();

    private SingletonPatternEager() {
    }

    public static SingletonPatternEager getInstance() {
        return instance;
    }
}
