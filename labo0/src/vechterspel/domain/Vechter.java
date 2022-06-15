package vechterspel.domain;

public abstract class Vechter extends Actor {
	
	private int kracht;
	
	public Vechter(String naam, int kracht) throws DomainException{
		super(naam);
		this.setKracht(kracht);	
	}
	
	public Vechter(String naam, int kracht, int energieNiveau) throws DomainException{
		super(naam, energieNiveau);	
		this.setKracht(kracht);		
	}
	
	public int getKracht() {
		return kracht;
	}

	private void setKracht(int kracht) throws DomainException{
		if (kracht <= 0) throw new DomainException();
		this.kracht = kracht;
	}	
	
	public void valAan(Actor tegenstander) throws DomainException{
		if (this.isDood()){
			throw new DomainException("aanvaller moet leven en mag niet null zijn");
		}
		if (tegenstander == null|| tegenstander.isDood()){
			throw new DomainException("tegenstandaard moet leven en mag niet null zijn");
		}
		if (this.equals(tegenstander)){
			throw new DomainException("aanvaller kan zichzelf niet aanvallen");
		}
		if (tegenstander instanceof Vechter){
			this.verwerkAanval((Vechter)tegenstander);
		}	
		tegenstander.verwerkAanval(this);
	}
	
	protected void verwerkAanval(Vechter tegenstander){
		if (this.getKracht() != tegenstander.getKracht())
			this.setEnergieNiveau(this.getEnergieNiveau() - tegenstander.getKracht());
	}
	
	@Override
	public String toString(){
		return  super.toString() +" | ⚡ " + this.getKracht();
	}


}	

