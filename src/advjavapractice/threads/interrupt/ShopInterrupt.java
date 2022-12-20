package advjavapractice.threads.interrupt;

import advjavapractice.threads.waitNotify.ShopWaitNotify;

public class ShopInterrupt {

    /*
TASK: Bir marketteki stok miktarını takip eden bir uygulama tasarlayınız.
      Markette yeterli ürün yoksa yeni ürün gelmesi beklensin.
      Yeni ürün eklenince ürün satışı gerçekleşsin.
*/

        public volatile static int stock = 0;

        public static void main(String[] args) {

            ShopInterrupt shop = new ShopInterrupt();

            Thread consumerThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    shop.consumeProduct(3);
                }
            });
            consumerThread.setName("Tuketici");
            consumerThread.start();

            Thread produceThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {//sonucu gozlemle
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    shop.produceProduct(2);
                    consumerThread.interrupt();
                }
            });

            produceThread.setName("Uretici");
            produceThread.start();


        }

        public synchronized void consumeProduct(int a){

            if (a>stock){
                System.out.println(Thread.currentThread().getName() + " urun satin almak istiyor.");
                System.out.println("Yeterli urun yok, Guncel urun stogu: " + stock);
                System.out.println("Tuketici urun girisi bekliyor");
                try {
                    wait();
                } catch (InterruptedException e) {

                    if(a<=stock){
                        System.out.println();
                        System.out.println(Thread.currentThread().getName() + " urun satin almak istiyor");
                        System.out.println("Urun satin alindi, stocktan dusuluyor");
                        stock-=a;
                        System.out.println("Guncel stock: " + stock);

                    }else {
                        System.out.println();
                        System.out.println(Thread.currentThread().getName() + " urun satin almak istiyor");
                        System.out.println("Hala yeterli urun yok, Guncel stock : " + stock);
                        System.out.println("Bugun git yarin gel");

                    }
                }
            }

        }

        public synchronized void produceProduct (int quantity){
            System.out.println();
            System.out.println(Thread.currentThread().getName() + " urun eklemek istiyor.");
            System.out.println("Yeni urunler ekleniyor, stock guncelleniyor");
            stock+=quantity;
            System.out.println("Guncel stock : " + stock);

            //bu methoddan sonra kaldigi yerden
            System.out.println();
        }
    }

