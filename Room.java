/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 * 
 * Sala de clase - una habitación en un juego de aventuras.
 *
 * Esta clase es parte de la aplicación "World of Zuul".
"World of Zuul" es un texto basado en juego de aventura muy simple.
 *
 * Un "Habitación" representa un lugar en el escenario del juego. 
 * Se conecta a otras habitaciones a través de las salidas. 
 * Las salidas están marcadas norte, este, sur, oeste. Para cada dirección, 
 * la habitación almacena una referencia a la habitación vecina, o NULL si no 
 * hay salida en esa dirección.
 * 
 */
public class Room 
{
    public String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;
    public Room southeastExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * Crear un ambiente descrito "description". Inicialmente, no tiene salidas. 
     * "description" es algo así como "cocina" o "un patio abierto."
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * Defina las salidas de esta habitación. Cada dirección o bien lleva a otra habitación o es nulo (sin salida de allí).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west, Room southeast) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
        if(southeast != null)
            southeastExit = southeast;
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

}
