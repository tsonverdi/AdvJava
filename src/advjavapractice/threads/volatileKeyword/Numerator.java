package advjavapractice.threads.volatileKeyword;

public class Numerator {

    private volatile static int counter = 0;
    //volatile keyword u degiskenin main memoryde saklanmasini garanti eder ancak
    //tum threadlerin degiskene ayni anda ulasmasindan kaynakli cakismayi cozme garantisi yoktur.

    public synchronized static void getOrder(){

        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        counter++;
        System.out.println("Sayin " + name + " siraniz: " + counter);

    }

}
