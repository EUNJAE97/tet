package com.ohgiraffers.test.section01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Manager manager = new Manager();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu() {

        mainMenu:
        while (true) {
            System.out.println("======= 메뉴 =======");
            System.out.println("1. 회원 정보 입력");
            System.out.println("2. 회원 정보 조회");
            System.out.println("3. 회원 정보 수정");
            System.out.println("4. 회원 정보 삭제");
            System.out.println("5. 프로그램 종료");

            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();


            switch (menu) {
                case 1:
                    addList();
                    break;
                case 2:
                    selectList();
                    break;
                case 3:
                    updateList();
                    break;
                case 4:
                    removeMember();
                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    break mainMenu;
            }
        }
    }

    public void addList() {
        System.out.println("==== 회원 정보 입력 ====");
        System.out.print("이름 입력 : ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();
        System.out.print("성별 입력 : ");
        char gender = sc.next().charAt(0);

        Manager.addList(new MemberDTO(name, age, gender));
    }
    public void selectList() {
        System.out.println("==== 회원 전체 조회 ====");
        List<MemberDTO> memberList = manager.selecList();

        if (!memberList.isEmpty()) {
            for (MemberDTO member : memberList) {
                System.out.println(member);
            }
        }else {
            System.out.println("회원이 존재하지 않습니다.");
        }
    }
    public void updateList() {
        System.out.println("==== 회원 정보 수정 ====");
        System.out.print("수정할 회원의 id : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("수정할 회원 이름 : ");
        String updateName = sc.nextLine();
        System.out.print("수정할 회원 나이 : ");
        int updateAge = sc.nextInt();
        sc.nextLine();
        System.out.print("수정할 회원 성별 : ");
        char updateGender = sc.next().charAt(0);


        MemberDTO updateMember = new MemberDTO(id, updateName, updateAge,updateGender);

        if (manager.updateMember(updateMember)){
            System.out.println("수정 되었습니다.");
        }else {
            System.out.println("수정할 회원 정보를 찾지 못했습니다.");
        }
    }
    public void removeMember() {
        System.out.println("==== 회원 정보 삭제 ====");
        System.out.print("삭제할 회원 id : ");
        if (manager.removeMember(sc.nextInt())) {
            System.out.println("삭제 되었습니다.");
        }else {
            System.out.println("삭제할 회원 정보를 찾지 못했습니다.");
        }
        sc.nextLine();
    }
}
