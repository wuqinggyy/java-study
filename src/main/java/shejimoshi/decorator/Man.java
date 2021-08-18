package shejimoshi.decorator;

public class Man implements WomanSerivce {

    private Human human;

    public Man(Human human) {
        this.human = human;
    }

    @Override
    public void eat() {
        human.eat();
    }

    @Override
    public void play() {
        System.out.println("man can paly");
    }

    public static void main(String[] args) {
        Human human = new Human();
        Man man = new Man(human);

        man.eat();
        man.play();
    }
}
