import java.util.ArrayList;
import java.util.List;

public class ClinicaService {
    private final List<Paciente> pacientes = new ArrayList<>();

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println("\nPaciente adicionado com sucesso!");
    }

    public void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("\nNenhum paciente cadastrado.");
            return;
        }

        System.out.println("\n--- Lista de Pacientes Internados ---");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println("Paciente #" + (i + 1));
            System.out.println(pacientes.get(i));
        }
    }

    public Paciente buscarPacientePorIndice(int indice) {
        if (indice < 0 || indice >= pacientes.size()) {
            return null;
        }
        return pacientes.get(indice);
    }

    public boolean removerPaciente(int indice) {
        if (indice < 0 || indice >= pacientes.size()) return false;
        pacientes.remove(indice);
        return true;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
}
