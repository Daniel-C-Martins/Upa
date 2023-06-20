public class Paciente {
  private String nome;
  private String cpf;
  private String telefone;
  private int diagnostico;
  private String medicamentoIndicado;
  private int quantidadeCaixas;

  public Paciente(String nome, String cpf, String telefone, int diagnostico, String medicamentoIndicado,
      int quantidadeCaixas) {

    this.nome = nome;
    this.cpf = cpf;
    this.telefone = telefone;
    this.diagnostico = diagnostico;
    this.medicamentoIndicado = medicamentoIndicado;
    this.quantidadeCaixas = quantidadeCaixas;
  }

  // getters

  public String getCpf() {
    return cpf;
  }

  public String getDiagnostico() {
    String retornoDiagnostico = "";
    if (diagnostico == 1) {
      retornoDiagnostico = "Covid";
    }
    if (diagnostico == 2) {
      retornoDiagnostico = "Zika";
    }
    if (diagnostico == 3) {
      retornoDiagnostico = "Chikungunya";
    }
    if (diagnostico == 4) {
      retornoDiagnostico = "Dengue";
    }
    return retornoDiagnostico;
  }

  // Getters

  public String getMedicamentoIndicado() {
    return medicamentoIndicado;
  }

  public String getNome() {
    return nome;
  }

  public int getQuantidadeCaixas() {
    return quantidadeCaixas;
  }

  public String getTelefone() {
    return telefone;
  }

  // setters

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setDiagnostico(int diagnostico) {
    this.diagnostico = diagnostico;
  }

  public void setMedicamentoIndicado(String medicamentoIndicado) {
    this.medicamentoIndicado = medicamentoIndicado;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setQuantidadeCaixas(int quantidadeCaixas) {
    this.quantidadeCaixas = quantidadeCaixas;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  // métodos

  public String toString() {
    return "Nome:" + getNome() + "\nCPF:" + getCpf() + "\nTelefone:" + getTelefone() + "\nDiagnóstico:"
        + getDiagnostico() + "\nMedicamento Indicado:" + getMedicamentoIndicado()
        + "\nQuantidade de caixas:" + getQuantidadeCaixas();

  }
}