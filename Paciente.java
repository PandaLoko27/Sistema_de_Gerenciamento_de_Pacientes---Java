import java.time.LocalDate;

public class Paciente {
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private String diagnostico;

    public Paciente(String nome, LocalDate dataNascimento, String telefone, String diagnostico) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.diagnostico = diagnostico;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    @Override
    public String toString() {
        return "Nome: " + nome +
               "\nData de Nascimento: " + dataNascimento +
               "\nTelefone: " + telefone +
               "\nDiagnóstico: " + diagnostico + "\n";
    }
}
