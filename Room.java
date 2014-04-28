import java.util.HashMap;
import java.util.Iterator;
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

    HashMap<String,Room> direcciones = new HashMap<>();

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
     * Carga la salida que tiene esa direccion
     * @param direccion la direccion(norte, sur,este,oeste, sureste, noreste)
     * @param salida la habitacion a la que puede ir en esa direccion
     */
    public void setExit(String direccion, Room salida)
    {
        direcciones.put(direccion, salida);
    }

    /**
     * que tome como parámetro una cadena que represente una dirección 
     * @return el objeto de la clase Room asociado a esa salida o null si no hay salida.
     */
    public Room getExit(String direction){
        Room nextRoom = null;

        nextRoom = direcciones.get(direction);
        return nextRoom;
    }

    /**
     * Return a description of the room's exits.
     * For example: "Exits: north east west"
     * Devuelve una descripción de las salidas de la sala.
     * Por ejemplo: "Salidas: norte este oeste"
     *
     * @ return A description of the available exits.
     */
    public String getExitString()
    {
        String direccion = " ";
        if(getExit("north") != null) {
            direccion = "north ";
        }
        if(getExit("east")!= null) {
            direccion += "east ";
        }
        if(getExit("south") != null) {
            direccion += "south ";
        }
        if(getExit("west") != null) {
            direccion += "west ";
        }
        if(getExit("southeast") != null) {
            direccion += "southeast ";
        }
        if(getExit("northeast") != null) {
            direccion += "northeast ";
        }
        return direccion;
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

}
