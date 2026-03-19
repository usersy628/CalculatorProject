package com.example.calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        System.out.println("Hello, Calculator!");
        /*
        [ STEP 1 ] 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기
        1. 숫자 2개를 입력 받을수 있고 exit까지 계속 값을 받음
        2. 사칙연산 수행
        3. 연산 결과 반환
        */

        Scanner sc = new Scanner(System.in); // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt();
        System.out.print("사칙연산 기호를 입력하세요: "); // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
        char symbol = sc.next().charAt(0);
        System.out.print("두 번째 숫자를 입력하세요: "); // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        int num2 = sc.nextInt();
        int result = 0;

        // 사칙연산 케이스 지정 ( addition / subtraction / multiply / division )
        switch(symbol) {
            case '+': result = num1 + num2;
            break;
            case '-': result = num1 - num2;
            break;
            case '*': result = num1 * num2;
            break;
            case '/': result = num1 / num2;
            break;
        }
        System.out.println("결과: " + result);
    }
}
