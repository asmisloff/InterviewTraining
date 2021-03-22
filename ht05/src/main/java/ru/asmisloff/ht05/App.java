package ru.asmisloff.ht05;

import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {
        Session session = HibernateSessionFactory.buildSessionFactory().openSession();

        try {
            session.beginTransaction();

            StudentDAO studentDAO = new StudentDAO(session);

//            generate1000Students().stream()
//                    .forEach(studentDAO::saveOrUpdate);
//
            Student student = studentDAO.getById(2);
            System.out.println(student);
            session.beginTransaction();
            studentDAO.delete(student);

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    private static List<Student> generate1000Students() {
        return IntStream.range(0, 1000)
                .mapToObj(n -> {
                    Student student = new Student();
                    student.setName("Студент номер " + n);
                    student.setMark(n);
                    return student;
                })
                .collect(Collectors.toList());
    }

}
