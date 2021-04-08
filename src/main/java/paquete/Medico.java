package paquete;

import java.util.*;
import javax.swing.JTextArea;

public class Medico {

    private int cod_medico; // Se autogenera desde 100
    private String nom_medico;
    private int tipo_espec; // 1=Medicina General, 2=Otorrino, 3=Gastro
    private int cant_dis; // Cantidad disponible que se va actualizar cada vez que se registrar un Medico con el Paciente
    private List<Paciente> lista;
    private double pago_total;

    static int cuenta = 100;

    public Medico(String nom_medico, int tipo_espec, int cant_dis) {
        this.cod_medico = cuenta++;
        this.nom_medico = nom_medico;
        this.tipo_espec = tipo_espec;
        this.cant_dis = cant_dis;
        this.lista = new ArrayList();
    }

    // Adicionar Pacientes
    public void Adi_Paciente(Paciente p) {

        lista.add(p);
    }

    // Tipo especialidad
    public String tipoEspecialidad() {

        String v[] = {"", "Medicina General", "Otorrino", "Gastro"};
        return v[tipo_espec];
    }

    // El costo por cada especialidad
    public int costoEspecialidad() {

        int v[] = {0, 50, 70, 80};
        return v[tipo_espec];
    }

    // Mostrar en un textarea la info
    public void muestra(JTextArea at) {

        at.setText("Nombre Médico: " + nom_medico + "\tCosto: " + costoEspecialidad() + "\tDisponible: " + cant_dis);
        at.append("\n");
        at.append("\n# Cita\tNombre\tDescuento\tPago");

        double pg;

        for (Paciente p : lista) {

            pg = costoEspecialidad() - p.descuento() * costoEspecialidad();
            pago_total += pg;
            at.append("\n" + p.getNroCita() + "\t" + p.getNom_pac() + "\t" + p.descuento() * 100 + "%" + "\t" + pg);
        }

        at.append("\n==============================");
        at.append("\nPÁGO TOTAL: " + pago_total);
    }

    // Buscar paciente
    public Paciente buscaPaciente(int cod) {

        for (Paciente x : lista) {

            if (x.getNroCita() == cod) {

                return x;
            }
        }

        return null;
    }

    public int getCod_medico() {
        return cod_medico;
    }

    public void setCod_medico(int cod_medico) {
        this.cod_medico = cod_medico;
    }

    public String getNom_medico() {
        return nom_medico;
    }

    public void setNom_medico(String nom_medico) {
        this.nom_medico = nom_medico;
    }

    public int getTipo_espec() {
        return tipo_espec;
    }

    public void setTipo_espec(int tipo_espec) {
        this.tipo_espec = tipo_espec;
    }

    public int getCant_dis() {
        return cant_dis;
    }

    public void setCant_dis(int cant_dis) {
        this.cant_dis = cant_dis;
    }

    public List<Paciente> getLista() {
        return lista;
    }

    public void setLista(List<Paciente> lista) {
        this.lista = lista;
    }

    public double getPago_total() {
        return pago_total;
    }

    public void setPago_total(double pago_total) {
        this.pago_total = pago_total;
    }

}
