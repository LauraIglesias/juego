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
    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
    private Room southeastExit;

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
     * @param southeast The southeast exit.
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
     * que tome como parámetro una cadena que represente una dirección 
     * @return el objeto de la clase Room asociado a esa salida o null si no hay salida.
     */
    public Room getExit(String direction){
        Room nextRoom = null;
        if(direction.equals("north")) {
            nextRoom = northExit;
        }
        if(direction.equals("east")) {
            nextRoom = eastExit;
        }
        if(direction.equals("south")) {
            nextRoom = southExit;
        }
        if(direction.equals("west")) {
            nextRoom = westExit;
        }
        if(direction.equals("southeast")) {
            nextRoom = southeastExit;
        }
        return nextRoom;
    }
  
 
    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

}
