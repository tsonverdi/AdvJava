package threads;

import javax.swing.plaf.TableHeaderUI;

public class MultiThreading04 {

    public static void main(String[] args) throws InterruptedException {

        Brackets2 bracket2 = new Brackets2();

        long startTime = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i<8;i++){
                    bracket2.generateBrackets();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i<8;i++){
                    bracket2.generateBrackets();
                }
            }
        });
        thread2.start();
        thread1.join();
        thread2.join();
        long endTime = System.currentTimeMillis();

        //System.out.println("Toplam gecen sure : " + (endTime-startTime));//4360
        System.out.println("Toplam gecen sure : " + (endTime-startTime));//2213 Sure yari yariya indi resmen


    }


}

class Brackets2 {
    public void generateBrackets (){
        synchronized (this){
            for (int i =1;i<=10;i++){
                if (i<=5){
                    System.out.print("[");
                }else {
                    System.out.print("]");
                }
            }
            //end of for loop
            System.out.println();
        }
        for (int i = 1; i<=5;i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
