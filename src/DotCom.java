import java.util.*;

public class DotCom {
	private ArrayList<String> locationCells;
	private String name;
	
	public void setLocationCells(ArrayList<String> locs) {
		this.locationCells = locs;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public String checkYourself(String userInput) {
		String result = "miss";
		int index = locationCells.indexOf(userInput);
		if (index >= 0) {
			locationCells.remove(index);
			if(locationCells.isEmpty()) {
				result = "kill";
			} else {
				result = "hit";
			} // close if
		} //close outer if
		return result;
	} // close method
}
