package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        new Main().run();
    }

    private void run() throws ArrayIndexOutOfBoundsException {
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.nextLine();

        equationNumsCount(equation);
        equationBracketsCheck(equation);
        equationIsCorrect(equation);
    }

    private void equationNumsCount(String equation) {
        String[] parts = equation.split("[x+\\-*/=()]+");
        int numsAmount = 0;
        for (int i = 1;i< parts.length; i++)
        {
            numsAmount++;
        }
        System.out.println("Кількість чисел у рівнянні = " + (numsAmount));
    }

    private void equationBracketsCheck(String equation) {
        String[] parts = equation.split("=");
        int bracketAmount = 0;
        for (String part : parts) {
            String[] equationParts = part.split("");
            for (String equationPart : equationParts) {
                if (equationPart.equals("(")) bracketAmount++;
                if (equationPart.equals(")")) bracketAmount--;
            }
        }
        if (bracketAmount != 0) System.out.println("Некорректне введення дужок!");
    }

    private void equationIsCorrect(String equation) {
        String[] parts = equation.split("");
        int errorsAmount = 0;
        String[] acts = {"+","*","/","."};
        for (int i = 0;i< parts.length-1; i++){
            if (parts[i+1] != null) {
                for (String n : acts) {
                    if ((parts[i].equals(n) || parts[i].equals("-")) && parts[i + 1].equals(n)) errorsAmount++;
                }
            }
        }
        if (errorsAmount > 0) System.out.println("Знайдено " + errorsAmount + " неправильно введених знаків математичних операцій поспіль!");
    }
}
