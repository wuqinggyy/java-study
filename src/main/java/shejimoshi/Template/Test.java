package shejimoshi.Template;

/**
 * 模版模式
 * 将通用的方法定义在抽象类中，  在公开定义一个执行他们的方法，
 * 子类可以按照自己的实现去重写方法，但是可以代用 抽象类中的公开方法；
 *
 */
public class Test {

    public static void main(String[] args) {
        Cricket cricket = new Cricket();
        cricket.play();

        Football football = new Football();
        football.play();
    }

}
