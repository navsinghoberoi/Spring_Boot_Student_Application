package util;

import com.example.demo.response.StudentResponse;

public class Student_Util {

    public static void success_case(StudentResponse response) {
        response.setCode(Constants.SUCCESS_CODE);
        response.setMessage(Constants.SUCCESS_MESSAGE);
    }

    public static void failure_case(StudentResponse response) {
        response.setCode(Constants.FAILURE_CODE);
        response.setMessage(Constants.FAILURE_MESSAGE);
    }

}
