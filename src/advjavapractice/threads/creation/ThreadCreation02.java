package advjavapractice.threads.creation;

public class ThreadCreation02 {
    //Task2:Runnable interfaceni implement eden Counter isminde sınıf oluşturup
    // bu sınıftan harfleri a dan z ye kadar yazdıran iki tane thread oluşturunuz.


    public static void main(String[] args) {

        System.out.println("Yaris baslasin...");

        MyRun thread1 = new MyRun("RoadRunner");
        MyRun thread2 = new MyRun("SpeddyGonzalez");
        Thread thread3 = new Thread(thread1);
        Thread thread4 = new Thread(thread2);
        thread3.start();
        thread4.start();
//Maini uyutup yapinca aksakliklar olabilir cunku yine bilemeyiz ne kadar surede gececegini.
       try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Yaris bitti...");
    }

}

class MyRun implements Runnable{

    private String name;

    public MyRun(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        writeAlphabet();
    }

    public void writeAlphabet(){
        System.out.println(this.name  + " basladi ");
        for (char i = 'a';i<='z';i++){
            System.out.println(this.name + " " + i);
        }
        System.out.println(this.name  + " basladi ");
    }
}
