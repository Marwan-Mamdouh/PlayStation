package App;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {

    private Map<String, Admin> adminMap = new HashMap<>();

    public Login() {
        adminMap.put("Ahmed", new Admin("Ahmed", "12345"));
        adminMap.put("Omar", new Admin("Omar", "13579"));
    }

    public Admin login() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = input.nextLine();

        System.out.print("Enter your password: ");
        String password = input.nextLine();

        return Admin.login(adminMap, username, password);
    }
}
