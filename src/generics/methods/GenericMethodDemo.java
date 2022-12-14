package generics.methods;

//Generic methodlar hangi durumda bize kolaylik sagliyor.
public class GenericMethodDemo {

    public static void main(String[] args) {
        GenericMethodDemo obj1 = new GenericMethodDemo();
        Integer[] intArray = {1,23,54,56,45};
        Double [] doubleArray = {1.5,2.3,0.3};

        obj1.print(doubleArray);
    }

    public <T> void print(T[] array){
        for(T t: array){
            System.out.println(t);
        }
    }
    public void print(Integer[] arr){
        //*****
    }
    public void print(Double[] arr){
        //*****
    }
}
