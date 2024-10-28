import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Задание 1.1
        System.out.println("-------------- Задание 1.1 --------------\n");
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        ArrayList<Integer> UniqueNumbers = UniqueList.removeDuplicates(numbers);
        System.out.println("Уникальные числа: " + UniqueNumbers);
        // Задание 1.2
        System.out.println("\n-------------- Задание 1.2 --------------\n");
        Integer[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int SearchResult1 = LinearSearch.linearSearch(array1, 3);
        System.out.println(SearchResult1 != -1 ? "Индекс искомого числа: " + SearchResult1 : "Число не найдено");
        // Задание 1.3
        System.out.println("\n-------------- Задание 1.3 --------------\n");
        Circle circle1 = new Circle(1.2);
        Circle circle2 = new Circle(2.1);
        Circle circle3 = new Circle(3.9);
        Circle circle4 = new Circle(4.5);
        Circle circle5 = new Circle(5.8);
        Circle[] array2 = {circle1, circle2, circle3, circle4, circle5};
        Circle BiggerCircle = MaxElement.findMax(array2);
        System.out.println("Радиус наибольшего круга: " + BiggerCircle.getRadius());
        // Задание 1.4
        System.out.println("\n-------------- Задание 1.4 --------------\n");
        Integer[][] array3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int SearchResult2 = MaxElementIn2D.findMax(array3);
        System.out.println("Наибольшее число в двумерном массиве: " + SearchResult2);
        // Задание 2.1 и 2.2
        System.out.println("\n----------- Задание 2.1 и 2.2 ------------\n");
        Scanner scanner = new Scanner(System.in);
        GenericStack1<String> stack1 = new GenericStack1<>();
        GenericStack2<String> stack2 = new GenericStack2<>();
        System.out.println("Введите пять строк:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Строка " + (i + 1) + ": ");
            String input = scanner.nextLine();
            stack1.push(input);
            stack2.push(input);
        }
        System.out.println("\nСтроки в обратном порядке (GenericStack1):");
        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop()); // Извлекаем и выводим строки в обратном порядке
        }

        System.out.println("\nСтроки в обратном порядке (GenericStack2):");
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop()); // Извлекаем и выводим строки в обратном порядке
        }
        scanner.close();
    }
}
