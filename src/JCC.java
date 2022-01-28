import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JCC {
    private static Queue<String> qPower = new LinkedList<>();
    private static Queue<String> qWater = new LinkedList<>();
    private static Queue<String> qTelecom = new LinkedList<>();
    private static Queue<String> qTransport = new LinkedList<>();
    public static void handleServe(ServiceProvider sp){
        sp.serve();
        if(sp.name.equalsIgnoreCase("JPDC"))
            System.out.println(sp.name + " serves the request of " + qPower.remove());
        else if(sp.name.equalsIgnoreCase("JWSA"))
            System.out.println(sp.name + " serves the request of " + qWater.remove());
        else if(sp.name.equalsIgnoreCase("JRTA"))
            System.out.println(sp.name + " serves the request of " + qTransport.remove());
        else if(sp.name.equalsIgnoreCase("JTRC"))
            System.out.println(sp.name + " serves the request of " + qTelecom.remove());
    }
    public static void handleRequest(ServiceProvider sp1, ServiceProvider sp2, String input){
        if(input.equalsIgnoreCase("POWER"))
            qPower.add(sp1.name);
        else if(input.equalsIgnoreCase("WATER"))
            qWater.add(sp1.name);
        else if(input.equalsIgnoreCase("TRANSPORT"))
            qTransport.add(sp1.name);
        else if(input.equalsIgnoreCase("TELECOM"))
            qTelecom.add(sp1.name);
        sp2.request(input);
        System.out.println(sp1.name + " requests for " + input + " service");
    }

}