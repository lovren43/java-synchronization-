import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;


///////////////////////////////////////////

//////////////////////////////////////////

///////////////////////////////////////////



///////////////////////////////////////////

 class Network {
    public static void main(String [] args) throws InterruptedException {
        Scanner in=new Scanner(System.in);
        System.out.println("what is the number of WI-FI connections?");
        String max=in.nextLine();
        int N=Integer.parseInt(max);
        Router router=new Router(N);
        System.out.println("What is the number of devices Clients want to connect?");
        String totalConn=in.nextLine();
        int TC=Integer.parseInt(totalConn);
        Device[] devices=new Device[TC];
        for (int i=0; i<TC; i++){
            String s=in.nextLine();
            String[] TClines=s.split(" ");
            devices[i]=new Device(TClines[0],TClines[1],router);
        }
        for (int i=0; i<TC; i++){
            Thread.sleep(5000);
            devices[i].start();
        }
    }
}
