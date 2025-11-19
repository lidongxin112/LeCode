package simple;

public class danliehanshi {
    private danliehanshi() {
    }

    private static final danliehanshi single = new danliehanshi();

    public static danliehanshi getInstance() {
        return single;
    }
}
