public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        new Home (userService);
        //new LoginFrame(userService);
        //new RegisterFrame(userService);
    }

}
