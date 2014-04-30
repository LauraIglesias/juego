import java.util.Scanner;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.

 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 * 
 * Este analizador lee la entrada del usuario y trata de interpretarlo como un comando "Adventure". 
 * Cada vez que se llama se lee una l�nea desde la terminal y trata de interpretar la l�nea
 * como un comando de dos palabras. Devuelve el comando como un objeto de comando de clase.
 * El analizador tiene un conjunto de palabras de comandos conocidos. 
 * Se comprueba la entrada del usuario en contra de los comandos conocidos, 
 * y si la entrada no es uno de los comandos conocidos, devuelve un objeto de comando que est� marcado 
 * como un comando desconocido.
 */
public class Parser 
{
    private CommandWords commands;  // holds all valid command words. Posee que todas las palabras de comando v�lidas
    private Scanner reader;         // source of command input . fuente de entrada de comando

    /**
     * Create a parser to read from the terminal window.
     * Crear un analizador de leer desde la ventana de terminal.
     */
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * @return The next command from the user. El siguiente comando del usuario.
     */
    public Command getCommand() 
    {
        String inputLine;   // will hold the full input line. contendr� la l�nea de entrada completa
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();

        // Find up to two words on the line. Encuentra un m�ximo de dos palabras en la l�nea.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
                // note: we just ignore the rest of the input line.
            }
        }

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2); 
        }
    }
    /**
     *  implementar un m�todo en la clase Parser 
     *  que commands es de tipo CommandWords e invocar dicho m�todo desde la clase Game 
     *  @return nos devuelva el atributo commands de dicha clase
     */
    public CommandWords palabrasDeComamdo()
    {
        return commands;
    }
    /**
     * implementar un m�todo en la clase Parser 
     * que consiga imprimir por pantalla todos los comandos disponibles e invocarlo desde la clase Game.
     */
    public void printComandosDisponibles()
    {
        commands.showAll();
    }
}
