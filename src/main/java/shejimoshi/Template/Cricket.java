package shejimoshi.Template;

public class Cricket extends Game{

    @Override
    void initialize() {
        System.out.println("initialize Cricket");
    }

    @Override
    void startPlay() {
        System.out.println("startPlay Cricket");
    }

    @Override
    void endPlay() {
        System.out.println("endPlay Cricket");
    }
}
