package commands;

public class CommandGenerator {
		public static final String unknownCommandMsg ="Unknown command";
		
		private static Command[] availableCommands = {
				
		};
		
		public static Command parse(String[] commandWords) throws Exception  {
			for (Command c: availableCommands) {
				Command parsedC = c.parse(commandWords);
				if(parsedC != null) 
					return parsedC;
			}
			throw new Exception("[ERROR]: " + unknownCommandMsg);
		}
		
		public static String commandHelp() {
			String help = "Available commands: " + "\n";
			for (Command c: availableCommands) {
				help = help + c.helpText();
			}
			return help;
		}
}
