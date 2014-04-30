
/**
 * Son objetos que van ha aparecer en las habitaciones
 * 
 * @author Laura 
 * @version 30/4/2014
 */
public class Objeto
{
    private String descriptionObjeto;
    private float pesoObjeto;

    /**
     * @param descriptionObjeto descripcion del objeto
     * @param pesoObjeto peso del objeto en kg
     */
    public Objeto(String descriptionObjeto,float pesoObjeto)
    {
        this.descriptionObjeto = descriptionObjeto;
        this.pesoObjeto = pesoObjeto;
    }

    /**
     * @return la descripcion del objeto a encontrar
     */
    public String getDescripcionObjeto()
    {
        return descriptionObjeto;
    }
    /**
     * @return el peso del objeto a encontrar
     */
    public float pesoObjeto()
    {
        return pesoObjeto;
    }
    /**
     * @return en Cadena de caracteres la informacion del objeto
     */
    public String printInfo()
    {
        String caracteristicas = getDescripcionObjeto()+"\nSu peso es: "+pesoObjeto()+" kg";
        return caracteristicas;
    }
}
