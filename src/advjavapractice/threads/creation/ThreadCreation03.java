package advjavapractice.threads.creation;

import javax.swing.plaf.TableHeaderUI;

public class ThreadCreation03 {

    //Task4: anonymous class kullanarak thread oluşturunuz.
//       lambda expression kullanarak thread oluşturunuz.

    public static void main(String[] args) {

        Thread.currentThread().getName();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("Bu method isimsiz inteface yoontemi");
            }
        });
        thread3.setName("Isimsiz Inteface");
        thread3.start();


        Thread thread4 = new Thread(()->{
            System.out.println("lambda ile yazdirdim");
        });
        thread4.setName("Lambda");
        thread4.start();
    }


}


