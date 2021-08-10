package shejimoshi.Template;

public class Football  extends Game{

    @Override
    void initialize() {
        System.out.println("initialize football");
    }

    @Override
    void startPlay() {
        System.out.println("startPlay football");
    }

    @Override
    void endPlay() {
        System.out.println("endPlay football");
    }
}
