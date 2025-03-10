package com.korit.basic.chapter12;

/*
    === 학생 관리 시스템(Student Management System) ===
    : MVC 패턴을 사용하여 구현
    : CRUD 구조 사용

    1. 기능 정의
    - 학생 추가 기능
    - 전체 학생 조회 기능
    - 학생 수정 기능
    - 학생 삭제 기능
    - 특정 학생 조회 기능 (검색)
    - 프로그램 종료

    2. MVC 패천 구성 요소
    == Model (Student 클래스) ==
    @Field
        이름(name), 나이(age), 학번(studentId)
        - 각 필드에 접근할 수 있는 getter 및 setter 메서드 작성
        - 갹체 장보 출력을 위한 toString 메서드 작성

    == view (StudentView 클래스) ==
    @Field
        사용자와 상호작용하여 메뉴 표시
        - 6가지 동작 수행

    == controller (StudentController 클래스) ==
     @Field
        학생 데이터 저장을 위한 LIst<Student>
        - 학생 추가, 전체 조회, 특정 학생 조회, 수정, 삭제
 */
public class StudentManagement {
    public static void main(String[] args) {

    }
}
