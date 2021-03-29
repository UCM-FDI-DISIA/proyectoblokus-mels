package commands;

public abstract class Command {
	 protected final String name;
	  protected final String shortcut;
	  private final String details; 
	  private final String help;

	  protected static final String incorrectNumberOfArgsMsg = "Incorrect number of arguments";
	  protected static final String incorrectArgsMsg = "Incorrect arguments format";
	  
	  
	  public Command(String name, String shortcut, String details, String help){    
	    this.name = name;
	    this.shortcut = shortcut;
	    this.details = details;
	    this.help = help;
	  }
	
	  //   Meter un game 
	  public abstract boolean execute() throws Exception;
	  
	  public abstract Command parse(String[] commandWords) throws Exception;
	  
	  protected boolean matchCommandName(String name) {
		    return this.shortcut.equalsIgnoreCase(name) || 
		        this.name.equalsIgnoreCase(name);
	  }
	  // reads only first letter
	  protected Command parseNoParamsCommand(String[] words)
			  throws Exception {
			  if (matchCommandName(words[0])) {
				  if (words.length != 1)
					  	throw new Exception("[ERROR]: Command "+
					  			name+" :"+incorrectNumberOfArgsMsg);
				  else 
					  return this;
			  }
			  return null;
     }
	  public String helpText(){
	    return details + ": " + help + "\n";
	  }
}
