package shejimoshi.Strategy;

/**
 * 策略模式
 *
 * 将不同的行为分别定义接口，分别用不用的实现类去实现同一个接口 来定义同一行为的不同实现
 * 可以动态的修改实体类的行为
 * 可以在不修改原代码的基础上增加行为的实现，
 *
 * 定义了算法族，分别封装起来，让他们可以胡想转换，此模式让算法的变化独立于使用算法的客户
 *
 */
public class Test {

    public static void main(String[] args) {
        ModelDuck modelDuck = new ModelDuck();
        modelDuck.display();
        modelDuck.perforFly();
        modelDuck.setFlyBehavior(new FlyWithWings());
        modelDuck.perforFly();
    }
}
