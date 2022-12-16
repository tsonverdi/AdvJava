package threads;

public class MultiThreading01 {


    public static void main(String[] args) throws InterruptedException {

        Long startTime = System.currentTimeMillis();

        CounterWithoutMultiThread c1 = new CounterWithoutMultiThread(1);
        CounterWithoutMultiThread c2 = new CounterWithoutMultiThread(2);
        //Count methodlari calistirma suresi hesapla
        c1.countMe();
        System.out.println("--------");
        c2.countMe();

        Long endTime = System.currentTimeMillis();

        System.out.println("Multi thread olmadan gecen sure" + (endTime - startTime));

        System.out.println("**************************");

        //Counter methodlari multi thread ile calistirma
        Long startTime2 = System.currentTimeMillis();

        CounterWithMultiThread c3 = new CounterWithMultiThread(1);
        CounterWithMultiThread c4 = new CounterWithMultiThread(2);

        //Start verdik ikisine de
        c3.start();
        System.out.println("--------");
        c4.start();
        c3.join();
        c3.join();

        Long endTime2 = System.currentTimeMillis();

        System.out.println("Multi thread ile gecen sure" + (endTime2 - startTime2));

    }
}

class CounterWithoutMultiThread {

    private int threadNum;

    //Parametreli Constructor
    public CounterWithoutMultiThread(int threadNum) {
        this.threadNum = threadNum;
    }

    public void countMe() throws InterruptedException {
        for (int i =1;i<=10;i++){
            Thread.sleep(500);
            System.out.println("i" + i + "Thread number : " + threadNum);
        }
    }
}

class CounterWithMultiThread extends Thread{

    private int threadNum;

    public CounterWithMultiThread (int threadNum){
        this.threadNum = threadNum;
    }

    @Override
    public void run() {

        try {
            countMe();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void countMe() throws InterruptedException {
        for (int i =1;i<=10;i++){
            Thread.sleep(500);
            System.out.println("i" + i + "Thread number : " + threadNum);
        }
    }
}
