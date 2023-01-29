package design_pattern;

public class SingletonPatternLazy {
    private static SingletonPatternLazy instance;

    private SingletonPatternLazy() {
    }

    public static SingletonPatternLazy getInstance() {
        if (instance == null)
            instance = new SingletonPatternLazy();
        return instance;
    }
}
