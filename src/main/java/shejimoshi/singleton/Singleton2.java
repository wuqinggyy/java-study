package shejimoshi.singleton;

/**
 * 饿汉式：线程安全，调用效率高。但是不能延时加载
 */
public class Singleton2 {

    private static  Singleton2 instance = new Singleton2();

    private Singleton2(){

    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
