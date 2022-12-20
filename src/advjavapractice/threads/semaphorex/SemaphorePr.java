package advjavapractice.threads.semaphorex;

import java.util.concurrent.Semaphore;

public class SemaphorePr {

    public static void main(String[] args) {

        Semaphore semaphore  = new Semaphore(3);

        Person person1 = new Person("Fred",semaphore);
        Person person2 = new Person("Barnie",semaphore);
        Person person3 = new Person("Wilma",semaphore);
        Person person4 = new Person("Betty",semaphore);
        Person person5 = new Person("Dino",semaphore);

        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();


    }//main sonu



}//class sonu

class Person extends Thread {
    private String name;
    private Semaphore semaphore;

    public Person(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "olusturuldu");

        System.out.println(name  + " kabine girmek istiyor...");
        try {
            semaphore.acquire();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " kabine girdi");
        System.out.println(name + " kabini kullaniyor");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " kabinden cikiyor");
        semaphore.release();

    }
}
