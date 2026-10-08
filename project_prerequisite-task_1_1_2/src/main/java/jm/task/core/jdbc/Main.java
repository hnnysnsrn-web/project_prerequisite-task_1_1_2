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

        userService.saveUser("Frank", "Anne", 18);
        userService.saveUser("Bob", "Builder", 32);
        userService.saveUser("Jacob", "Daniel", 31);
        userService.saveUser("Jesse", "Smith", 53);

        List<User> users = userService.getAllUser();
        for(User user : users) {
            System.out.println(user);
        }

        userService.cleanUsersTable();

        userService.dropUserTable();

    }
}
