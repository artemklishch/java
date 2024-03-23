import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<User> userComparator = new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                int nameCompared = Integer.compare(user1.getAge(), user2.getAge());
                if (nameCompared != 0) {
                    return nameCompared;
                }
                return user1.getName().compareTo(user2.getName());
            }
        };

        // correct solution
//        Comparator<Employee> employeeComparator = new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                if (employee1.getAge() == employee2.getAge()) {
//                    return employee1.getName().compareTo(employee2.getName());
//                }
//                return Integer.compare(employee1.getAge(), employee2.getAge());
//            }
//        };
//        Set<Employee> sortedEmployees = new TreeSet<>(employeeComparator);
//        sortedEmployees.addAll(employees);
//        return sortedEmployees;

        Set<User> users1 = new TreeSet<>(userComparator);
        users1.add(new User("Bob", 23));
        users1.add(new User("Alice", 22));
        users1.add(new User("John", 27));
        users1.add(new User("Bob", 27));
        users1.add(new User("Bob", 19));
        System.out.println(users1);

    }
}