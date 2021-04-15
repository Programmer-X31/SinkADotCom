import java.util.*;

public class DotComBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	private void setUpGame() {
		DotCom one = new DotCom();
		DotCom two = new DotCom();
		DotCom three = new DotCom();
		
		one.setName("Pets.com");
		two.setName("Toys.com");
		three.setName("eDonuts.com");
		
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		System.out.println("You goal is to sink all three Dot Coms");
		System.out.println("Pets.com, Toys.com, eDonuts.com");
		System.out.println("You goal is to guess the locations of the dotComs in few guesses as possible");
		
		for(DotCom dotComToSet: dotComsList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}
	
	private void startPlaying() {
		while(!dotComsList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "miss";
		
		for (DotCom dotComToTest: dotComsList) {
			result = dotComToTest.checkYourself(userGuess);
			if(result.equals("hit")) {
				break;
			}
			
			if(result.equals("kill")) {
				dotComsList.remove(dotComToTest);
				break;
			}
		}
		System.out.println(result);
	}
	
	private void finishGame() {
		System.out.println("All Dot Coms are dead!  Your stock is now worthless");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses");
            System.out.println("You got out before your options sank.");
        }
        else
        {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("These DotComs laughed at your guesses");
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}

}
