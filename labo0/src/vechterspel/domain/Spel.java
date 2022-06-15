package vechterspel.domain;
import java.util.ArrayList;
import java.util.List;

public class Spel {
	private final ArrayList<Actor> actoren = new ArrayList<>();
	
	public Spel(){
	}

	public ArrayList<Actor> getActoren() {
		return actoren;
	}

	public void voegActortoe(Actor actor) throws DomainException{
		if (actor == null){
			throw new DomainException("Actor mag niet null zijn");
		}
		if (actoren.contains(actor)){
			throw new DomainException("Actor bestaat al");
		}
		actoren.add(actor);
		actor.setSpel(this);
	}
	
	public void valAan(Vechter aanvaller, Actor tegenstander) throws DomainException{
		if (!actoren.contains(aanvaller) || !actoren.contains(tegenstander)){
			throw new DomainException("aanvaller en/of tegenstander niet in spel");
		}			
		aanvaller.valAan(tegenstander);
	}
	
	public List<Vechter> getLevendeVechters(){
		List<Vechter> vechters = new ArrayList<>();
		for (Actor actor: this.actoren)
			if (actor instanceof Vechter vechter){
				if (!vechter.isDood()) vechters.add(vechter);
			}
		return vechters;
	}
	
	public int getLaagsteEnergieNiveau(){
		int laagsteEnergieNiveau = Integer.MAX_VALUE;
		for (Actor actor:actoren){
			if (!actor.isDood() && actor.getEnergieNiveau() < laagsteEnergieNiveau){
				laagsteEnergieNiveau = actor.getEnergieNiveau();
			}
		}
		return laagsteEnergieNiveau;
	}
	
	public void reincarneerDodeActoren(){
		for (Actor actor: this.actoren){
			if (actor instanceof Reincarneerbaar reincarneerbaar){
				reincarneerbaar.reincarneer();
			}
		}
	}
	
	public Actor getRandomActor(){
		if (actoren.size() >0){
			int index = (int)(Math.random()*actoren.size());
			return actoren.get(index);
		}		
		return null;
	}

	// get random actor that is not the same as the given actor
	public Actor getRandomActor(Actor actor){
		List<Actor> actorsWithoutGivenActor = new ArrayList<>(actoren);
		actorsWithoutGivenActor = actorsWithoutGivenActor.stream().filter(
				a -> !a.equals(actor) && !a.isDood()
		).toList();
		if (actorsWithoutGivenActor.size() > 0){
			int index = (int)(Math.random() * actorsWithoutGivenActor.size());
			return actorsWithoutGivenActor.get(index);
		}
		return null;
	}
	
	public Vechter getRandomVechter() {
		List<Vechter> vechters = getLevendeVechters();
		if (vechters.size() > 0) {
			int index = (int) (Math.random() * vechters.size());
			return vechters.get(index);
		}
		return null;
	}
	
	@Override
	public String toString(){
		StringBuilder output = new StringBuilder();
		for (Actor actor : actoren){
			output.append(actor.toString()).append("\n");
		}
		return output.toString();
	}
}
