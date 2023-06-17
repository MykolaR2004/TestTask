package main;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        new Main().run();
    }

    private void run() throws ArrayIndexOutOfBoundsException {
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.nextLine();

        System.out.println("Кількість чисел у рівнянні = " + equationNumsCount(equation));
        if (equationBracketsCheck(equation) != 0) {System.out.println("Некорректне введення дужок!");}
        if (equationIsCorrect(equation) > 0) System.out.println("Знайдено " + equationIsCorrect(equation) + " неправильно введених знаків математичних операцій поспіль!");
    }

    private int equationNumsCount(String equation) {
        String[] parts = equation.split("[+\\-*/=()xх]+");
        int numsAmount = 0;
        for (String part : parts) {
            if (!Objects.equals(part, "")) {
                numsAmount++;
            }
        }
        return numsAmount;
    }

    private int equationBracketsCheck(String equation) {
        String[] parts = equation.split("=");
        int bracketAmount = 0;
        for (String part : parts) {
            bracketAmount = 0;
            String[] equationParts = part.split("");
            for (String equationPart : equationParts) {
                if (equationPart.equals("(")) bracketAmount++;
                if (equationPart.equals(")")) bracketAmount--;
            }
        }
        return bracketAmount;
    }

    private int equationIsCorrect(String equation) {
        String[] parts = equation.split("");
        int errorsAmount = 0;
        String[] acts = {"+","*","/","."};
        for (int i = 0 ; i< parts.length-1; i++){
            for (String act : acts) {
                if ((parts[i].equals(act) || parts[i].equals("-")) && (parts[i+1].equals("+") || parts[i+1].equals("*") || parts[i+1].equals("/"))) errorsAmount++;
            }
        }
        return errorsAmount;
    }
}
