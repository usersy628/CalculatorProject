package com.example.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        /*
        [ STEP 1 ] 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기
        1. 숫자 2개를 입력 받을수 있고 exit까지 계속 값을 받음
        2. 사칙연산 수행
        3. 연산 결과 반환
        4. 반복문 사용으로 <"exit" 문자열 입력하기 전까지> 무한으로 계산하도록 수정하기
        */

        System.out.println("Hello, Calculator!");
        Calculator cal = new Calculator(0, 0, '+', 0);
        ArithmeticCalculator<Number> calc = new ArithmeticCalculator<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            boolean isExit = cal.getMenu(); // 메뉴를 app으로 빼고싶은데 쓸 힘이 없다....
            if (isExit) {
                break;
            }
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double num1 = sc.nextDouble();
                System.out.print("사칙연산 기호를 입력하세요: ");
                char symbol = sc.next().charAt(0);
                System.out.print("두 번째 숫자를 입력하세요: ");
                double num2 = sc.nextDouble();

                double result = calc.calculate(num1, Operator.from(symbol), num2);
                System.out.println("결과: " + result); // 결과 반환

                cal.addResultList(result); // 결과 저장
                cal.addCalculation(num1, symbol, num2, result); // 계산 기록 저장
            } catch (InputMismatchException e) {
                System.out.println("※ InputMismatchException ※ :" + e.getMessage());
                sc.nextLine(); // 루프 방지
            } catch (Exception e) {
                System.out.println("※ Exception ※ : " + e.getMessage());
            }
        }
    }
}
