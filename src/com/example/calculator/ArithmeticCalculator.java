package com.example.calculator;


public class ArithmeticCalculator<T extends Number> {
    /*
    [ STPE 3 ] Enum, 제네릭, 람다 & 스트림을 이해한 계산기 만들기
    1. Enum 활용(연산자 타입에 대한 정보를 관리) - 사칙연산 계산기 ArithmeticCalculator 클래스에 활용
    2. 제네릭 활용 - 실수, 즉 double 타입의 값을 전달 받아도 연산이 수행하도록 만들기

    */
    public double calculate (T a, Operator op, T b) {
        double num1 = a.doubleValue();
        double num2 = b.doubleValue();

        return op.apply(num1, num2);
    }

}
