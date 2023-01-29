package design_pattern;

public class SingletonStaticBlock {
    private static SingletonStaticBlock instance;

    private SingletonStaticBlock() {
    }

    static {
        try {
            instance = new SingletonStaticBlock();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public static SingletonStaticBlock getInstance() {
        return instance;
    }
}
