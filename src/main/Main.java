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
        if (equationBracketsCheck(equation) != 0) System.out.println("Некорректне введення дужок!");
        if (equationIsCorrect(equation) > 0) System.out.println("Знайдено більше одного знаків математичних операцій поспіль!");
    }

    public int equationNumsCount(String equation) {
        String[] parts = equation.split("[+\\-*/=()x ]+");
        int numsAmount = 0;
        for (String part : parts) {
            if (!Objects.equals(part, "")) {
                numsAmount++;
            }
        }
        return numsAmount;
    }

    public int equationBracketsCheck(String equation) {
        String[] parts = equation.split("=");
        int bracketAmount = 0;
        for (String part : parts) {
            String[] equationParts = part.split("");
            for (String equationPart : equationParts) {
                if (equationPart.equals("(")) bracketAmount++;
                if (equationPart.equals(")")) bracketAmount--;
                if (bracketAmount<0) return bracketAmount;
            }
            if (bracketAmount !=0) return bracketAmount;
        }
        return bracketAmount;
    }

    public int equationIsCorrect(String equation) {
        String[] parts = equation.split("");
        int errorsAmount = 0;
        String[] acts = {"+","*","/",".","="};
        for (int i = 0 ; i< parts.length-1; i++){
            for (String act : acts) {
                if ((parts[i].equals(act) || parts[i].equals("-")) && (parts[i+1].equals("+") || parts[i+1].equals("*") || parts[i+1].equals("/")|| parts[i+1].equals("="))) errorsAmount++;
            }
        }
        return errorsAmount;
    }
}
