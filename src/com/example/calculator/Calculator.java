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
        4. 반복문 사용으로 <"exit" 문자열 입력하기 전까지> 무한으로 계산하도록 수정하기
        */

        boolean flag = true;
        int result = 0;

        Scanner sc = new Scanner(System.in);

        while(flag == true){

            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char symbol = sc.next().charAt(0);

            // 연산 오류 방지: 기호 입력 받을 때 까지
            while (!(symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/' )) {
                System.out.print("기호를 다시 입력하세요: ");
                symbol = sc.next().charAt(0);
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

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
            System.out.println("결과: " + result); // 결과 반환

            System.out.println("더 계산하시겠습니까?");
            System.out.println("[1] 계산하기");
            System.out.println("[2] exit");
            int resetNum = sc.nextInt();
            if (resetNum == 2) {
                break;
            }
        }
    }
}
