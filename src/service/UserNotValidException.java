package service;

public class UserNotValidException extends Exception{
	UserNotValidException(String error){
		super(error);
	}
}
