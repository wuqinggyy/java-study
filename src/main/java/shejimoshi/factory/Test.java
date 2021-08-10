package shejimoshi.factory;

/**
 * 工厂模式：
 * 在工厂类中根据类型列出所有的请款，
 * 创建对象的时候只需要调用工厂累的创建方法，传入类型就可以创建出对应的对象；
 *
 * 每增加一个产品，都需要增加一个实现类和修改对象实现工厂；
 *
 * 连接不同的sftp，获取不同的sftp的配置可以用工厂模式；
 */


public class Test {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape cycel = shapeFactory.getShape("CYCLE");
        cycel.draw();
        Shape shape = shapeFactory.getShape("222");
        if(shape == null){
            System.out.println("无效的图形");
        }

    }
}
