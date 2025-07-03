import java.util.ArrayList;
import java.util.Scanner;

public class SistemaClinica {
    private static ArrayList<Paciente> pacientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n--- Sistema de Gerenciamento de Pacientes ---");
            System.out.println("1. Adicionar paciente");
            System.out.println("2. Listar pacientes");
            System.out.println("3. Atualizar paciente");
            System.out.println("4. Remover paciente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> adicionarPaciente();
                case 2 -> listarPacientes();
                case 3 -> atualizarPaciente();
                case 4 -> removerPaciente();
                case 5 -> System.out.println("\nEncerrando o sistema...");
                default -> System.out.println("\nOpção inválida!");
            }
        } while (opcao != 5);
    }

    private static void adicionarPaciente() {
        System.out.print("\nNome: ");
        String nome = scanner.nextLine();
        System.out.print("Data de nascimento (DD/MM/AAAA): ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Diagnóstico: ");
        String diagnostico = scanner.nextLine();

        pacientes.add(new Paciente(nome, dataNascimento, telefone, diagnostico));
        System.out.println("\nPaciente adicionado com sucesso!");
    }

    private static void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("\nNenhum paciente cadastrado.");
            return;
        }

        System.out.println("\n--- Lista de Pacientes Internados ---");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println("\nPaciente #" + (i + 1));
            System.out.println(pacientes.get(i));
        }
    }

    private static void atualizarPaciente() {
        listarPacientes();
        if (pacientes.isEmpty()) return;

        System.out.print("\nDigite o número do paciente que deseja atualizar: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= pacientes.size()) {
            System.out.println("\nPaciente não encontrado.");
            return;
        }

        Paciente paciente = pacientes.get(index);

        System.out.print("\nNovo nome (pressione Enter para manter: " + paciente.getNome() + "): ");
        String novoNome = scanner.nextLine();
        if (!novoNome.isEmpty()) paciente.setNome(novoNome);

        System.out.print("Nova data de nascimento (Enter para manter: " + paciente.getDataNascimento() + "): ");
        String novaData = scanner.nextLine();
        if (!novaData.isEmpty()) paciente.setDataNascimento(novaData);

        System.out.print("Novo telefone (Enter para manter: " + paciente.getTelefone() + "): ");
        String novoTelefone = scanner.nextLine();
        if (!novoTelefone.isEmpty()) paciente.setTelefone(novoTelefone);

        System.out.print("Novo diagnóstico (Enter para manter: " + paciente.getDiagnostico() + "): ");
        String novoDiagnostico = scanner.nextLine();
        if (!novoDiagnostico.isEmpty()) paciente.setDiagnostico(novoDiagnostico);

        System.out.println("\nPaciente atualizado com sucesso!");
    }

    private static void removerPaciente() {
        listarPacientes();
        if (pacientes.isEmpty()) return;

        System.out.print("\nDigite o número do paciente que deseja remover: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= pacientes.size()) {
            System.out.println("\nPaciente não encontrado.");
            return;
        }

        pacientes.remove(index);
        System.out.println("\nPaciente removido com sucesso!");
    }
}