package com.ohgiraffers.test.section01;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private static List<MemberDTO> memberList = new ArrayList<>();
    public static void addList(MemberDTO member) {
        memberList.add(member);
    }

    public List<MemberDTO> selecList() {
        return memberList;
    }

    public boolean updateMember(MemberDTO updateMember) {
        MemberDTO old = null;

        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId() == updateMember.getId()) {
                old = memberList.set(i, updateMember);
            }
        }
        return old != null;
    }

    public boolean removeMember(int id) {
        MemberDTO old = null;
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId() == id) {
                old = memberList.remove(i);
            }
        }
        return old != null;
    }
}
