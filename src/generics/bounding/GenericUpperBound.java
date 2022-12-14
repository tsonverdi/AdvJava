package generics.bounding;

public class GenericUpperBound<T extends Number> { //ustten sinirlaandirma


    private T[] numberArray;

    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }

    //Arrayin icindeki degelerin ortalamasini bulan method.
    public double getAverage (){

        double sum=0;

        for (T t: numberArray) {
            sum+=t.doubleValue();
        }

        double avg = sum/numberArray.length;

        return avg;
    }

    public static void main(String[] args) {
        Integer[] intArray = {2,4,7,33};
        GenericUpperBound<Integer> obj1 = new GenericUpperBound<>(intArray);
        System.out.println(obj1.getAverage());

        Double[] doubleArray = {2.5,4.6,7.8};
        GenericUpperBound<Double> obj2  = new GenericUpperBound<>(doubleArray);
        System.out.println(obj2.getAverage());

        //String[] strArray = {"Java","Cok","Kolay","Hele","Generics", "Tadindan","Yenmez"};
        //Compile verdi.
        //RTE ile ClassCastException almami onluyor.
        //GenericUpperBound<String> obj3 = new GenericUpperBound<String>();

    }

}
