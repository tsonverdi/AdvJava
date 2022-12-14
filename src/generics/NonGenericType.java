package generics;

public class NonGenericType {

    private Object o;

    //Getter-Setter

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    //main
    public static void main(String[] args) {

        NonGenericType obj1 = new NonGenericType();
        NonGenericType obj2 = new NonGenericType();

        obj1.setO("Tarik");//Istedigimiz data type(class)tan deger atariz
        obj2.setO(65);

        String str1 = (String) obj1.getO(); //!!! CAST PROBLEMI

        String str2 = (String) obj2.getO(); //!!! RTE, ClassCastException

        //String.valueOf(obj1.geto());
        //Integer.parseInt(String);
    }
}
