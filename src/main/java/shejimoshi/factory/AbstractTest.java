package shejimoshi.factory;

/**
 * 抽想工厂模式
 * 在工厂模式的基础上， 将多个工厂合并到一起再 搞出来一个工厂的工厂生产者（抽象类）
 */
public class AbstractTest {

    public static void main(String[] args) {
        FactoryProducer factoryProducer = new FactoryProducer();
        AbstractFactory shapeFactory = factoryProducer.getFactory("SHAPE");
        if (shapeFactory != null) {
            Shape cycle = shapeFactory.getShape("CYCLE");
            cycle.draw();
        }
    }
}
