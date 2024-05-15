import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Cola {

    private PriorityQueue<PersonaRualesGuillermo> personaRualesGuillermo;

    public Cola(){
        personaRualesGuillermo = new PriorityQueue<PersonaRualesGuillermo>();
    }

    public void encolar(String cedula, String nombre, int edad, String genero, String region) throws Exception {
        if(buscarPersona(cedula) == null)
            personaRualesGuillermo.add(new PersonaRualesGuillermo(cedula, nombre, edad, genero, region));
        else
            throw new Exception("La cedula ya esta registrada");
    }

    public List<PersonaRualesGuillermo> listarPersonas(){
        List<PersonaRualesGuillermo> lista = new LinkedList<>();
        for (PersonaRualesGuillermo p: personaRualesGuillermo)
            lista.add(p);
        return lista;
    }

    public PersonaRualesGuillermo buscarPersona(String cedula){
        for (PersonaRualesGuillermo p: personaRualesGuillermo)
            if (p.getCedula().equals(cedula))
                return p;
        return null;
    }

    public List<PersonaRualesGuillermo> listaEdadSexo(int edad, String sexo) throws Exception {
        if (personaRualesGuillermo.isEmpty())
            throw new Exception("No hay personas registadas");
        else {
            List<PersonaRualesGuillermo> lista = new LinkedList<>();
            for (PersonaRualesGuillermo p : personaRualesGuillermo)
                if (p.getEdad() == edad && p.getGenero().equals(sexo))
                    lista.add(p);
            return lista;
        }
    }

    public List<PersonaRualesGuillermo> listaEdadRegion(int edad, String region) throws Exception {
        if (personaRualesGuillermo.isEmpty())
            throw new Exception("No hay personas registadas");
        List<PersonaRualesGuillermo> lista = new LinkedList<>();
        for (PersonaRualesGuillermo p: personaRualesGuillermo){
            if (p.getEdad()==edad && p.getGenero().equals(region))
                lista.add(p);
        }
        return lista;
    }


}
