package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // implement algorithm here
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Frank", "Anne", (byte)18);
        System.out.println("Successfully saved Frank Anne user");
        userService.saveUser("Bob", "Builder", (byte)32);
        System.out.println("Successfully saved Bob Builder user");
        userService.saveUser("Jacob", "Daniel", (byte)31);
        System.out.println("Successfully saved Jacob Daniel user");
        userService.saveUser("Jesse", "Smith", (byte)53);
        System.out.println("Successfully saved Jesse Smith user");

        List<User> users = userService.getAllUsers();
        for(User user : users) {
            System.out.println(user);
        }

        userService.cleanUsersTable();

        userService.dropUsersTable();

    }
}
