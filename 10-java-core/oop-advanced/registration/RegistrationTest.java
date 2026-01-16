package oop_advanced.registration;

public class RegistrationTest {
    public static void main(String[] args) {
        UserController c = new UserController();
        System.out.println(c.register("J","bad","weak",10).errors);
        System.out.println(c.register("John","john@email.com","Strong1Pass",25).message);
    }
}
