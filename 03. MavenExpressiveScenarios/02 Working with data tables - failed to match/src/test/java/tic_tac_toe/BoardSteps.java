package tic_tac_toe;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import cucumber.api.DataTable;

import java.util.List;

public class BoardSteps {
	private List<List<String>> board;
	
	@Given("^a board like this:$")
		public void aBoardLikeThis(DataTable table) throws Throwable {
		this.board = table.raw();	
}

	@When("^player x plays in row (\\d+), column (\\d+)$")
		public void playerXPlaysInRowColumn(int arg1, int arg2) throws Throwable {

}

	@Then("^the board should look like this:$")
		public void theBoardShouldLookLikeThis(DataTable expectedTable) throws Throwable {
		expectedTable.diff(board);	
		throw new PendingException();
}
	
}