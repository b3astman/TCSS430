import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	/**The number of milliseconds we wait before displaying first table status.*/
	private static final long TIMER_START_DELAY = 0l;
	/**The number of milliseconds we wait before displaying updated table.*/
	private static final long TIMER_WAIT = 3000l;
	/**The character the user must enter to exit application.*/
	private static final char PROGRAM_EXIT = '2';
	
	/**
	 * Periodically updates and displays a routing table simulation.
	 * Runs timer as daemon thread, and listens for user input to exit application
	 * on main thread. 
	 */
	public static void main(String[] theArgs) {
		Table table = new Table("125.110.15.200");
		Timer aTimer = new Timer(true);
		aTimer.schedule(new TimerTask(){

			@Override
			public void run() {
				onTimerTick(table);
			}
			
		}, TIMER_START_DELAY, TIMER_WAIT);
		
		System.out.println(PROGRAM_EXIT + ".Exit the program");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			if (scanner.hasNextInt() && scanner.nextInt() == PROGRAM_EXIT) {
				break;
			}
		}
		scanner.close();
	}
	
	/**
	 * The event to occur whenever the timer ticks. Updates and displays table.
	 * @param table the table to update and display.
	 */
	private static void onTimerTick(Table table) {
		table.generate();
		table.show();
		System.out.println("===============================================================================================");
	}
	
}