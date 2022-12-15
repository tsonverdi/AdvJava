package generics.bounding;

import java.util.ArrayList;
import java.util.List;

public class GenericLowerBoundAndWildCards {
    public static void main(String[] args) {

        //add elements methodu
        List<Object> ol = new ArrayList<>();
        addElements(ol);

        List<Number> nl = new ArrayList<>();
        addElements(nl);

//      List<Double> dl = new ArrayList<>();
//      addElements(dl);

        //print elements methodu- WildCardli olan kisim.
        printElements(new ArrayList<String>());

        //printObj
//        List<String> strList = new ArrayList<>();
//        printObj(strList); Burasi compile verir. Objecti otomatik Stringe cast edemedik. Wild Cardi kullanmamizin sebebi bu idi.
        List<Object> objectList = new ArrayList<>();
        printObj(objectList);

    }

    public static void addElements(List<? super Integer> list){

        //Wildcard ?
        for (int i=1; i<=10; i++){
            list.add(i);
        }


    }
    //WildCard Dezavatanjlari
    public static void printElements(List<?>listOfUnknown){
        //listOfUnknown.add(null);//Soru isratei oldugu icin Dataturu netlesmeden add methodu gibi islemleri yaptirmaz.
        for (Object object : listOfUnknown ){
            System.out.println(object);
        }
    }
    //? --> Object
    //Listtekileri print etme
    public static void printObj(List<Object>listOfObject){
        listOfObject.add("Java");

        for(Object object : listOfObject){
            System.out.println(object);
        }
    }
}
