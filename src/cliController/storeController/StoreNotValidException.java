package cliController.storeController;

public class StoreNotValidException extends Exception{
	public StoreNotValidException(String error){
		super(error);
	}
}
