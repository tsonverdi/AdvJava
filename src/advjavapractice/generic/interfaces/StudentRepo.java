package advjavapractice.generic.interfaces;

public class StudentRepo implements Repository<Student>{


    @Override
    public void add(Student student) {
        System.out.println(student.getName() + "basari ile kaydedildi");
    }

    @Override
    public void get(Student student) {
        System.out.println(student.getName() + "basari ile bulundu");
    }

    @Override
    public void update(Student student) {
        System.out.println(student.getName() + "basari ile guncellendi" + student.getName()+ "update");
    }

    @Override
    public void delete(Student student) {
        System.out.println(student.getName() + "basari ile silindi");
    }
}
