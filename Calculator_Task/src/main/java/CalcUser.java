import java.util.Scanner;

// Step1: Encpsulation  (  Hiding data and providing controllled access )



public class CalcUser {
    public static double calculate(Operation operation, double a, double b) {
        return operation.execute(a, b);
    } //complex structure

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdvancedOperations calc = new AdvancedOperations();

        while (true) {
            System.out.println("Choose an operation: add, subtract, multiply, divide, power, modulo, or exit");
            String operation = scanner.next().toLowerCase();
            if (operation.equals("exit")) {
                System.out.println("Exiting calculator...");
                break;   // here could be used better end for solving the errors if unexpected input
            }

            System.out.println("Enter first number:"); // forgot to add ;
            double num1 = scanner.nextDouble();
            System.out.println("Enter second number:");
            double num2 = scanner.nextDouble();

            double result = switch (operation) {   // switching for commands with  errors not solved
                case "add" -> calculate(calc::add, num1, num2);
                case "subtract" -> calculate(calc::subtract, num1, num2);
                case "multiply" -> calculate(calc::multiply, num1, num2);
                case "divide" -> calculate(calc::divide, num1, num2);
                case "power" -> calculate(calc::power, num1, num2);
                case "modulo" -> calculate(calc::modulo, num1, num2);
                default -> {
                    System.out.println("Invalid operation");
                    yield Double.NaN;
                }
            };

            System.out.println("Result: " + result);
        }
        scanner.close(); //don't forget to close it
    }
}
