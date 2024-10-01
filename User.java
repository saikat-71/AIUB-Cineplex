import java.util.*;

public class User {
    String name;
    String gender;
    String mobile;
    String studentId;
    String password;
    ArrayList<String> wallet;

    User(String name, String gender, String mobile, String studentId, String password) {
        this.name = name;
        this.gender = gender;
        this.mobile = mobile;
        this.studentId = studentId;
        this.password = password;
        this.wallet = new ArrayList<>();
    }

    public String displayProfile()
    {
        return "Name          : " + name + "\nGender       : " + gender + "\nMobile        : " + mobile + "\nStudent ID  : " + studentId;
    }
}



