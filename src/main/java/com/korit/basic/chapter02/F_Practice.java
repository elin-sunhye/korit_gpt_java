package com.korit.basic.chapter02;

import java.util.Scanner;

public class F_Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isRun = true;

        while (isRun) {
            System.out.println("[메인 메뉴]");
            System.out.println("1. 회원 등록");
            System.out.println("2. 회원 조회");
            System.out.println("3. 회원 탈퇴");
            System.out.println("q. 프로그램 종료");

            System.out.print("메뉴 선택 : ");
            String selectedManu = sc.nextLine();

            switch (selectedManu) {
                case "1": // nextLine()의 입력값은 문자열
                    System.out.println("회원 등록 기능입니다.");
                    break;
                case "2":
                    System.out.println("회원 조회 기능입니다.");
                    boolean isRunMenu2 = true;

                    while (isRunMenu2) {
                        System.out.println("[화원 조회]");
                        System.out.println("1. 회원 번호로 조회");
                        System.out.println("2. 회원 이름으로 조회");
                        System.out.println("b. 뒤로 가기");

                        selectedManu = sc.nextLine();
                        switch (selectedManu) {
                            case "1":
                                System.out.println(">> 번호로 회원을 조회 합니다.");
                                break;
                            case "2":
                                System.out.println(">> 이름으로 회원을 조회 합니다.");
                                break;
                            case "b":
                                System.out.println(">> 메인 메뉴로 돌아갑니다.");
                                isRunMenu2 = false;
                                break;
                            default:
                                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                        }
                    }

                    break;
                case "3":
                    System.out.println("회원 탈퇴 기능입니다.");
                    break;
                case "q":
                    System.out.println("프로그램을 종료합니다.");
                    isRun = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");

            }
        }

        sc.close();
        System.out.println("프로그램이 종료되었습니다 :)");

    }
}