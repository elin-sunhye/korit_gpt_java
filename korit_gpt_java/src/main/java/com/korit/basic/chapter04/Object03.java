package com.korit.basic.chapter04;

// === 클래스의 구조 === //
// 필드 : 데이터를 표현하는 속성
// 메서드: 데이터의 동작
// 생성자 : 데이터를 생성하는 역할 (인스턴스화 메서드)

class Car {
    // 클래스의 속성(필드)
    String model; // 모델
    int year; // 제조 연도

    // 클래스의 행동(메서드)
    // : 클래스 내부에서 정의된 함수, 객체의 행동을 표현
    // > 클래스의 속성(필드)을 사용하여 특정 작업을 수행하거나 해당 값을 변경 또는 반환 가능

    /*
        반환타입 메서드명(매개변수...) {
            메서드의 동작을 정의
        }

        cf) void 반환타입
            : 해당 메서드(함수, 행동)의 반환하는 결과가 X
            : 반환(return)이 존재하지 않을 경우 메서드명 앞에 반드시 작성
    */
    void displayInfo() {
        System.out.println("Model: " + model + ", Year: " + year);
        // return;
        // return pageNumber;
        // return; 다음에 코드 작성해도 읽히지 않음 = 오류
    }

    // 클래스의 생성자
    // : 클래스의 이름과 동일한 메서드
    // - 객체가 생성될 때 자동으로 호출
    // - 클래스 내부의 필드를 초기화할 때 주로 사용
    // +) 생성자는 반환타입을 가지지 X
    Car(String modelName, int year) {

        // 생성자 사용 시
        // modelName: xc60, year: 2024
        model = modelName;

        // this 키워드
        // > 클래스 그 자체의 객체를 가리킴, 객체 자신을 참조하는데 사용
        // > 클래스의 필드와 생성자로 받아오는 데이터의 이름이 같을 경우 구분하기 위해 사용
        this.year = year;
    }
}

public class Object03 {
    public static void main(String[] args) {
        // === 객체 생성 (객체 인스턴스화) === //
        // : new 연산자 사용
        //   - 클래스의 생성자 호출
        //   - 객체의 초기 상태를 설정
        //   - 생성된 객체의 메모리 주소를 반환하여 참조 변수에 저장

        // 생성자 호출 : 생성자명(필요한 매개변수...)
        // 해당 객체에 대한 참조(주소)를 클래스 타입의 변수에 저장
        Car myCar = new Car("volvo xc60", 2024);

        // === 객체 사용 === //
        // : .연산자를 사용하여 객체 내부의 필드와 메서드를 사용

        // 1. 필드 접근
        // 객체명.필드명
        System.out.println(myCar.model);
        System.out.println(myCar.year);

        // 2. 메서드 호출
        // 객체명.메서드명();
        myCar.displayInfo();

        // cf) 객체 생성 구문
        //      클래스명 객체명 = new 클래스명(생성자 매개변수);

        // cf) 클래스 타입
        //      지정된 클래스를 기반으로 생성된 객체 > 클래스 자체의 타입을 지님
    }
}