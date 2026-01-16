package oop_advanced.registration;

import java.util.*;

public class UserController {
    private UserService service = new UserService();

    public Result register(String n,String e,String p,int a){
        try {
            service.register(new User(n,e,p,a));
            return Result.success("User registered successfully");
        } catch (ValidationException ve) {
            return Result.failure(List.of(ve.getMessage()));
        } catch (DuplicateUserException de) {
            return Result.failure(List.of(de.getMessage()));
        }
    }
}
