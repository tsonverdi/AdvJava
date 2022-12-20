package advjavapractice.threads.countdownlatch1;


/*
Geri sayım tamamlanıncaya kadar CountDownLatch örneğinin "await()" metodunu çağıran tüm threadler bekletilir.
Geri sayım tamamlandığında bir anlamda kapı sürgüsü açılır ve bekleyen threadler işlemeye devam eder.
Örneğin "n" sayıda threadin işlerini bitirdiklerini bildirene kadar (yani her biri sayacı bir azaltana ve
nihayetinde sayacın değeri sıfıra ulaşana kadar) ana threadin bekletilmesi istediğimiz bir
durumda kullanılabilir.

Task: Bir randevu oluşturma uygulaması tasarlayınız.(AppoinmentCenter)
      Uygulama herbir talep için bir gün sonrasına tarih
      vermelidir. Randevu tarihini veren threadlerden önce
      randevu öncesinde bazı işlemleri gerçekleştiren threadlerin
      çalışmasını sağlayınız.
 */

import java.util.concurrent.CountDownLatch;

public class AppointmentApp {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        String[] users = {"Tolstoy","Balzac", "Victor Hugo"};
        AppointmentCenter center = new AppointmentCenter();
        for (String user: users){
            Thread thread =new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Randevu tarihiniz : " + center.getAppointmentDate());
                }
            });
            thread.start();
        }


        Worker worker1 = new Worker("A islemi",latch);
        Worker worker2 = new Worker("B islemi",latch);
        Worker worker3 = new Worker("C islemi",latch);

        worker1.start();
        worker2.start();
        worker3.start();




    }
}
