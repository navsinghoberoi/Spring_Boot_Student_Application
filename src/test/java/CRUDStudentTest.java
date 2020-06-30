package test.java;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.example.demo.model.Student;

public class CRUDStudentTest {

    @Test(priority = 1)
    public void createStudentTest() {
        Student student = new Student(101, "nav", "test", "9999102012");
        Assert.assertEquals(101, student.getId());
        Assert.assertEquals("nav", student.getFirstName());
        Assert.assertEquals("test", student.getLastName());
        Assert.assertEquals("9999102012", student.getPhoneNumber());

        student.setLastName("test1");
        Assert.assertEquals("test1", student.getLastName());
    }

}