import java.util.Scanner;
import java.util.StringTokenizer;

public class MediatorPatternDemo {
    public static void main(String[] args) {
        ServiceProvider jpdc = new ServiceProvider("JPDC");
        ServiceProvider jwsa = new ServiceProvider("JWSA");
        ServiceProvider jrta = new ServiceProvider("JRTA");
        ServiceProvider jtrc = new ServiceProvider("JTRC");
        Scanner in = new Scanner(System.in);
        while(true){
            String input = in.nextLine();
            StringTokenizer st = new StringTokenizer(input," ");
            String token1, token2;
            token1 = st.nextToken();
            token2 = st.nextToken();
            if(token1.equalsIgnoreCase("JWSA")){
                if(token2.equalsIgnoreCase("SERVE"))
                    JCC.handleServe(jwsa);
                else if(token2.equalsIgnoreCase("POWER")){
                    JCC.handleRequest(jwsa, jpdc, token2);
                }
                else if(token2.equalsIgnoreCase("TRANSPORT")){
                    JCC.handleRequest(jwsa, jrta, token2);
                }
                else if(token2.equalsIgnoreCase("TELECOM")){
                    JCC.handleRequest(jwsa, jtrc, token2);
                }

            }

            else if(token1.equalsIgnoreCase("JPDC")){
                if(token2.equalsIgnoreCase("SERVE"))
                    JCC.handleServe(jpdc);
                else if(token2.equalsIgnoreCase("WATER")){
                    JCC.handleRequest(jpdc, jwsa, token2);
                }
                else if(token2.equalsIgnoreCase("TRANSPORT")){
                    JCC.handleRequest(jpdc, jrta, token2);
                }
                else if(token2.equalsIgnoreCase("TELECOM")){
                    JCC.handleRequest(jpdc, jtrc, token2);
                }
            }
            else if(token1.equalsIgnoreCase("JRTA")){
                if(token2.equalsIgnoreCase("SERVE"))
                    JCC.handleServe(jrta);
                else if(token2.equalsIgnoreCase("WATER")){
                    JCC.handleRequest(jrta, jwsa, token2);
                }
                else if(token2.equalsIgnoreCase("POWER")){
                    JCC.handleRequest(jrta, jpdc, token2);
                }
                else if(token2.equalsIgnoreCase("TELECOM")){
                    JCC.handleRequest(jrta, jtrc, token2);
                }
            }

            else if(token1.equalsIgnoreCase("JTRC")){
                if(token2.equalsIgnoreCase("SERVE"))
                    JCC.handleServe(jtrc);
                else if(token2.equalsIgnoreCase("WATER")){
                    JCC.handleRequest(jtrc, jwsa, input);
                }
                else if(token2.equalsIgnoreCase("POWER")){
                    JCC.handleRequest(jtrc, jpdc, input);
                }
                else if(token2.equalsIgnoreCase("TRANSPORT")){
                    JCC.handleRequest(jtrc, jrta, input);
                }
            }
        }

    }
}