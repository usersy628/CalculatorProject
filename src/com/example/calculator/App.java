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
            System.out.println("메뉴 선택 - [1] 계산하기 [2] 데이터 삭제 [3] 결과 모아보기 [4] 입력값보다 큰 값 조회 [5] 프로그램 종료");
            String menu = sc.next();
            switch (menu) {
                case "1":
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
                    } catch (InputMismatchException e) {
                        System.out.println("※ InputMismatchException ※ :" + e.getMessage());
                        sc.nextLine(); // 루프 방지
                    } catch (Exception e) {
                        System.out.println("※ Exception ※ : " + e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("가장 먼저 저장된 데이터 삭제? yes: 1 | 메뉴로 돌아가기: 아무거나 입력 ");
                    if (sc.nextInt() == 1) {
                        try {
                            cal.removeResult();
                            break;
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("저장된 데이터가 없습니다");
                            break;
                        }
                    }
                    break;
                case "3":
                    System.out.println("결과 값 모아보기 : yes: 1 | 메뉴로 돌아가기: 아무거나 입력");
                    if (sc.nextInt() == 1) {
                        if (cal.getResultList().isEmpty()) {
                            System.out.println("저장된 결과가 없습니다.");
                            break;
                        }
                        for (int i = 0; i < cal.getResultList().size(); i++) {
                            System.out.println(i + 1 + "번째 : " + cal.getResultList().get(i));
                        }
                    }
                    break;
                case "4":
                    System.out.println("입력값보다 큰 결과만 조회하기 : yes: 1 | 메뉴로 돌아가기: 아무거나 입력");
                    if (sc.nextInt() == 1) {
                        System.out.print("기준 값을 입력하세요: ");
                        double input = sc.nextDouble();
                        cal.findGreaterThan(input).forEach(System.out::println);
                    }
                    break;
                case "5":
                    System.out.println("exit 입력 시 종료됩니다. 메뉴로 돌아가기: 아무거나 입력");
                    if (sc.next().equals("exit")) {
                        System.out.println("프로그램 종료");
                        return;
                    }
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
                    

                
            
