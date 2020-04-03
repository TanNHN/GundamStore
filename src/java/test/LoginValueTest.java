/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Tan
 */
public class LoginValueTest {
    public static void main(String[] args) {
        String name = "Behoi";
        if (name==null) {
            System.out.println("1");
        }
        else{
            if (name.length() > 5) {
                System.out.println("MyProfile");
                System.out.println("Loguot");
            }
            else{
                System.out.println(name);
                System.out.println("Loguot");
                if (name.equals("Behoi")) {
                    System.out.println("1111111");
                }
                else{
                    System.out.println("2222222222");
                }
                if (name.length()==5) {
                    System.out.println("Dung");
                }
                else
                    System.out.println("aaaaaaaaaaaa");
            }
        }
    }
}
