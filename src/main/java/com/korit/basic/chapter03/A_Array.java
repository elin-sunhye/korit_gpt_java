package com.korit.basic.chapter03;

/*
    배열(Array) : 참조자료형
    : 같은 타입의 여러 변수를 하나의 집합으로 묶어서 처리하는 자료 구조
    - 데이터를 연속적으로 저장
    - 순서O (index 번호, 0부터 1씩 증가되는 값)
    - 중복O (동일한 값을 여러 요소에 저장 가능)
    cf) 요소 : 배열에서 각각의 데이터

    EX) 학생들의 시험 점수를 저장, 여러 개의 문자열을 다룰 때
*/

public class A_Array {
    public static void main(String[] args) {
        // 배열 vs 변수
        // 배열은 "생성한다" (같은 타입의 데이터를 여러 개 저장)
        // 변수는 "선언한다" (하나의 데이터만 저장)

        // 1) 변수
        int korean = 90;
        int math = 75;
        int english = 80;

        // 2) 배열
        // new 연산자


        //=== 배열 선언 ===//
        // >> 데이터 타입[] 배열명;
        // >> 데이터 타입 배열명[];
        int[] array; // 정수형 데이터를 담을수 있는 배열

        //=== 배열 생성 ===//
        // 실제 데이터가 저장 X 데이터 배열이 저장된 첫번째 메모리 주소가 저장
        // >> new 데이터타입[배열의 길이]
        array = new int[3];

        // cf) 참조 자료형 - 주소값이 저장
        System.out.println(array); // [I@43a25848

        //=== 배열 요소 접근 ===//
        // 배열명[인덱스번호]
        // +) 데이터 변경 (삽입) : 배열명[인덱스번호] = 데이터값;
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        // cf) 배열 생성 시 모든 요소는 해당 데이터타입의 기본값으로 초기화
        // 숫자(0), 문자열(''), 논리형(false)

        array[1] = 456;
        array[0] = 132;
        System.out.println(array[1]);
        System.out.println(array[0]);

        //=== 배열 선언과 동시에 초기화 ===//
        // : new 연산자를 사용한 직접적인 배열 생성 시 길이 지정 X
        // 요소의 개수를 파악하여 배열의 길이를 자동 지정

        // 1) 데이터타입[] 배열명 = new 데이터타입[] {요소1, 요소2, 요소3...};
        int[] scoreList = new int[]{30, 35, 100};
        System.out.println(scoreList[0]);

        // 2) 데이터타입[] 배열명 = {요소1, 요소2, 요소3...};
        char[] greet = {'h', 'e', 'l', 'l', 'o'};
        System.out.print(greet[0]);
        System.out.print(greet[1]);
        System.out.print(greet[2]);
        System.out.print(greet[3]);
        System.out.println(greet[4]);

        //=== 배열 길이(크기) ===//
        // .length
        System.out.println(greet.length);

        //=== 배열 특징 ===//
        // > 한번 생성되면 크기 변경 X
        // > 참조 타입으로 주소값이 저장
        // > 모든 요소는 같은 자료형이여야 한다.


        //=== 문자열 배열 생성 ===//
        // String 배열의 초기값은 null
        String[] fruits = new String[3];
        System.out.println(fruits[0]);

        fruits[0] = "사과";
        System.out.println(fruits[0]);

        //=== 문자열 요소 삭제 ===//
        // 삭제 기능을 담당하는 문법 X
        // > 삭제할 요소를 제외한 나머지 요소를 새로운 배열로 복사
        int[] original = {1, 2, 3, 4};
        int removeIdx = 2;

        int[] newArray = new int[original.length - 1];
        int k = 0; // 새로운 배열의 인덱스 번호

        int originalLength = original.length;
        for (int i = 0; i < originalLength; i++) {
            if (i == removeIdx) {
                continue; // 루프의 나머지 부분을 건너뛰고 다음 반복 진행
            }

            newArray[k] = original[i];
            k++;
        }
        System.out.println(newArray[0]);
        System.out.println(newArray[1]);
        System.out.println(newArray[2]);

        // === 배열을 순회하는 향상된 for문(for each 문) === //
        // for (데이터타입 변수명 : 해당 데이터타입의 배열) {
        // 배열의 모든 요소에 순차적으러 접근하는 코드
        // }

        int[] arrayNum = {1, 3, 5, 7, 9};
        for (int num : arrayNum) { // num 변수 : for문 내의 변수
            System.out.println(num);
        }

        // === 배열 활용 예시 === //
        // 힉생 점수 평균 계산
        int[] scores = {85, 100, 75, 60, 90};
        int total = 0;

        // 풀이
//        for (int score : scores) {
//            total += score; // total = total + score
//        }

        int length = scores.length;
        for (int i = 0; i < length; i++) {
            total += scores[i];
        }

//        double average = (double) total / scores.length;
        double average = (double) total / length;
        System.out.println("평균 점수 : " + average);
    }
}