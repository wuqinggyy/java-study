package shejimoshi.Strategy;

public  class Duck {

    FlyBehavior flyBehavior;

    public void perforFly() {
        flyBehavior.fly();
    }

    public void  setFlyBehavior(FlyBehavior fb){
         this.flyBehavior = fb;
    }

}
