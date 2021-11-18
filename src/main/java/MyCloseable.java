import java.io.Closeable;

public class MyCloseable implements Closeable {

    public MyCloseable() {
        System.out.println("MyCloseable created");
    }

    @Override
    public void close() {
        System.out.println("Closed");
    }
}
