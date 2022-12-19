package threads;


import java.util.logging.Logger;

//threadler ayni kaynaga ersimek isterlerse ne olacak??
public class MultiThreading02 {

    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
            //Task: ayri iki thred olusturup ayni kaynaga erismesini sagla.
            //1.Thread
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter.count();
                    System.out.println("Thread1 calisti");
                }
            });
            thread.start();
            //thread.join();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread2 calisti");
            }
        });

            thread2.start();

    }

}
class Counter {

    public synchronized static void count(){
        // synchronized ile bu metoda giren threadleri sıraya koymuş olduk
        // method içine aynı anda sadece 1 thread girebilecek
        for (int i = 1; i<=1000;i++){
            MultiThreading02.counter++;//1000
        }
        System.out.println("Counter : " + MultiThreading02.counter);
    }

}
