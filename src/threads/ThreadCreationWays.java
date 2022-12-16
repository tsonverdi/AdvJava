package threads;

public class ThreadCreationWays {


    public static void main(String[] args) {

        System.out.println("Current Thread : " + Thread.currentThread().getName());

        MyThread thread1 = new MyThread();
        thread1.run();
        //thread1.start();
        // thread sınıfında run() metodunda yazılanlar işlenmeye başlar
        // run() diyerekte çağırdığımızda method yine çalışıyor , start() ile çağırmamız
        // arasındaki fark : run() ile çağırıldığında thread değişmez sadece methos çalışır
        // start() da ise önce thread ayağa kalkar daha sonra içindeki run() metodu çalışır

        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();


        //3.Yol Isimsiz olarak thread olusturmak Interface
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Current  Thread : " + Thread.currentThread().getName() + "Bu isimsiz sinif yolu ile olustrulan threaddir.");
                System.out.println();
            }
        });

        thread3.setName("Thread3");
        thread3.start();

        //Isimsiz olarak thread olusturalim 2. Yol
        Thread thread4 = new Thread(()->{
            System.out.println("Lambda ile yazilir");
        });
        thread4.start();
        System.out.println("Main methodu bitti");

        Thread thread5 = new Thread(()->{
            System.out.println("thread5 calisti");
        });
        thread5.start();
    }

}
//1.Yol : Thread classini extend ederek.
class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("MyThread ran.");
    }
}

//2. Runnable interface i implement ederek
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Runnable ran.");
    }
}
