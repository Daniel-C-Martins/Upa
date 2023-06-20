public class Medicamento {
  private String nomeRemedio;
  private int quantidadeRemedio;

  public Medicamento(String nomeRemedio, int quantidadeRemedio) {
    this.nomeRemedio = nomeRemedio;
    this.quantidadeRemedio = quantidadeRemedio;
  }

  public String getNomeRemedio() {
    return nomeRemedio;
  }

  public int getQuantidadeRemedio() {
    return quantidadeRemedio;
  }

  public void setNomeRemedio(String nomeRemedio) {
    this.nomeRemedio = nomeRemedio;
  }

  public void setQuantidadeRemedio(int quantidadeRemedio) {
    this.quantidadeRemedio = quantidadeRemedio;
  }

  public String toString() {
    return getNomeRemedio();
  }
}
