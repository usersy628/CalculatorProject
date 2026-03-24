package com.example.calculator;

public enum Operator { // “미리 정해진 버튼만 있는 리모컨”
    ADD('+') { // 연산을 객체로 만들기: 문자 -> 안전한 타입으로 변환
        public int apply(int a, int b) {
            return a + b;
        }
    }, SUB('-'){
        public int apply(int a, int b) {
            return a - b;
        }
    }, MUL('*') {
        public int apply(int a, int b) {
            return a * b;
        }
    }, DIV('/') {
        public int apply(int a, int b) {
            if(b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
            return a / b;
        }
    };

    private final char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

    public abstract int apply (int a, int b); // 연산이 어떻게 계산되는지 정의

    public static Operator from (char symbol) { // 사용자 입력을 enum으로 변환
        for (Operator op : values()) {
            if (op.symbol == symbol) return op;
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }
}
