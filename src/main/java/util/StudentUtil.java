package util;

import com.example.demo.response.StudentResponse;

public class StudentUtil {

    public static void successCase(StudentResponse response, String message) {
        response.setCode(Constants.SUCCESS_CODE);
        response.setMessage(message);
    }

    public static void failureCase(StudentResponse response, String message) {
        response.setCode(Constants.FAILURE_CODE);
        response.setMessage(message);
    }

}
