import java.util.ArrayList;
import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args) {
        System.out.println("This program is a fraction calculator.\n" +
            "You can add, subtract, multiply and divide two fractions, or type 'Q' to quit.\n" +
            "This calculator only works with integer fractions, ex. 1/2 or -4/5. Whole numbers " +
            "are valid ex. -42 or -42/1");
        Scanner sc = new Scanner(System.in);
        String operation;
        do {
            System.out.println("-----------------------");
            operation = getOperation(sc);
            if (!operation.equals("Q") && !operation.equals("q")) {
                System.out.println("Provide two fractions.");
                Fraction fraction1 = getFraction(sc);
                Fraction fraction2 = getFraction(sc);
                Fraction result = null;
                switch (operation) {
                    case "+":
                        result = fraction1.add(fraction2);
                        break;
                    case "-":
                        result = fraction1.subtract(fraction2);
                        break;
                    case "*":
                        result = fraction1.multiply(fraction2);
                        break;
                    case "/":
                        result = fraction1.divide(fraction2);
                        break;
                }
                System.out.println(fraction1.toString() + " " + operation + " " + fraction2.toString() + " = " + result.toString());
            }
        } while (!operation.equals("Q") && !operation.equals("q"));
    }

    public static String getOperation(Scanner sc){
        String prompt = "Please enter an operation (+, -, *, /, or Q to quit): ";
        System.out.print(prompt);
        String input = sc.nextLine();
        while (!isValidOperation(input)) {
            System.out.print("Invalid input. " + prompt);
            input = sc.nextLine();
        }
        return input;
    }

    public static Boolean isValidOperation(String s) {
        if (s.equals("Q") || s.equals("q")) return true;
        if (s.equals("+")) return true;
        if (s.equals("-")) return true;
        if (s.equals("*")) return true;
        if (s.equals("/")) return true;
        return false;
    }

    public static Fraction getFraction(Scanner sc) {
        String prompt = "Please enter an integer fraction or integer, ex. 'a/b' or 'a': ";
        System.out.print(prompt);
        String input = sc.nextLine();
        while (!isValidFraction(input)) {
            System.out.print("Invalid fraction. " + prompt);
            input = sc.nextLine();
        }
        String[] inputArray = input.split("/");
        ArrayList<Integer> ints = new ArrayList<>();
        for (String s : inputArray) {
            int i = Integer.parseInt(s);
            ints.add(i);
        }
        if (inputArray.length == 1) {
            return new Fraction(ints.get(0));
        }
        if (inputArray.length == 2) {
            return new Fraction(ints.get(0), ints.get(1));
        }
        return null;
    }

    public static Boolean isValidFraction(String input) {
        if (input.matches("-?\\d/?\\d?")) {
            return true;
        }
        return false;
    }

}
