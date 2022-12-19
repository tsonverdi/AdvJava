package threads;

import java.util.concurrent.CountDownLatch;

public class CountdownLatch1 {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(4);

        //Simdi threadleri olusturacagiz.
        WorkerThreads thread1 = new WorkerThreads("Worker-1",4000,latch);
        WorkerThreads thread2 = new WorkerThreads("Worker-2",5000,latch);
        WorkerThreads thread3 = new WorkerThreads("Worker-3",7000,latch);
        WorkerThreads thread4 = new WorkerThreads("Worker-4",9000,latch);


        //start
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " has finished");
    }
}

class WorkerThreads extends Thread {

    private int delay;

    private CountDownLatch latch;

    public WorkerThreads(String name,int delay, CountDownLatch latch) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            System.out.println(Thread.currentThread().getName() + " calisiyor ");
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
