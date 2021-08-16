package shejimoshi.decorator;

public class Woman extends Human implements WomanSerivce {

    @Override
    public void play() {
        System.out.println("can play");
    }


    public static void main(String[] args) {
        Woman woman = new Woman();
        woman.eat();
        woman.play();
    }
}
