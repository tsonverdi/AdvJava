package threads;

public class WaitInterrupt {

    public static int balance = 0;

    public static void main(String[] args) {
        WaitInterrupt waitInterrupt = new WaitInterrupt();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitInterrupt.withdraw(800);

            }
        });
        thread1.setName("WithdrawMoney Thread");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                waitInterrupt.deposit(2000);
                //Kibarca sonlandiriyor
                thread1.interrupt();
            }
        });
        thread2.setName("DepositMoney Thread Thread");
        thread2.start();




    }

    public void withdraw (int amount){

        synchronized (this){
            if (balance<=0 || balance<amount){

                System.out.println("bekleme");

                try {
                    wait();
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    System.out.println("Para cekilemedi");

                }
            }//If kismi burada bitiyor
        }balance-=amount;
        System.out.println(" Para cekme islemi basarili");

    }

    public void deposit (int amount){
        balance+=amount;
        System.out.println("Su kadar : " + amount + " para yatirma islemi basariyla gerckleti");
        }

}
