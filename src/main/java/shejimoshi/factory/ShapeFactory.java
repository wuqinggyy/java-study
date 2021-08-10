package shejimoshi.factory;

public  class ShapeFactory  extends  AbstractFactory{

    @Override
    public  Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equals("CYCLE")) {
            return new Circle();
        } else if (shapeType.equals("SQUARE")) {
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String type) {
        return null;
    }
}
