package shejimoshi.Strategy;

public class ModelDuck extends Duck {

    public ModelDuck(){
        flyBehavior = new FlyNoWay();
    }

    public void display(){
        System.out.println("i am ModelDuck");
    }
}
