import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class SistemaClinica {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ClinicaService servico = new ClinicaService();
    private static final DateTimeFormatter FORMATADOR_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final String MENU = """
        \n--- Sistema de Gerenciamento de Pacientes ---
        1. Adicionar paciente
        2. Listar pacientes
        3. Atualizar paciente
        4. Remover paciente
        5. Sair
        Escolha uma opção: """;

    public static void main(String[] args) {
        int opcao = 0;

        do {
            System.out.print(MENU);
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1 -> adicionarPaciente();
                case 2 -> servico.listarPacientes();
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

        LocalDate dataNascimento = null;
        while (dataNascimento == null) {
            System.out.print("Data de nascimento (DD/MM/AAAA): ");
            String entrada = scanner.nextLine();
            try {
                dataNascimento = LocalDate.parse(entrada, FORMATADOR_DATA);
            } catch (DateTimeParseException e) {
                System.out.println("\nData inválida. Tente novamente.");
            }
        }

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Diagnóstico: ");
        String diagnostico = scanner.nextLine();

        Paciente paciente = new Paciente(nome, dataNascimento, telefone, diagnostico);
        servico.adicionarPaciente(paciente);
    }

    private static void atualizarPaciente() {
        if (servico.getPacientes().isEmpty()) {
            System.out.println("\nNenhum paciente cadastrado para atualizar.");
            return;
        }

        servico.listarPacientes();
        System.out.print("Digite o número do paciente a ser atualizado: ");
        int indice;
        try {
            indice = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("\nEntrada inválida.");
            return;
        }

        Paciente paciente = servico.buscarPacientePorIndice(indice);
        if (paciente == null) {
            System.out.println("\nPaciente não encontrado.");
            return;
        }

        System.out.print("\nNovo nome (Enter para manter: " + paciente.getNome() + "): ");
        String nome = scanner.nextLine();
        if (!nome.isBlank()) paciente.setNome(nome);

        System.out.print("Nova data de nascimento (Enter para manter: " + paciente.getDataNascimento().format(FORMATADOR_DATA) + "): ");
        String data = scanner.nextLine();
        if (!data.isBlank()) {
            try {
                LocalDate novaData = LocalDate.parse(data, FORMATADOR_DATA);
                paciente.setDataNascimento(novaData);
            } catch (DateTimeParseException e) {
                System.out.println("\nData inválida. Mantendo a anterior.");
            }
        }

        System.out.print("Novo telefone (Enter para manter: " + paciente.getTelefone() + "): ");
        String telefone = scanner.nextLine();
        if (!telefone.isBlank()) paciente.setTelefone(telefone);

        System.out.print("Novo diagnóstico (Enter para manter: " + paciente.getDiagnostico() + "): ");
        String diagnostico = scanner.nextLine();
        if (!diagnostico.isBlank()) paciente.setDiagnostico(diagnostico);

        System.out.println("\nPaciente atualizado com sucesso!");
    }

    private static void removerPaciente() {
        if (servico.getPacientes().isEmpty()) {
            System.out.println("Nenhum paciente cadastrado para remover.");
            return;
        }

        servico.listarPacientes();
        System.out.print("\nDigite o número do paciente a ser removido: ");
        int indice;
        try {
            indice = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("\nEntrada inválida.");
            return;
        }

        if (servico.removerPaciente(indice)) {
            System.out.println("\nPaciente removido com sucesso!");
        } else {
            System.out.println("\nÍndice inválido. Nenhum paciente foi removido.");
        }
    }
}
