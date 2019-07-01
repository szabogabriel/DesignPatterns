package patterns.behavioral.state;

public interface PackageState {


    //handle methods

    void next(Package pkg);

    void prev(Package pkg);

    void printStatus();
}
