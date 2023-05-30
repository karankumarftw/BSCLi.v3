package cliController.unitController;

public class UnitNotValidException extends Exception{
	public UnitNotValidException(String error){
		super(error);
	}
}
