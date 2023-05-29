package cliController;

public class StoreNotValidException extends Exception{
	public StoreNotValidException(String error){
		super(error);
	}
}
