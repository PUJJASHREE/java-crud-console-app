import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email;
    }
}
public class CrudApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<User> users = new ArrayList<>();
    private static int idCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- User CRUD Menu ---");
            System.out.println("1. Add User (POST)");
            System.out.println("2. Get All Users (GET)");
            System.out.println("3. Get User by ID");
            System.out.println("4. Update User");
            System.out.println("5. Delete User");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1 -> addUser();
                case 2 -> listUsers();
                case 3 -> getUserById();
                case 4 -> updateUser();
                case 5 -> deleteUser();
                case 6 -> {
                    System.out.println("Exiting app.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addUser() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Enter email: ");
        String email = scanner.nextLine();

        User user = new User(idCounter++, name, email);
        users.add(user);
        System.out.println("User added successfully!");
    }

    private static void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }
        for (User user : users) {
            System.out.println(user);
        }
    }

    private static void getUserById() {
        System.out.println("Enter user ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (User user : users) {
            if (user.getId() == id) {
                System.out.println(user);
                return;
            }
        }
        System.out.println("User not found.");
    }

    private static void updateUser() {
        System.out.println("Enter user ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (User user : users) {
            if (user.getId() == id) {
                System.out.println("Enter new name: ");
                String name = scanner.nextLine();

                System.out.println("Enter new email: ");
                String email = scanner.nextLine();

                user.setName(name);
                user.setEmail(email);
                System.out.println("User updated successfully!");
                return;
            }
        }
        System.out.println("User not found.");
    }

    private static void deleteUser() {
        System.out.println("Enter user ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        users.removeIf(user -> user.getId() == id);
        System.out.println("User deleted if ID matched.");
    }
}
