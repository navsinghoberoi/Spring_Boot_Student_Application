package test.java;

import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.example.demo.model.Student;
import com.example.demo.response.StudentResponse;


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

 /*   @Test(priority = 2)
    public void getAllStudents() {
        String response = RestAssured.given().when().get("http://localhost:8080/student/getAll").getBody().asString();
        System.out.println("Api response of get all students => " + response);
    }*/
}