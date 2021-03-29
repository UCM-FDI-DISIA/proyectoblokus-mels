package commands;

import control.Main;

public class SkipCommand extends Command{
	
	private static final String name = "skip";
	private static final String shortcut = "s";
	private static final String details = "[s]kip | []";
	private static final String help = "skip turn";

	public SkipCommand() {
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute() throws Exception {
		Main.cuentaSkip();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws Exception {
		// TODO Auto-generated method stub
		if (matchCommandName(commandWords[0]) || commandWords[0].isEmpty()) {
			if(commandWords.length != 1)
				throw new Exception("ERROR");
			else
				return this;
		}
		else
			return null;
	}

}
