package advjavapractice.generic.classes;

public class StudentList {

    public static void main(String[] args) {

        System.out.println("** Java dersi vize ve final notları **");
        listGrade();


        System.out.println(" == Kütüphane Üye Listesi == ");
        listMembersOfLibrary();

    }


    //öğrencilerin notlarını listeleyen bir method yazınız.

    public static void listGrade(){
        Student<String,Double,Double> std1 = new Student("Wilma",76,80);
        Student<String,Double,Double> std2 = new Student("Fred",89,90);
        Student<String,Double,Double> std3 = new Student("Barnie",56,70);

        System.out.printf("%-10s  ||  %3d  ||  %4d  %n", std1.getS(),std1.getU(),std1.getV());
        System.out.printf("%-10s  ||  %3d  ||  %4d  %n", std2.getS(),std2.getU(),std2.getV());
        System.out.printf("%-10s  ||  %3d  ||  %4d  %n", std3.getS(),std3.getU(),std3.getV());
    }

    //kütüphane üye öğrenci listesini yazdıran bir method yazınız.
    public static void listMembersOfLibrary(){
    Student<String,Integer,String> std1 = new Student("Cakil",567,"cakil@gmail.com");
    Student<String,Integer,String> std2 = new Student("Bambam",568,"bmbm@gmail.com");
    Student<String,Integer,String> std3 = new Student("Betty",569,"betty@gmail.com");

        System.out.printf("%-10s  ||  %3d  ||  %4s  %n", std1.getS(),std1.getU(),std1.getV());
        System.out.printf("%-10s  ||  %3d  ||  %4s  %n", std2.getS(),std2.getU(),std2.getV());
        System.out.printf("%-10s  ||  %3d  ||  %4s  %n", std3.getS(),std3.getU(),std3.getV());
    }
}
