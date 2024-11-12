import java.util.Scanner;

@SuppressWarnings({"unchecked", "ThrowablePrintedToSystemOut"})
public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            MyStack<String> stack1 = new MyStack<>();
            MyStack2<String> stack2 = new MyStack2<>();
            for (int i = 0; i < 5; i++) {
                System.out.print("Строка " + (i + 1) + ": ");
                String input = scanner.nextLine();
                stack1.push(input);
                stack2.push(input);
            }
            System.out.println("\nСтроки в обратном порядке (MyStack):");
            while (!stack1.isEmpty()) {
                System.out.println(stack1.pop());
            }
            System.out.println("\nСтроки в обратном порядке (MyStack2):");
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
