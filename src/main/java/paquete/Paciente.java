package paquete;

public class Paciente {

    private int nroCita; // Se autogenera desde 1
    private String nom_pac;
    private int tipo_pac;// 1=Asegurado, 2=Particular
    private Medico med;

    static int cuenta = 1;

    public Paciente(String nom_pac, int tipo_pac, Medico med) {
        this.nroCita = cuenta++;
        this.nom_pac = nom_pac;
        this.tipo_pac = tipo_pac;
        this.med = med;
        med.Adi_Paciente(this);
        med.setCant_dis(med.getCant_dis() - 1);
    }

    // Tipo de descuento seleccionado en un combo
    public double descuento() {

        double v[] = {0, 0.5, 0};
        return v[tipo_pac];
    }

    // El pago que realizara cada paciente
    public double pago() {

        return med.costoEspecialidad() - med.costoEspecialidad() * descuento();
    }

    public int getNroCita() {
        return nroCita;
    }

    public void setNroCita(int nroCita) {
        this.nroCita = nroCita;
    }

    public String getNom_pac() {
        return nom_pac;
    }

    public void setNom_pac(String nom_pac) {
        this.nom_pac = nom_pac;
    }

    public int getTipo_pac() {
        return tipo_pac;
    }

    public void setTipo_pac(int tipo_pac) {
        this.tipo_pac = tipo_pac;
    }

    public Medico getMed() {
        return med;
    }

    public void setMed(Medico med) {
        this.med = med;
    }

}
