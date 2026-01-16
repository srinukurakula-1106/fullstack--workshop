package oop_advanced.registration;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String msg) { super(msg); }
}
