package vechterspel.domain;

public class Vampier extends Vechter implements Reincarneerbaar{

	public Vampier(String naam, int kracht) throws DomainException {
		super(naam, kracht);		 
	}
	
	public Vampier(String naam, int kracht, int energieNiveau) throws DomainException {
		super(naam, kracht,  energieNiveau);		 
	}
	
	@Override
	protected void verwerkAanval(Vechter tegenstander){
		if (this.getKracht() > tegenstander.getKracht()) 
			 this.setEnergieNiveau(this.getEnergieNiveau() + tegenstander.getKracht());
		else super.verwerkAanval(tegenstander);
	}
	
	@Override
	public String toString(){
		return "Vampier : " + super.toString();
	}
	
	@Override
	public boolean equals(Object object){
		boolean gelijk = false;
		if (object instanceof Vampier){
			gelijk = super.equals(object);
		}
		return gelijk;
	}
	
	@Override
	public void reincarneer() {
		setEnergieNiveau(getSpel().getLaagsteEnergieNiveau());		
	}
	
}
