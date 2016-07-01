import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    
    public static void main(String[] theArgs){
        Random rand = new Random();
        String[] sourceIPs = makeIPArray(3, rand);
        Route routes[] = new Route[10];
        for (int i = 0; i < routes.length; i++) {
            if (i == 0) {
                routes[i] = new Route(i + 1, "0.0.0.0", "0.0.0.0", rand.nextInt(3) + 1, 0);
            } else {
            	String ip1 = sourceIPs[rand.nextInt(3)];
                String ip2 = rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256)
                + "." + rand.nextInt(256);
                int hops = rand.nextInt(10);
                routes[i] = new Route(i + 1, ip1, ip2, hops, hops * rand.nextFloat());
            }
        }
        
        
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Sequence      Destination          Port                Hops   Time");
                for (int i = 0 ; i < routes.length; i++) {
                    System.out.println(routes[i].toString());
                }
                System.out.println();
                // chance to change next run
                if (rand.nextInt(3) == 2) {
                	System.out.println("=========================================Route Change==========================================");
                    int num = rand.nextInt(8) + 1;
                    routes[num] = new Route(num, (sourceIPs[rand.nextInt(3)]), routes[num].destination, rand.nextInt(10), rand.nextFloat());
                } else {                
                	System.out.println("===============================================================================================");
                }
            }
        }, 0, 2000);
    }
    
    /**Makes {size} different IPs*/
    private static String[] makeIPArray(int size, Random rand) {
        String[] ips = new String[size];
    	for(int i = 0; i < size; i++) {        	
        	ips[i] = rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256)
            + "." + rand.nextInt(256);
        }
    	return ips;
    }
}