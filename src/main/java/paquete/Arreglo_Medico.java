package paquete;

import java.util.*;

public class Arreglo_Medico {

    private List<Medico> lista = new ArrayList();

    public void Adi_Medico(Medico m) {

        lista.add(m);
    }

    public Paciente busca(int cod) {

        for (Medico x : lista) {

            Paciente p = x.buscaPaciente(cod);

            if (p != null) {

                return p;
            }
        }

        return null;
    }

    public Medico buscaMedico(String med) {

        for (Medico x : lista) {

            if (x.getNom_medico().equals(med)) {

                return x;
            }
        }

        return null;
    }

    // Listar nombre de medicos por especialidad
    public Medico listaMedicos(int espec) {

        for (Medico x : lista) {

            if (x.getTipo_espec() == espec) {

                return x;

            }
        }

        return null;
    }

    public List<Medico> getLista() {
        return lista;
    }

    public void setLista(List<Medico> lista) {
        this.lista = lista;
    }

}
