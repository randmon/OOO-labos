package vechterspel.domain;

public class DomainException extends Exception {

	public DomainException(){
		super();
	}
	
	public DomainException(String boodschap){
		super(boodschap);
	}

}
