package threads;

public class DeadLockDemo {



    public static void main(String[] args) {
        final String lock1 = "lock1";
        final String lock2 = "lock2";

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println("Thread1 ile lock1 i kilitledim");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println("Thread1 i lock2 yi kitledim");
                    }
                }
            }
        });
        thread1.start();


        //thread2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println("Thread2 ile lock1 i kilitledim");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println("Thread2 i lock2 yi kitledim");
                    }
                }
            }
        });
        thread2.start();

    }

}
