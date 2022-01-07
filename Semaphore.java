public class Semaphore {
    protected int value = 0 ;
    protected Semaphore() { value = 0 ; }
    protected Semaphore(int initial) { value = initial ; }
    public synchronized void P(Device d) {

        value-- ;
        if (value < 0) {
            try {
                //d.sleep(8000);
                d.sleep(7000);
                System.out.println(d.getDeviceName()+" ("+d.getDevicetype()+")"+" has arrived and waiting");
                wait();
            } catch (InterruptedException e) {
            }
        }
        else{
            System.out.println("("+d.getDeviceName()+")"+"("+d.getDevicetype()+")"+" has arrived");
        }
    }
    public synchronized void V() {
        value++ ;
        if (value <= 0) {
            notify() ;
        }
    }
}
