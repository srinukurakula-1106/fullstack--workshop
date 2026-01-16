package oop_advanced.registration;

import java.util.*;

public class Result {
    public boolean success;
    public String message;
    public List<String> errors;

    public static Result success(String msg){
        Result r=new Result();
        r.success=true; r.message=msg;
        return r;
    }

    public static Result failure(List<String> errs){
        Result r=new Result();
        r.success=false; r.errors=errs;
        return r;
    }
}
