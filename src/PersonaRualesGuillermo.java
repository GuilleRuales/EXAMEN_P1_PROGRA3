public class PersonaRualesGuillermo implements Comparable<PersonaRualesGuillermo>{

    private String cedula;
    private String nombre;
    private int edad;
    private String genero;
    private String region;

    public PersonaRualesGuillermo() {
        this.cedula = "1724009806";
        this.nombre = "Guillermo";
        this.edad = 20;
        this.genero = "Masculino";
        this.region = "Sierra";
    }

    public PersonaRualesGuillermo(String cedula, String nombre, int edad, String genero, String region) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.region = region;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return  "Cedula: "+cedula+
                "\nNombre: "+nombre+
                "\nEdad: "+edad+
                "\nGenero: "+genero+
                "\nregion: "+region;
    }

    @Override
    public int compareTo(PersonaRualesGuillermo p){
        if(edad < p.getEdad())
            return -1;
        else if(edad > p.getEdad())
            return 1;
        else
            return 0;
    }

}
