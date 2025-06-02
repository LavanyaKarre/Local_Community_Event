import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.net.http.*;
import java.net.URI;

// 1. Hello World Program
class CoreJavaExercises {
    public static void main(String[] args) throws Exception {
        System.out.println("1. Hello, World!");

        // 2. Simple Calculator
        Scanner sc = new Scanner(System.in);
        System.out.print("2. Enter two numbers: ");
        double a = sc.nextDouble(), b = sc.nextDouble();
        System.out.print("Choose (+, -, *, /): ");
        char op = sc.next().charAt(0);
        switch (op) {
            case '+': System.out.println("Result: " + (a + b)); break;
            case '-': System.out.println("Result: " + (a - b)); break;
            case '*': System.out.println("Result: " + (a * b)); break;
            case '/': System.out.println("Result: " + (b != 0 ? a / b : "Division by zero")); break;
        }

        // 3. Even or Odd Checker
        System.out.print("3. Enter an integer: ");
        int num = sc.nextInt();
        System.out.println((num % 2 == 0) ? "Even" : "Odd");

        // 4. Leap Year Checker
        System.out.print("4. Enter a year: ");
        int year = sc.nextInt();
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println(isLeap ? "Leap Year" : "Not a Leap Year");

        // 5. Multiplication Table
        System.out.print("5. Enter number: ");
        int n = sc.nextInt();
        for (int i = 1; i <= 10; i++) System.out.println(n + " x " + i + " = " + (n * i));

        // 6. Data Type Demonstration
        int i = 10; float f = 10.5f; double d = 20.5; char c = 'A'; boolean bool = true;
        System.out.println("6. Data Types: " + i + ", " + f + ", " + d + ", " + c + ", " + bool);

        // 7. Type Casting Example
        double val = 9.7; int intVal = (int) val; int val2 = 8; double doubleVal = val2;
        System.out.println("7. Double to Int: " + intVal + ", Int to Double: " + doubleVal);

        // 8. Operator Precedence
        int res = 10 + 5 * 2;
        System.out.println("8. Operator Precedence (10 + 5 * 2): " + res);

        // 9. Grade Calculator
        System.out.print("9. Enter marks out of 100: ");
        int marks = sc.nextInt();
        char grade = marks >= 90 ? 'A' : marks >= 80 ? 'B' : marks >= 70 ? 'C' : marks >= 60 ? 'D' : 'F';
        System.out.println("Grade: " + grade);

        // 10. Number Guessing Game
        int guess, rand = new Random().nextInt(100) + 1;
        do {
            System.out.print("10. Guess number (1-100): ");
            guess = sc.nextInt();
            System.out.println(guess < rand ? "Too low" : guess > rand ? "Too high" : "Correct!");
        } while (guess != rand);

        // 11. Factorial Calculator
        System.out.print("11. Enter non-negative number: ");
        int fact = sc.nextInt(); long factorial = 1;
        for (int j = 1; j <= fact; j++) factorial *= j;
        System.out.println("Factorial: " + factorial);

        // 12. Method Overloading
        System.out.println("12. Method Overloading: " + add(2, 3) + ", " + add(2.5, 3.5) + ", " + add(1, 2, 3));

        // 13. Recursive Fibonacci
        System.out.print("13. Enter n for Fibonacci: ");
        int fn = sc.nextInt();
        System.out.println("Fibonacci: " + fibonacci(fn));

        // 14. Array Sum and Average
        System.out.print("14. Number of elements: ");
        int len = sc.nextInt(); int[] arr = new int[len]; int sum = 0;
        for (i = 0; i < len; i++) { arr[i] = sc.nextInt(); sum += arr[i]; }
        System.out.println("Sum: " + sum + ", Average: " + ((double)sum/len));

        // 15. String Reversal
        System.out.print("15. Enter string: ");
        String s = sc.next();
        System.out.println("Reversed: " + new StringBuilder(s).reverse());

        // 16. Palindrome Checker
        System.out.print("16. Enter string: ");
        String p = sc.next().replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println(p.equals(new StringBuilder(p).reverse().toString()) ? "Palindrome" : "Not Palindrome");

        // 17. Class and Object Creation
        Car car = new Car("Toyota", "Corolla", 2020); car.displayDetails();

        // 18. Inheritance Example
        Animal a1 = new Animal(); a1.makeSound(); new Dog().makeSound();

        // 19. Interface Implementation
        Playable g = new Guitar(), pi = new Piano(); g.play(); pi.play();

        // 20. Try-Catch Example
        try {
            System.out.print("20. Enter 2 ints: ");
            int x = sc.nextInt(), y = sc.nextInt();
            System.out.println("Result: " + (x / y));
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero");
        }

        // 21. Custom Exception
        try {
            System.out.print("21. Enter age: ");
            int age = sc.nextInt();
            if (age < 18) throw new InvalidAgeException("Underage");
            System.out.println("Valid age.");
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 22. File Writing
        System.out.print("22. Enter text to write: ");
        sc.nextLine();
        String input = sc.nextLine();
        Files.writeString(new File("output.txt").toPath(), input);
        System.out.println("Written to file.");

        // 23. File Reading
        System.out.println("23. File contents: " + Files.readString(new File("output.txt").toPath()));

        // 24. ArrayList Example
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice"); names.add("Bob");
        System.out.println("24. Names: " + names);

        // 25. HashMap Example
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Tom"); map.put(2, "Jerry");
        System.out.println("25. Name for ID 1: " + map.get(1));

        // 26. Thread Creation
        new Thread(() -> System.out.println("26. Thread 1")).start();
        new Thread(() -> System.out.println("Thread 2")).start();

        // 27. Lambda Expressions
        List<String> list = Arrays.asList("Zebra", "Apple", "Mango");
        list.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("27. Sorted: " + list);

        // 28. Stream API
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("28. Even: " + nums.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()));

        // 29. Records
        List<Person> people = List.of(new Person("John", 25), new Person("Doe", 17));
        people.stream().filter(p1 -> p1.age() > 18).forEach(System.out::println);

        // 30. Pattern Matching for Switch
        patternMatch("Hello"); patternMatch(123); patternMatch(45.6);

        // Remaining exercises like JDBC, networking, and modules are better run in separate files due to setup.
        sc.close();
    }

    static int add(int a, int b) { return a + b; }
    static double add(double a, double b) { return a + b; }
    static int add(int a, int b, int c) { return a + b + c; }
    static int fibonacci(int n) { return (n <= 1) ? n : fibonacci(n - 1) + fibonacci(n - 2); }
    static void patternMatch(Object o) {
        switch (o) {
            case Integer i -> System.out.println("30. Integer: " + i);
            case String s -> System.out.println("String: " + s);
            case Double d -> System.out.println("Double: " + d);
            default -> System.out.println("Unknown type");
        }
    }
}

class Car {
    String make, model; int year;
    Car(String m, String mo, int y) { make = m; model = mo; year = y; }
    void displayDetails() { System.out.println("17. Car: " + make + " " + model + " " + year); }
}

class Animal { void makeSound() { System.out.println("18. Animal sound"); } }
class Dog extends Animal { void makeSound() { System.out.println("Dog barks"); } }
interface Playable { void play(); }
class Guitar implements Playable { public void play() { System.out.println("19. Playing Guitar"); } }
class Piano implements Playable { public void play() { System.out.println("Playing Piano"); } }
class InvalidAgeException extends Exception { InvalidAgeException(String msg) { super(msg); } }
record Person(String name, int age) {}
