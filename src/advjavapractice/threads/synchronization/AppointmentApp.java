package advjavapractice.threads.synchronization;

//Multithreading programlamada birden fazla Thread aynı anda ortak bir kaynağa erişmeye çalışırsa
//istenmeyen sonuçlar oluşacaktır. Bu durumda threadlere sırayla erişim vermek gerekecektir.
// Bir thread kaynağı kullanıyorken diğerleri onu beklemelidirler. Bu "synchronized" keywordü ile sağlanır.

/*
Task: Bir randevu oluşturma uygulaması tasarlayınız.(AppoinmentCenter)
      Uygulama herbir talep için bir gün sonrasına tarih
      vermelidir.
*/

public class AppointmentApp {

    public static void main(String[] args) {

        String[] users = {"Tolstoy","VictorHugo","Belzac","Dostoyevski","JohnSteinbeck"};
        AppointmentCenter appointmentCenter = new AppointmentCenter();

        for(String user : users){

            //anonymous class -> isimsiz thread yaptık
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName(users[0]);
                    String name = Thread.currentThread().getName();
                    System.out.format("Sayın %-16s, Randevu tarihiniz: %10s %n",name,appointmentCenter.getAppointment());
                }
            });
            thread.start();

        }


    }
}
