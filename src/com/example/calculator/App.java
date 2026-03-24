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
        Calculator cal = new Calculator(0, 0, '+');
        ArithmeticCalculator<Number> calc = new ArithmeticCalculator<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
//            cal.getMenu(int menu);
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double num1 = sc.nextDouble();
                System.out.print("사칙연산 기호를 입력하세요: ");
                char symbol = sc.next().charAt(0);

                // 연산 오류 방지: 기호 입력 받을 때 까지
                while (!(symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/')) {
                    System.out.print("※ <잘못된 입력> 기호를 다시 입력하세요 ※ : ");
                    symbol = sc.next().charAt(0);
                }

                System.out.print("두 번째 숫자를 입력하세요: ");
                double num2 = sc.nextDouble();

//                int result = cal.calculator(num1, symbol, num2);
                double result = calc.calculate(num1, Operator.from(symbol), num2);
                System.out.println("결과: " + result); // 결과 반환
                cal.addResultList(result);

                System.out.println("가장 먼저 저장된 데이터 삭제? yes:1 | else:아무거나 ");
                if (sc.nextInt() == 1) {
                    cal.removeResult();
                }

                System.out.println("결과 값 모아보기 : yes:1 | else:아무거나");
                if (sc.nextInt() == 1) {
                    cal.getResultList();
                    for (int i = 0; i < cal.getResultList().size(); i++) {
                        System.out.println(i + "번째 : " + cal.getResultList().get(i));
                    }
                }

                // 프로그램 종료
                System.out.println("exit 입력 시 종료됩니다. 계속 하려면 아무거나 입력하세요.");
                if (sc.next().equals("exit")) {
                    System.out.println("프로그램 종료");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("※ InputMismatchException ※ :" + e.getMessage());
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("※ Exception ※ : " + e.getMessage());
            }
        }
    }
}
