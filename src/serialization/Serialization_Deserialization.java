package serialization;

import javax.imageio.IIOException;
import java.io.*;

public class Serialization_Deserialization {

    public static void main(String[] args) {

        writeObject();
        readObjects();

    }
    //writeObject
    private static void writeObject (){

        System.out.println("User Objeleri olusturuluyor");
        User user1 = new User(1L,"Tarik","25203646452");
        User user2 = new User(2L,"Hasan","25203646454");
        User user3 = new User(3L,"Kamil","25203646456");

        try(FileOutputStream fos = new FileOutputStream("user.dat")){//dosya yazmak icin dosyanin objesini olustur.
            try(ObjectOutputStream oos = new ObjectOutputStream(fos)){//bu objeleri yazmak icin
                oos.writeObject(user1);
                oos.writeObject(user2);
                oos.writeObject(user3);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //readObject
    private static void readObjects(){
        //Javada File islemlerinde  okuma islemi yaparken unputstream classi kullanilir
        try (FileInputStream fis = new FileInputStream("user.dat")){//Dosyayi belirle
            try(ObjectInputStream ois = new ObjectInputStream(fis)){//Objeyi belirle.
                User user1 = (User) ois.readObject();
                User user2 = (User) ois.readObject();
                User user3 = (User) ois.readObject();


                System.out.println(user1);
                System.out.println(user2);
                System.out.println(user3);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

class User implements Serializable{

    //private field
    private Long id;
    private String name;
    private String tcKimlikNo;

    //constructor
    public User(Long id, String name, String tcKimlikNo) {
        this.id = id;
        this.name = name;
        this.tcKimlikNo = tcKimlikNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTcKimlikNo() {
        return tcKimlikNo;
    }

    public void setTcKimlikNo(String tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tcKimlikNo='" + tcKimlikNo + '\'' +
                '}';
    }
}
