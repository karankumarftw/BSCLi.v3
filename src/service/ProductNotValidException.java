package service;

public class ProductNotValidException extends Exception{
	public ProductNotValidException(String error){
		super(error);
	}
}
