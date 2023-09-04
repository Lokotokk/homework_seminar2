package hm_seminar2.task1;

import hm_seminar2.task1.InvalidNumberException;

import java.util.Scanner;

public class Number {
    public static String isPositiveNumber (int num) throws InvalidNumberException {
        if (num <= 0) {
            throw new InvalidNumberException("Некорректное число");
        }
        return "Число корректно";
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите число: ");
            int userNum = in.nextInt();
            in.close();
            String result = isPositiveNumber(userNum);
            System.out.println(result);
        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}
