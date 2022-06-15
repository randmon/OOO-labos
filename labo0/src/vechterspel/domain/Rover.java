package vechterspel.domain;

public class Rover extends Vechter{
	
	public Rover(String naam, int kracht) throws DomainException{
		super(naam,kracht);
	}
	
	public Rover(String naam, int kracht, int energieNiveau) throws DomainException{
		super(naam,kracht,energieNiveau);
	}
	
	@Override
	public String toString(){
		return "Rover : " + super.toString();
	}
	
	@Override
	public boolean equals(Object object){
		boolean gelijk = false;
		if (object instanceof Rover){
			gelijk = super.equals(object);
		}
		return gelijk;
	}

}
