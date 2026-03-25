package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Calculator {
    /*
    [ STEP 2 ] 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기
    1. 사칙연산 수행 후 결과 반환 메소드 & 연산 결과 저장하는 컬렉션타입 필드를 가진 Calculator 클래스 생성
    2. STEP 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정
    */

    // 속성
    private double num1;
    private double num2;
    private char symbol;
    private double result = 0;
    private ArrayList<Double> resultList = new ArrayList<>();
    private List<String> calculationList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);


    // 생성자
    public Calculator(double num1, double num2, char symbol, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.symbol = symbol;
        this.result = result;
    }

    // 기능
    // 게터
    public double getNum1() {
        return num1;
    }
    public double getNum2() {
        return num2;
    }
    public char getSymbol() {
        return symbol;
    }
    public double getResult() {
        return result;
    }
    public ArrayList<Double> getResultList() {
        return resultList;
    }
    public List<String> getCalculationList() {
        return calculationList;
    }

    // 세터
    public void setNum1(double num1) {
        this.num1 = num1;
    }
    public void setNum2(double num2) {
        this.num2 = num2;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setResult(double result) {
        this.result = result;
    }

    public boolean isCancle(int input) {
        if (input == 0) {
            System.out.println("메뉴로 돌아갑니다");
            return true;
        }
        return false;
    }

    // 메뉴 선택
    public boolean getMenu() {
        while (true) {
            System.out.println("메뉴 선택 \n [1] 계산하기 \n [2] 데이터 삭제 \n [3] 결과 모아보기 \n [4] 입력값보다 큰 값 조회 \n [5] 프로그램 종료");
            String menu = sc.next();

            switch (menu) {
                case "1": break;// 계산기
                case "2":
                    System.out.println("가장 먼저 저장된 데이터 삭제? yes: 1 | 메뉴로 돌아가기: 0 ");
                    if (sc.nextInt() == 1) {
                        try {
                            removeResult();
                            return false;
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("저장된 데이터가 없습니다");
                            return false;
                        }
                    }
                    break;
                case "3":
                    System.out.println("결과 값 모아보기 : yes: 1 | 메뉴로 돌아가기: 0");
                    if (sc.nextInt() == 1) {
                        if (resultList.isEmpty()) {
                            System.out.println("저장된 결과가 없습니다.");
                            break;
                        }
                        for (int i = 0; i < getResultList().size(); i++) {
                            System.out.println(i + 1 + "번째 : " + getResultList().get(i));
                        }
                    }
                    return false;
                case "4":
                    System.out.println("입력값보다 큰 결과만 조회하기 : yes: 1 | 메뉴로 돌아가기: 0");
                    if (sc.nextInt() == 1) {
                        System.out.print("기준 값을 입력하세요: ");
                        double input = sc.nextDouble();
                        findGreaterThan(input).forEach(System.out::println);
                    }
                    return false;
                case "5": // ...? 머리쥐난다
                    System.out.println("exit 입력 시 종료됩니다. 메뉴로 돌아가기: 0");
                    if (sc.next().equals("exit")) {
                        System.out.println("프로그램 종료");
                        return true;
                    }
                    return false;
                default:
                    System.out.println("잘못된 입력입니다.");
                    return false;
            }
            return false;
        }
    }

    // 계산결과 저장
    public void addResultList(double result) {
        resultList.add(result);
    }

    // 계산 기록 저장
    public void addCalculation(double num1, char symbol, double num2, double result) {
        calculationList.add(num1 + " " + symbol + " " + num2 + " = " + result);
    }

    // 가장 먼저 저장된 데이터 삭제
    public void removeResult() {
        resultList.remove(0);
        calculationList.remove(0);
        System.out.println("삭제 되었습니다.");
    }

    // 입력값보다 큰 결과만 조회
    public List<Double> findGreaterThan(double target) {
        return resultList.stream()
                .filter(result -> result >= target)
                .toList();
    }
}
