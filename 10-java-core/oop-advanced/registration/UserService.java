package oop_advanced.registration;

import java.util.*;

public class UserService {
    private static Set<String> emails = new HashSet<>();

    public void register(User u) throws ValidationException {
        if(u.name.length()<2) throw new ValidationException("Name too short");
        if(!u.email.contains("@")) throw new ValidationException("Invalid email");
        if(emails.contains(u.email)) throw new DuplicateUserException("Email already registered");
        if(u.password.length()<8) throw new ValidationException("Weak password");
        if(u.age<13) throw new ValidationException("Must be 13+");
        emails.add(u.email);
    }
}
