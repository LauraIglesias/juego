/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two strings: a command word and a second
 * word (for example, if the command was "take map", then the two strings
 * obviously are "take" and "map").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is <null>.
 *
 * If the command had only one word, then the second word is <null>.
 * 
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 * 
 * Esta clase contiene información acerca de un comando que fue emitida por el usuario.
 * Un comando se compone actualmente de dos cadenas:
 * una palabra de comando y una segunda palabra (por ejemplo, si el comando se "tomar mapa", 
 * a continuación, las dos cadenas, obviamente, se "tomar" y "mapa").
 * 
 * La forma en que se utiliza es la siguiente: Los comandos ya se comprueban por ser 
 * palabras de comando válidos. Si el usuario introduce un comando no válido 
 * (una palabra que no se conoce), entonces la palabra de orden es <NULL>.
 *
 * Si el comando tenía una sola palabra, y luego la segunda palabra se <NULL>.
 */

public class Command
{
    private String commandWord;
    private String secondWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     * @param firstWord The first word of the command. Null if the command
     *                  was not recognised.
     * @param secondWord The second word of the command.
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     * Devuelva la palabra de comando (la primera palabra) de este comando. 
     * Si el comando no se entiende, el resultado es nulo.
     * @return The command word.
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * @return The second word of this command. Returns null if there was no
     * second word.
     * La segunda palabra de este comando. Devuelve NULL si no hay segunda palabra.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * @return true if this command was not understood.
     * true si este comando no se entendió.
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * @return true if the command has a second word.
     * true si el comando tiene una segunda palabra.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

