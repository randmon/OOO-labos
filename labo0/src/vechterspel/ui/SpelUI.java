package vechterspel.ui;

import vechterspel.domain.*;

public class SpelUI {
	public static void main(String[] args) {
		Spel spel = new Spel();
		//voeg actoren toe aan spel
		try {
			spel.voegActortoe(new Elf("elfje"));
			spel.voegActortoe(new Elf("twaalfje"));
			spel.voegActortoe(new Rover("elfje", 200));
			spel.voegActortoe(new Rover("Maurice", 300));
			spel.voegActortoe(new Rover("Lowie", 4000));
			spel.voegActortoe(new Rover("Twan", 500));
			spel.voegActortoe(new Rover("Jakke", 200, 2000));
			spel.voegActortoe(new Vampier("Toon", 300));
			spel.voegActortoe(new Vampier("Uno", 300, 1500));
			spel.voegActortoe(new Vampier("Dos", 50));
		} catch (DomainException e) {System.out.println(e.getMessage());}
		System.out.println("Actoren in spel\n"+spel);
		
		//speel spel
		for (int i = 1; i <= 10; i++) {
			// get random vechter
			Vechter aanvaller = spel.getRandomVechter();
			if (aanvaller == null) break;

			// get random tegenstander
			Actor tegenstander = spel.getRandomActor(aanvaller);
			if (tegenstander == null) break;

			// aanvaller valt tegenstander aan
			try{
				System.out.println("-----------------------------------------------------");
				System.out.println("🎲 Round " + i);
				System.out.println(aanvaller + " \nvs\n" + tegenstander);
				spel.valAan(aanvaller,tegenstander);
			} catch (DomainException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("-----------------------------------------------------");
		System.out.println("Actoren in spel\n" + spel);
		System.out.println("Aantal levende vechters na aanvallen: " + spel.getLevendeVechters().size());
		spel.reincarneerDodeActoren();
		System.out.println("Aantal levende vechters na reincarnatie: " + spel.getLevendeVechters().size());
	}
}
