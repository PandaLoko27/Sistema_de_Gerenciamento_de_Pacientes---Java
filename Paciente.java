public class Paciente {
    private String nome;
    private String dataNascimento;
    private String telefone;
    private String diagnostico;

    public Paciente(String nome, String dataNascimento, String telefone, String diagnostico) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.diagnostico = diagnostico;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

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