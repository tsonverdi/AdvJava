package advjavapractice.threads.synchronization;

import java.time.LocalDate;

public class AppointmentCenter {

    private LocalDate day = LocalDate.now();

    public synchronized LocalDate getAppointment(){

        day = day.plusDays(1);

        return day;
    }


}
