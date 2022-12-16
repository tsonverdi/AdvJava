package advjavapractice.serialization;

import java.io.*;

public class SerializationPractice {
    //Book tipinde nesneler uretip
    // bu nesneleri books.txt dosyasina kaydedelim. Daha sonra bu dosyadan nesneleri okutalim

    public static void main(String[] args) {

        writeObject();
        readObject();
    }

    public static void writeObject(){

        Book b1 = new Book("Sefiller","Victor Hugo",1945);
        Book b2 = new Book("Suc ve Ceza","Dostoyevski",1955);
        Book b3 = new Book("Savas ve Baris","Tolstoy",1940);

        //Nesneleri yazdiracagimiz "dosyayi" yazdirmak icin.
        try {
            FileOutputStream fos = new FileOutputStream("books.txt");
            //Nesneleri yazdirmak icin
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(b1);
            oos.writeObject(b2);
            oos.writeObject(b3);

        //Hepsini handle eden Exception classi
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readObject(){
        //Dosyayi okumak icin


       try {
           FileInputStream fis = new FileInputStream("books.txt");
           //Nesneyi okumak icin
           ObjectInputStream read = new ObjectInputStream(fis);

           Book b1 = (Book) read.readObject();
           Book b2 = (Book) read.readObject();
           Book b3 = (Book) read.readObject();

           System.out.println(b1);
           System.out.println(b2);
           System.out.println(b3);

           read.close();
           fis.close();


       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
