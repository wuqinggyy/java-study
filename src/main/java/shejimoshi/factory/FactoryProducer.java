package shejimoshi.factory;

public class FactoryProducer {

    public AbstractFactory getFactory(String param) {
        if (param == null) {
            return null;
        }
        if (param.equals("SHAPE")) {
            return new ShapeFactory();
        }
        return null;
    }
}
