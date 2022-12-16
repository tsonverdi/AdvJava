package enumtype;

public class MainTest {
    public static void main(String[] args) {
        useConstantMethod(1);//CTE vermedi.
        useEnum(TransactionType.DEPOSIT);//CTE verdi.

    }
     //Eski tarz
     private static void useConstantMethod (int i) {
         if (i == TransactionTypeConstant.DEPOSIT) {
             System.out.println("Money is deposited");
         } else if (i == TransactionTypeConstant.WITHDRAW) {
             System.out.println("Money is withdrawn");
         } else if (i == TransactionTypeConstant.TRANSFER) {
             System.out.println("Money is transferred");
         }  else if (i == TransactionTypeConstant.PAYMENT) {
             System.out.println("Money is paid");
         } else if (i == TransactionTypeConstant.OTHER) {
             System.out.println("Money is not used");
         }
     }
     //enum ile
    private static void useEnum(TransactionType transactionType){
        if (transactionType == TransactionType.DEPOSIT) {
            System.out.println("Money is deposited");
        } else if (transactionType == TransactionType.WITHDRAW) {
            System.out.println("Money is withdrawn");
        } else if (transactionType == TransactionType.TRANSFER) {
            System.out.println("Money is transferred");
        }  else if (transactionType == TransactionType.PAYMENT) {
            System.out.println("Money is paid");
        } else if (transactionType == TransactionType.OTHER) {
            System.out.println("Money is not used");
        }

        //Enuma has degerler
        System.out.println("Enum Name : " + transactionType.name());//Enum ismini ekrana yazdim
        System.out.println("Enum degeri : " + transactionType.getTransactionCode());//Numeric degerini verir
        System.out.println("Enum Ordinal : " + transactionType.ordinal());


    }


}
