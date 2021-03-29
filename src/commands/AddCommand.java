package commands;

public class AddCommand extends Command{
	
	private static int numArgsCommandAddSlayer = 4;
	private int row;
	private int col;
	private static final String name = "add";
	private static final String shortcut = "a";
	private static final String details = "[a]dd <piece> <x> <y>";
	private static final String help = "add piece in position x, y";
	private static final String failedMsg = "[ERROR]: Failed to add piece";

	public AddCommand() {
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute() throws Exception {
		try {
			//game.addSlayerCommand(row, col);
			return true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new Exception(failedMsg);
		}
	}

	@Override
	public Command parse(String[] commandWords) throws Exception {
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length == numArgsCommandAddSlayer) {
				try {
					col = Integer.parseInt(commandWords[1]);
					row = Integer.parseInt(commandWords[2]);
					return this;
				}
				catch (NumberFormatException ex) {
					throw new Exception("[ERROR]: "  + " for " + name + " slayer command, number expected: " + details);
				}
			}
			else
				throw new Exception("[ERROR]: " +  incorrectNumberOfArgsMsg + " for " + name + " slayer command, number expected: " + details);
		}

		else
			throw new Exception("[ERROR]: " +  incorrectNumberOfArgsMsg + " for " + name + " command: " + details);
	}
}
