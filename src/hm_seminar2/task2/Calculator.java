package hm_seminar2.task2;


import java.util.Scanner;

public class Calculator {
    public static double divide(int dividend, int divisor) throws DivisionByZeroException {
        if (divisor == 0) {
            throw new DivisionByZeroException("Деление на ноль недопустимо");
        }
        return (double) dividend / divisor;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите делимое: ");
            int userDividend = in.nextInt();
            System.out.print("Введите делитель: ");
            int userDivisor = in.nextInt();
            in.close();
            double result = divide(userDividend, userDivisor);
            System.out.println("Result: " + result);
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }
    }
}
