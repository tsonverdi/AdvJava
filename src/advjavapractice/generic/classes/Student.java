package advjavapractice.generic.classes;

//3Parametreli

/*
==Generic Types==
-Java 5 ile geldi
-Farklı data tipleri ile aynı yapıyı kullanabilme
-Tip güvenliği sağlar, castinge gerek olmaz
-CTE verir.
-Generics primitive data tipi ile çalışmaz.*/

public class Student<S,U,V> {

    //Task: 1) Java dersi için, öğrencileri isim, vize notu ve final notunu  ile birlikte listeleyen bir program yazınız.
    //2) Kütüphane için, öğrencileri isim, okul no ve mail adresi ile birlikte listeleyen bir program yazınız.

    private S s;
    private U u;
    private V v;

    public Student(S s, U u, V v) {
        this.s = s;
        this.u = u;
        this.v = v;
    }

    public S getS() {
        return s;
    }

    public void setS(S s) {
        this.s = s;
    }

    public U getU() {
        return u;
    }

    public void setU(U u) {
        this.u = u;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }


}
