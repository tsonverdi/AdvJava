package generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericType<T> {

    /*
    E --> Element demektir. Collection gibi yapilarda kullanilir
    K -->Key
    V -->Value
    N -->Number
    T -->Type
    S,U,V --> 2. 3. 4. TIPLER ICIN
     */

    private T type;
    //Getter - Setter
    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }


    //main-method
    public static void main(String[] args) {
        //Generic yapi kullanilarak ayni classtan 2 farkli data turunde obje olusturalim.
        GenericType<String> obj1 = new GenericType<>();
        //Trick: Diamond icine Non-primitive kullanabilirim
        obj1.setType("Generic Types");

        //GenericType<String> obj2 = new GenericType<>();
        //obj1.setType(65); //String girmem gerekirken int data turunde girince CTE verdi.


        //Casttan nasil kurtulduk
        GenericType<Integer> obj3 = new GenericType<>();
        obj3.setType(65);
        int a = obj3.getType();//CAST probleminden kurtulduk.

        //ClassCastException Probleminden Nasil Kurtulurum?
        List<String> list = new ArrayList<>();
        list.add("Alper");
        list.add("Halide");
        //list.add(32); //!!! ClassCast Exceptiondan kurtulduk

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Generic");
        //map.put("Generic",1); //Burada compile verdi hatalari Compile gorelim diye.


    }
}
