package com.bbs.util;

public class BbsUtils {
    public static String getErrorMessage(String error) {
        if (error != null) {
            switch (error) {
                case "1":
                    return "아이디를 입력해주세요.";
                case "2":
                    return "존재하지 않는 아이디 입니다.";
                case "3":
                    return "비밀번호가 일치하지 않습니다.";
                default:
                    return "";
            }
        } else {
            return "";
        }
    }
}
