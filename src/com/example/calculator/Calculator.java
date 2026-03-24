package com.example.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    /*
    [ STEP 2 ] 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기
    1. 사칙연산 수행 후 결과 반환 메소드 & 연산 결과 저장하는 컬렉션타입 필드를 가진 Calculator 클래스 생성
    2. STEP 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정
    */

    // 속성
    private int num1;
    private int num2;
    private char symbol;
    private int result = 0;
    private ArrayList<Integer> resultList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);


    // 생성자
    public Calculator(int num1, int num2, char symbol) {
        this.num1 = num1;
        this.num2 = num2;
        this.symbol = symbol;
    }

    // 기능
    // 게터
    public int getNum1() {
        return num1;
    }
    public int getNum2() {
        return num2;
    }
    public char getSymbol() {
        return symbol;
    }
    public int getResult() {
        return result;
    }
    public ArrayList<Integer> getResultList() {
        return resultList;
    }

    // 세터
    public void setNum1(int num1) {
        this.num1 = num1;
    }
    public void setNum2(int num2) {
        this.num2 = num2;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setResult(int result) {
        this.result = result;
    }

    // 메뉴 선택
    public void getMenu(int menu) {
        System.out.println("메뉴 선택 \n [1] 계산하기 \n [2] 데이터 삭제 \n [3] 결과 모아보기 \n [4] 프로그램 종료");
        sc.nextInt();
        switch(menu) {
            case 1:; // 계산기
            case 2: removeResult();
            case 3: getResultList();
            case 4: break;
        }
    }

    // 계산결과 저장
    public void addResultList(int result) {
        resultList.add(result);
    }

    // 가장 먼저 저장된 데이터 삭제
    public void removeResult() {
        resultList.remove(0);
    }

    // 사칙연산 수행 - 반환
    public int calculator(int num1, char symbol, int num2) {
        switch (symbol) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 == 0) {
                    System.out.println("※ <잘못된 입력> 0으로 나눌 수 없습니다 ※ : ");
                }
                result = num1 / num2; break;
        }
        return result;
    }

    // Enum 적용해보기
}