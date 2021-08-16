package shejimoshi.decorator;

public class Man2 extends AbstractService {

    @Override
    public void eat() {
        System.out.println("man2 can eat");
    }

    public static void main(String[] args) {
        Man2 man2 = new Man2();
        man2.eat();
        man2.play();
    }
}
