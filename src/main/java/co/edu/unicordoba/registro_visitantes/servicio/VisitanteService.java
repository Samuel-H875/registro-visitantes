package co.edu.unicordoba.registro_visitantes.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unicordoba.registro_visitantes.modelo.Visitante;

@Service // Spring crea UNA sola instancia (bean)
public class VisitanteService {
    // De INSTANCIA; bean único: lista compartida
    private final List<Visitante> reg = new ArrayList<>();

    public Visitante registrar(String n, int e) {
        Visitante v = new Visitante(n, e);
        reg.add(v);
        return v;
    }

    public List<Visitante> listar() {
        return List.copyOf(reg); // copia inmutable
    }

    public int contarRegistrados() {
        return reg.size(); // instancia
    }

    public int contarCreadosEnLaClase() {
        return Visitante.getTotalCreados(); // static
    }
}