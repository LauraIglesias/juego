import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
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

    HashMap<String,Room> direcciones;

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
        direcciones = new HashMap<>();
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

        return direcciones.get(direction);
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
        //keySet() ->Devuelve una vista de las claves que figuran en este mapa.El conjunto está respaldado por el mapa,
        //por lo que los cambios en el mapa se reflejan en el conjunto, y viceversa

        String direccionSalidas = "Exits:";
        Set<String> claves = direcciones.keySet();//copiamos en el set las claves que figuran en el mapa
        for(String salida : claves) {//recorremos el conjunto de claves
            direccionSalidas += " " + salida;
        }
        return direccionSalidas;
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return "Tu estas " + description;
    }

    /**
     * Return a long description of this room, of the form:
     *     You are in the 'name of room'
     *     Exits: north west southwest
     * Devolver una descripción larga de esta habitación, de forma que: 
     *     Usted está en el "nombre del salón ' 
     *     Salidas: norte este noroeste 
     * 
     * @return A description of the room, including exits.
     * @ Return Una descripción de la habitación, incluyendo salidas.
     */
    public String getLongDescription()
    {
        return getDescription() +"\n"+ getExitString();
    }

}
