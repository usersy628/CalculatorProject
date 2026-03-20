package com.example.calculator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Calculator {
    /*
    [ STEP 2 ] 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기
    1. 사칙연산 수행 후 결과 반환 메소드 & 연산 결과 저장하는 컬렉션타입 필드를 가진 Calculator 클래스 생성
    */

    // 속성
    ArrayList<Integer> result = new ArrayList<>();
    int num1;
    int num2;
    char symbol;


    // 양의 정수 2개와 연산기호 매개변수 - 사칙연산 수행 - 반환
    public static int calculator(int num1, char symbol, int num2) {
        int result = 0;

        // 사칙연산 케이스 지정 ( addition / subtraction / multiply / division )
        switch (symbol) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': result = num1 / num2; break;
        }

        return result;
    }
}