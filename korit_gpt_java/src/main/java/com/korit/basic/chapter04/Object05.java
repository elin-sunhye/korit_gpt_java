package com.korit.basic.chapter04;

/*
    객체 지향 프로그래밍의 '변수'
    
    필드 vs 지역변수
    1. 필드(속성)
    : 객체의 지속적인 상태를 저장하는 클래스 내부의 변수
    - 메서드 외부에 위치
    - 명시적으로 초기화하지 않으면 기본값으로 자동 초기화
        - 기본 타입 : int(0), boolean(false), char('')
        - 참조 타입 : null
    종류 : 인스턴스(instance)변수, 클래스(static)변수

    === 인스턴스(instance)변수  ===
    : 클래스의 각 객체(인스턴스)에 속한 변수
    > 클래스 내부에서 선언
    > 객체가 생성될때 메모리에 할당
    > 각 인스턴스마다 다른 값을 가질 수 있다.
    
    === 클래스(정적, static)변수  ===
    : 클래스의 모든 인스턴스에서 공유되는 데이터 변수
    > static 키워드를 사용하여 선언
    > 해당 클래스로 생성되는 인스턴스가 모두 동일한 값을 가진다.
    > 프로그래밍 시작될 때 생성 ~ 프로그램 종료 시 소멸
    : 메모리 속 메서드 area 공간에 저장

    2. 지역 변수
    : 메서드가 실행되는 동안에만 존재하는 일시적인 변수
    - 메서드, 생성자 또는 블록 내부에서 선언
    - 자동 초기화 X  반드시 초기화 후 사용 (초기화하지 않고 사용 시 에러)
*/

class CarClass {
    // 1. 필드(속성)
    // 1) 인스턴스(instance)변수
    // : 각 객체(인스턴스) 마다 다른 값
    String color;
    int speed;
    String brand;

    // 2) 클래스(정적, static)변수
    // : 해당 클래스로 생성되는 모든 객체가 동일한 값
    // : 데이터타입 앞에 static 키워드 사용
    // : 인스턴스화 하지 않아도 사용 가능
    static int tireNumber = 4;
    static int doorNumber;


    // 2. 지역 변수
    void accelerate(int increment) {
        // increment: 지역변수
        // >> 메서드 내부에서만 유효
        speed += increment; // speed = speed + increment

    }

}

public class Object05 {
    public static void main(String[] args) {
        // 클래스(정적, static)변수 사용 방법
        // 클래스명.필드명
        System.out.println(CarClass.tireNumber);
        System.out.println(CarClass.doorNumber);
        CarClass.doorNumber = 2;
        System.out.println(CarClass.doorNumber);


        // CarClass 인스턴스화
        CarClass car1 = new CarClass();
        CarClass car2 = new CarClass();

        // 객체의 인스턴스 변수 사용 방법
        car1.brand = "Kia";
        car1.color = "white";

        // cf) 각 인스턴스명으로도 static 변수 호출 가능 -> 클래스명 호출 방법을 권장
//        car1.doorNumber = 5;
//        System.out.println(car2.doorNumber); 5

    }
}
