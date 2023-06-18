package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;
    @BeforeEach
    void setUp(){
        main = new Main();
    }

    @org.junit.jupiter.api.Test
    void main() {
    }

    @Test
    void testNumsCount() {
        String equation = "2*x=10";
        int expected = 2, result = main.equationNumsCount(equation);
        assertEquals(expected,result,1e-6);
        String equation1 = "-1.3*5/x=1.2";
        int expected1 = 3, result1 = main.equationNumsCount(equation1);
        assertEquals(expected1,result1,1e-6);
        String equation2 = "17=2*x+5";
        int expected2 = 3, result2 = main.equationNumsCount(equation2);
        assertEquals(expected2,result2,1e-6);
        String equation3 = "2*x+5+x+5=10";
        int expected3 = 4, result3 = main.equationNumsCount(equation3);
        assertEquals(expected3,result3,1e-6);
    }

    @Test
    void testBracketsCheck(){
        String equation = ")2*x+5+x+5(=10";
        int expected = -1, result = main.equationBracketsCheck(equation);
        assertEquals(expected,result,1e-6);
        String equation1 = "(2*x+5+x+5)=(10";
        int expected1 = 1, result1 = main.equationBracketsCheck(equation1);
        assertEquals(expected1,result1,1e-6);
        String equation2 = "2*x+(5+x+5)=10";
        int expected2 = 0, result2 = main.equationBracketsCheck(equation2);
        assertEquals(expected2,result2,1e-6);
        String equation3 = "2*x+5+x+5=)10";
        int expected3 = -1, result3 = main.equationBracketsCheck(equation3);
        assertEquals(expected3,result3,1e-6);
    }

    @Test
    void testMathSigns(){
        String equation = "2*x+5+x+5=10";
        int expected = 0, result = main.equationIsCorrect(equation);
        assertEquals(expected,result,1e-6);
        String equation1 = "3+*4=3";
        int expected1 = 1, result1 = main.equationIsCorrect(equation1);
        assertEquals(expected1,result1,1e-6);
        String equation2 = "4*-7*x=28";
        int expected2 = 0, result2 = main.equationIsCorrect(equation2);
        assertEquals(expected2,result2,1e-6);
        String equation3 = "4*-7*x=-28";
        int expected3 = 0, result3 = main.equationIsCorrect(equation3);
        assertEquals(expected3,result3,1e-6);
        String equation4 = "4*-7*x=*-28";
        int expected4 = 1, result4 = main.equationIsCorrect(equation4);
        assertEquals(expected4,result4,1e-6);
    }
}