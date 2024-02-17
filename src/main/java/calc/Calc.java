package calc;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calc implements ICalc{

    private final Scanner scanner;

    public Calc(Scanner scanner) {
        this.scanner = scanner;
    }

    private int getDigit() {
        int num;

        try {
            num = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error");
            scanner.next();
            num = getDigit();
        }

        return num;
    }

    private char getOperation() {
        char operation;

        try {
            operation = scanner.next().charAt(0);
        } catch (NoSuchElementException e) {
            System.out.println("Error");
            scanner.next();
            operation = getOperation();
        }

        return operation;
    }

    private int calc(int num1, int num2, char operation) {
        int result;
        if (operation == '+') {
            result = num1 + num2;
        } else if (operation == '-') {
            result = num1 - num2;
        } else if (operation == '*') {
            result = num1 * num2;
        } else if (operation == '/') {
            result = num1 / num2;
        } else {
            System.out.println("Error");
            result = calc(num1, num2, getOperation());
        }

        return result;
    }

    public void process() {
        int num1 = getDigit();
        int num2 = getDigit();
        char operation = getOperation();
        int result = calc(num1, num2, operation);
        System.out.println("result " + result);
    }
}
