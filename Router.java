import static java.lang.Thread.sleep;

public class Router {
    public Device[] devics;
    public boolean[] connectionsStatus;
    public int maxConnNumber;
    public int connnetionsNumber;
    public Semaphore semaphore;
    public Router(int maxNumber){
        maxConnNumber=maxNumber;
        semaphore=new Semaphore(maxNumber);
        connectionsStatus=new boolean[maxNumber];

    }
    public void setDevics(Device[] d){
        devics=d;
    }
    //private static ArrayList<connection> connections=new ArrayList<connection>();
    /*private class connection{
        private Device device;
        private int connectionNumber;
        public connection(Device d, int num){
            device=d;
            connectionNumber=num;
            connections.add(this);
        }
        public int getConnNum (){
            return connectionNumber;
        }
        public Device getConnDevice(){
            return device;
        }
    }*/
    public synchronized void occupy(Device d) throws InterruptedException {
        for (int i=0; i<maxConnNumber; i++){
            if (connectionsStatus[i]==false){
                connnetionsNumber++;
                d.setConnectionNumber(i+1);
                sleep(8000);
                System.out.println("connection "+d.getConnectionNumber()+": "+d.getDeviceName()+"  occupied");
                connectionsStatus[i]=true;
                break;
            }
        }
    }
    public void release(Device d){
        connnetionsNumber--;
        connectionsStatus[d.getConnectionNumber()-1]=false;
        semaphore.V();

    }
}