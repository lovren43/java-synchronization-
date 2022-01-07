public class Device extends Thread {
    private String deviceName;
    public static Router router;
    private int connectionNumber;
    private String deviceType;
    public Device(String n,String t,Router r){
        deviceName=n;
        deviceType=t;
        router=r;
    }
    public void setConnectionNumber(int n){
        connectionNumber=n;
    }
    public int getConnectionNumber(){
        return connectionNumber;
    }
    @Override
    public void run(){
        router.semaphore.P(this);
        try {
            router.occupy(this);
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            sleep(15000);
            System.out.println("Connection "+connectionNumber+": "+deviceName+" login");
            System.out.println("Connection "+connectionNumber+": "+deviceName+" performs online activity");
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        router.release(this);
        System.out.println("Connection "+connectionNumber+": "+deviceName+" logged out");
    }
    public String getDeviceName(){
        return deviceName;
    }
    public String getDevicetype(){
        return deviceType;
    }
}