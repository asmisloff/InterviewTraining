package ru.asmisloff.ht05;

import org.hibernate.Session;

import java.util.List;

public class StudentDAO {

    private final Session session;

    public StudentDAO(Session session) {
        this.session = session;
    }

    public Student getById(int id) {
        return session.find(Student.class, id);
    }

    public List<Student> findAll() {
        return session.createQuery("from Student").list();
    }

    public void saveOrUpdate(Student student) {
        session.saveOrUpdate(student);
    }

    public void delete(Student student) {
        session.delete(student);
    }

}
