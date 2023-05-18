package service;

public class NotANumberException extends Exception{
	NotANumberException(String error){
		super(error);
	}
}
