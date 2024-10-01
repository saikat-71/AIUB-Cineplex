import java.io.*;
import java.util.*;

public class UserService {
    User currentUser;
    private final String filePath = "users.txt";
    String[] availableMovies = {"TOOFAN", "NOBAB", "DIN-THE-DAY"};

    UserService() {
        loadUsersFromFile();
    }

    boolean login(String studentId, String password) {
        User user = findUserByStudentId(studentId);
        if (user != null && user.password.equals(password)) {
            currentUser = user;
            return true;
        }
        return false;
    }

    boolean register(String name, String gender, String mobile, String studentId, String password) {
        if (findUserByStudentId(studentId) == null) {
            User newUser = new User(name, gender, mobile, studentId, password);
            saveUserToFile(newUser);
            return true;
        }
        return false;
    }
    private void saveUserToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(user.name + "," + user.gender + "," + user.mobile + "," + user.studentId + "," + user.password);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private ArrayList<User> loadUsersFromFile() {
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length == 5) {
                    users.add(new User(userDetails[0], userDetails[1], userDetails[2], userDetails[3], userDetails[4]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No users found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
    private User findUserByStudentId(String studentId) {
        ArrayList<User> users = loadUsersFromFile();
        for (User user : users) {
            if (user.studentId.equals(studentId)) {
                return user;
            }
        }
        return null;
    }

    public void logout() {
        currentUser = null;
    }

    public void purchaseMovie(String movie) {
        if (currentUser != null && !currentUser.wallet.contains(movie)) {
            currentUser.wallet.add(movie);
        }
    }

    public void deleteMovie(String movie) {
        if (currentUser != null) {
            currentUser.wallet.remove(movie);
        }
    }

    public ArrayList<String> getUserWallet() {
        if (currentUser != null) {
            return currentUser.wallet;
        }
        return new ArrayList<>();
    }
}
