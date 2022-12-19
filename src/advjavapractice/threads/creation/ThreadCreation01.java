package advjavapractice.threads.creation;

public class ThreadCreation01 {

    public static void main(String[] args) {

        MyThread thread1 = new MyThread("Messi");
        MyThread thread2 = new MyThread("Ronaldo");
        thread1.start();
        thread2.start();



    }

    //Task1: Thread sınıfını extend eden Sayac isminde sınıf oluşturup
    // bu sınıftan sayıları 1 den 100 e kadar yazdıran iki tane thread oluşturunuz.



}

class MyThread extends Thread{

    private String name;

    public MyThread(String name){
        this.name=name;
    }

    @Override
    public void run() {
        oneToHundred();
    }

    public void oneToHundred(){
        System.out.println(this.name + " basladi ");
        for(int i = 1;i<=100;i++){
            System.out.println(this.name + " " + i);
        }
        System.out.println(this.name + " bitirdi ");
    }

}
