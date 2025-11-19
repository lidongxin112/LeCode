package simple;

public class danlilanhanshi {
    private  danlilanhanshi(){}
    private static danlilanhanshi single = null;
//    public static  danlilanhanshi getInstance(){
//        if (single==null){
//            single = new danlilanhanshi();
//        }
//        return single;
//    }
//    public static synchronized  danlilanhanshi getInstance(){
//        if (single==null){
//            single = new danlilanhanshi();
//        }
//        return single;
//    }
    //双重检查锁定
    public static danlilanhanshi getInstance(){
        if (single==null){
            synchronized (danlilanhanshi.class){
                if (single==null){
                    single = new danlilanhanshi();
                }
            }
        }
        return single;
    }
}
