import java.util.Scanner;

public class Main {
    public static void main(String[] theArgs){
      Table table = new Table("125.110.15.200");
      while (true){
      table.generate();
      table.show();
//      System.out.println("1.Update table");
//      System.out.println("2.Exit the program");
      @SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
      int k = 0;
      if(scanner.hasNextInt()){
      k = scanner.nextInt();
      }
          while (k != 1 && k!= 2){
              System.out.println("Entering incorrect");
              @SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
              k = 0;
              if(scan.hasNextInt()){
                  k = scan.nextInt();
              }
          }
          if(k == 2){
              break;
          }
      }
    }
}