import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("John", "Doe", 25, "john.doe@example.com"),
                new User("Jane", "Doe", 30, "jane.doe@example.com"),
                new User("Alice", "Smith", 22, "alice.smith@example.com"),
                new User("Bob", "Johnson", 35, "bob.johnson@example.com")
        );

        // Задача 1: Фильтрация по возрасту и вывод уникальных фамилий
        users.stream()
                .filter(user -> user.getAge() > 25)
                .map(User::getSurname)
                .distinct()
                .forEach(System.out::println);

        // Задача 2: Фильтрация по длине фамилии, вывод имен, выброс исключения при отсутствии результата
        Optional<String> firstName = users.stream()
                .filter(user -> user.getSurname().length() < 8)
                .map(User::getName)
                .findFirst();

        if (firstName.isPresent()) {
            System.out.println("Первое имя: " + firstName.get());
        } else {
            throw new RuntimeException("Нет результата");
        }
    }
}
