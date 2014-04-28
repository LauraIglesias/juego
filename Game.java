/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     * Crea todas las habitaciones y vincular sus salidas juntos.
     */
    private void createRooms()
    {
        Room hold, biblioteca, mazmorra, torre, comedor, cocina;

        // create the rooms
        hold = new Room("en el hold, acabas de entrar en el castillo");
        biblioteca = new Room("en la biblioteca");
        mazmorra = new Room("en la mazmorra del castillo");
        torre = new Room("en la torre mas alta del castillo");
        comedor = new Room("en la sala del comedor con una mesa gigante y sillas");
        cocina = new Room("en la cocina");

        // initialise room exits
        hold.setExit("east", biblioteca);
        hold.setExit("west", comedor);
        
        biblioteca.setExit("north", mazmorra);
        biblioteca.setExit("east", torre);
        biblioteca.setExit("west", hold);
        
        mazmorra.setExit("west", cocina);
        
        torre.setExit("northeast", mazmorra);
        torre.setExit("west", biblioteca);
        
        comedor.setExit("north", cocina);
        comedor.setExit("east", hold);
        
        cocina.setExit("south", comedor);
        cocina.setExit("southeast", hold);
        
        currentRoom = hold;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     *  Rutina de reproducción principal. Los bucles hasta el final del juego.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        //Entrar en el bucle de control principal. Aquí leemos repetidamente órdenes y
        // las ejecutamos hasta que el juego ha terminado.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     * Imprima el mensaje inicial para el jugador.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * Dado un comando, el proceso (es decir: lo ejecuta) el comando.
     * @param command The command to be processed. El comando para su procesamiento.
     * @return true If the command ends the game, false otherwise. True si el comando termina el juego, false en caso contrario.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");//No sé lo que quieres decir ...
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     * Imprime información de ayuda.
     * Aquí imprimimos algunos, enigmático mensaje estúpido y una lista de las palabras de comando.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");//Usted está perdido. Usted está solo. Usted deambula
        System.out.println("around at the university.");//en torno a la universidad
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     * Trate de ir en una dirección. 
     * Si hay una salida, introduzca la nueva sala, de lo contrario mostrará un mensaje de error.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            //si no hay una segunda palabra, no sabemos a dónde ir ...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            printLocationInfo();

        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * "Quit" haber si ha introducido. 
     * Compruebe el resto de la orden para ver si realmente desea salir del juego.
     * @return true, if this command quits the game, false otherwise.
     *         true si este comando se cierra el juego, false en caso contrario.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit.  Señal de que queremos salir
        }
    }

    /**
     * Imprime por pantalla la localizacion a la que puede ir el jugador desde la sala en la que se encuentra
     */
    private void printLocationInfo()
    {
        System.out.println("Tu estas " + currentRoom.getDescription());
        System.out.print("Exits: ");

        System.out.println(currentRoom.getExitString());

        System.out.println();
    }
}
