package com.example.instagramclone.utill;

public class Script {

    public static String back(String msg) {
        StringBuffer sb = new StringBuffer();
        sb.append("<script>");
        sb.append("alert('").append(msg).append("');");
        sb.append("history.back();");
        sb.append("</script>");
        return sb.toString();
    }
}
