package util;

import com.example.demo.response.StudentResponse;

public class Student_Util {

    public static void success_case(StudentResponse response, String message) {
        response.setCode(Constants.SUCCESS_CODE);
        response.setMessage(message);
    }

    public static void failure_case(StudentResponse response,String message) {
        response.setCode(Constants.FAILURE_CODE);
        response.setMessage(message);
    }

}
