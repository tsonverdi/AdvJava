package generics;

public class GenericTypeTwoParameters<S,U> {

    private S s;
    private U u;

    //Parametreli Constractor


    public GenericTypeTwoParameters(S s, U u) {
        this.s = s;
        this.u = u;
    }

    //Getter - Setter
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


    public static void main(String[] args) {

        GenericTypeTwoParameters<String,Integer> obj1 = new GenericTypeTwoParameters<>("Java",1);
        GenericTypeTwoParameters<Integer,String> obj2 = new GenericTypeTwoParameters<>(1,"SpringBoot");

        System.out.println(obj1.getS());
        System.out.println(obj1.getU());




    }
}
