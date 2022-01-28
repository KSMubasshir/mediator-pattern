import java.util.LinkedList;
import java.util.Queue;

public class ServiceProvider {
    public String name;
    private Queue<String> q = new LinkedList<>();

    public String serve() {
        return q.remove();
    }

    public void request(String name) {
        q.add(name);
    }

    public ServiceProvider(String name){
        this.name  = name;
    }
}