package tic_tac_toe;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import cucumber.api.DataTable;

import java.util.List;

/*This test will fail because the last method will check if the expected table on the third
	Gherkin step matches the board object.  Seeing as teh board object has not been updated 
	in step 2 it will not match.  Note, method 'diff' checks the difference between 2 objects
*/

public class BoardSteps {
	private List<List<String>> board;
	
	@Given("^a board like this:$")
		public void aBoardLikeThis(DataTable table) throws Throwable {
		this.board = table.raw();	
}

	@When("^player x plays in row (\\d+), column (\\d+)$")
		public void playerXPlaysInRowColumn(int arg1, int arg2) throws Throwable {
		System.out.println(board.toString());
		throw new PendingException();
}

	@Then("^the board should look like this:$")
		public void theBoardShouldLookLikeThis(DataTable expectedTable) throws Throwable {

		throw new PendingException();
}
	
}