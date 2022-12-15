package advjavapractice.generic.interfaces;

public class SchoolManagement {

    /*Task: Okul yönetimi için öğrenci ve öğretmen kayıtlarını
   -oluşturan
   -görüntüleyen
   -güncelleyen
   -silen
   bir program yazınız.
 */

    public static void main(String[] args) {

        Student student = new Student("Tolstoy");
        StudentRepo studentRepo = new StudentRepo();

        Teacher teacher=new Teacher("Dostoyevski");
        TeacherRepo teacherRepo = new TeacherRepo();

        studentRepo.add(student);
        teacherRepo.add(teacher);
        studentRepo.update(student);
        studentRepo.delete(student);


    }
}
