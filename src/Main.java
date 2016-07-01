import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    
    public static void main(String[] theArgs){
        Random rand = new Random();
        Route ip[] = new Route[10];
        for (int i = 0; i < ip.length; i++) {
            if (i == 0) {
                ip[i] = new Route(i + 1, "0.0.0.0", "0.0.0.0", rand.nextInt(3) + 1, 0);
            } else {
                String ip1 = rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256)
                + "." + rand.nextInt(256);
                String ip2 = rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256)
                + "." + rand.nextInt(256);
                ip[i] = new Route(i + 1, ip1, ip2, rand.nextInt(10), rand.nextFloat());
            }
        }
        
        System.out.println("Sequence         Destination               Port             Hops   Time");
        for (int i = 0 ; i < ip.length; i++) {
            System.out.println(ip[i].toString());
        }
        System.out.println();
        
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Sequence         Destination               Port             Hops   Time");
                for (int i = 0 ; i < ip.length; i++) {
                    System.out.println(ip[i].toString());
                }
                System.out.println();
                if (rand.nextInt(3) == 2) {
                    int num = rand.nextInt(8) + 1;
                    String ip2 = rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) 
                    + "." + rand.nextInt(256);
                    ip[num] = new Route(num, ip[num].destination, ip2, rand.nextInt(10), rand.nextFloat());
                }
            }
        }, 0, 8000);
    }
}