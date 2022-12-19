package threads;

import javax.swing.plaf.TableHeaderUI;

public class WaitAndNotify {

    public static int balance = 0;

    public static void main(String[] args) {

        WaitAndNotify obj = new WaitAndNotify();

        //thread1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.withdraw(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.setName("Withdraw Thread");
        thread1.start();

        //thread2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                obj.deposit(2000);
            }
        });
        thread2.setName("Deposit Thread");
        thread2.start();

    }

    //para cekme methodu
    public void withdraw(int amount) throws InterruptedException {
        synchronized (this){
            if (balance<=0 || balance<amount){
                System.out.println("Balance degeri degisene kadar bekliyorum");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //Wait yapiyorum syncronda
        Thread.sleep(5000);

        //wwait islemi bittikten sonra veya balance degeri zaten yeterli ise
        balance = balance-amount;
        System.out.println("Para cekme islemi gerceklesmistir");
        //Yeterli para varsa zaten direkt yukardaki calisir.
    }

    public void deposit(int amount) {
        balance+=amount;

        System.out.println("Para yatirma islemi basariyla gerceklesmistir");

        synchronized (this){
            notify();
        }
    }
}


