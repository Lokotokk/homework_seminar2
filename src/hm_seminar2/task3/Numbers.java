package hm_seminar2.task3;

import seminar2OtherEx.DivisionException;

import java.util.Scanner;

public class Numbers {
    public static String checkingNumbers(int first, int second, int third) throws NumberOutOfRangeException, NumberSumException, DivisionByZeroException {
        if (first > 100) {
            throw new NumberOutOfRangeException("Первое число вне допустимого диапазона");
        }
        if (second < 0) {
            throw new NumberOutOfRangeException("Второе число вне допустимого диапазона");
        }
        if ((first + second) < 10) {
            throw new NumberSumException("Сумма первого и второго чисел слишком мала");
        }
        if (third == 0) {
            throw new DivisionByZeroException("Деление на ноль недопустимо");
        }
        return "Проверка пройдена успешно";
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            int userFirstNum = in.nextInt();
            System.out.print("Введите второе число: ");
            int userSecondNum = in.nextInt();
            System.out.print("Введите третье число: ");
            int userThirdNum = in.nextInt();
            in.close();
            String result = checkingNumbers(userFirstNum, userSecondNum, userThirdNum);
            System.out.println(result);
        } catch (NumberOutOfRangeException | NumberSumException | DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }
    }
}
