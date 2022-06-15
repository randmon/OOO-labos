package vechterspel.domain;

public abstract class Actor {
	private String naam;
	private int energieNiveau;
	private Spel spel;

	private static final int INIT_ENERGIE_NIVEAU = 1000;

	public Actor(String naam) throws DomainException{
		this(naam,INIT_ENERGIE_NIVEAU);
	}

	public Actor(String naam,int energieNiveau) throws DomainException{
		this.setNaam(naam);
		this.setEnergieNiveau(energieNiveau);
	}

	public String getNaam() {
		return naam;
	}

	private void setNaam(String naam) throws DomainException {
		if (naam == null || naam.isBlank()) throw new DomainException("Naam mag niet leeg zijn");
		this.naam = naam;
	}

	public int getEnergieNiveau() {
		return energieNiveau;
	}

	protected void setEnergieNiveau(int energieNiveau){
		this.energieNiveau = Math.max(energieNiveau, 0);
	}

	public int getInitEnergieNiveau() {
		return INIT_ENERGIE_NIVEAU;
	}

	public Spel getSpel(){
		return spel;
	}

	protected void setSpel(Spel spel) {
		this.spel = spel;
	}

	protected abstract void verwerkAanval(Vechter aanvaller);

	public boolean isDood(){
		return this.getEnergieNiveau() <= 0;
	}

	@Override
	public boolean equals(Object object){
		if (object instanceof Actor actor){
			return this.getNaam().equals(actor.getNaam());
		}
		return false;
	}

	@Override
	public String toString(){
		return this.getNaam() + (isDood()?" (💀)":"")+" - ❤ " + this.getEnergieNiveau();
	}
}
