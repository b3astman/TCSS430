public class Table {
   private class Node{
       public String myIp;
       public int myCost;
       public double myTime;
       public Node myNext;
    }
    private Node node; // main node
    public Table(String theIp){
        node = new Node();
        node.myIp = theIp;
    }
    public void generate(){
         Node n = node;
         for(int i = 0; i < 11; i++){
         StringBuilder str = new StringBuilder();
         // generate Ip
         for(int k = 0;k < 4; k++){
             int r = (int)(Math.random()*256);
             if(k == 2){
                 k +=(int)(Math.random()*2);
             }
             if(k == 3){
             str.append(r);}
             else{
             str.append(r + ".");
             }
         }
        n.myNext = new Node();  // communicate with the next node
        if(i != 10){
        n.myCost = (int)(Math.random()*20); // the number of computers between node
        n.myTime = (2*n.myCost)/10.0;}
        n = n.myNext;
        n.myIp = str.toString();
         }
    }
    public void show(){
        System.out.println("Sequence Number    Router Port Number    Destination Dddress    Cost    Time");
        Node n = node;  
        for(int i = 1; i < 4; i++){
        System.out.printf("%-19s%-22s%-23s%-8s%-4s",i,"115.200.10.20",n.myNext.myIp,n.myCost,n.myTime);
        System.out.println();
        n = n.myNext;
        }
        
        for(int j= 4 ; j < 8; j++){
        System.out.printf("%-19s%-22s%-23s%-8s%-4s",j,"90.115.150.70",n.myNext.myIp,n.myCost,n.myTime);
        System.out.println();
        n = n.myNext;
        
        }
        
        for(int k = 8 ; k < 11; k++){
            System.out.printf("%-19s%-22s%-23s%-8s%-4s",k,"10.160.30.122"
            		+ "",n.myNext.myIp,n.myCost,n.myTime);
            System.out.println();
            n = n.myNext;
        }
    }
}
