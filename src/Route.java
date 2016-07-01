import java.util.Date;
import java.util.Random;

public class Route {
	
	Random rand = new Random();
	
	public int sequence;
	public String destination;
	public String port;
	public int hops;
	public float time;
	
	public Route(int seq, String routerPort, String dest, int hop, float t) {
		sequence = seq;
		port = routerPort;
		destination = dest;
		hops = rand.nextInt(10);
		time = t;
	}
	
	public String toString() {
		return String.format("%-8d %20s %20s %5d %8.2f", sequence, destination, port, 
				hops, time);
	}

}
