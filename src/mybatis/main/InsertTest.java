package mybatis.main;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.mapper.StudentMapper;
import mybatis.mapper.entity.Student;

public class InsertTest {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        // create student mapper
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);

        // insert student
        Student student = new Student("Jim", "IT", 100, 123999, "jim-it@gmail.com");
        studentMapper.insert(student);
        session.commit();

        // close session
        session.close();
    }
}
