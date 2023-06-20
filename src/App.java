import java.util.*;

public class App {

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        Medicamento[] medicamento = new Medicamento[4];
        medicamento[0] = new Medicamento("CovidUltra", 15);
        medicamento[1] = new Medicamento("Zicox", 20);
        medicamento[2] = new Medicamento("ChikTop", 15);
        medicamento[3] = new Medicamento("Denguenit", 15);

        Paciente[] paciente = new Paciente[10];

        CadastroPaciente cadastro = new CadastroPaciente(10);
        cadastro.setPacientes(paciente);

        int saida = 0;
        do {
            System.out.println("----------------------------------------------- ");
            System.out.println("|      Seja bem-vindo ao sistema da UPA       | ");
            System.out.println("| ------------------------------------------- | ");
            System.out.println("|        Escolha o que deseja fazer:          | ");
            System.out.println("|  1 - Adicionar novo paciente                | ");
            System.out.println("|  2 - Remover paciente                       | ");
            System.out.println("|  3 - Gerenciar a ficha dos pacientes        | ");
            System.out.println("|  4 - Gerenciar remédios                     | ");
            System.out.println("|  5 - Sair do programa                       | ");
            System.out.println("----------------------------------------------- ");
            int opcaoPrincipal = key.nextInt();
            key.nextLine();

            switch (opcaoPrincipal) {
                case 1: // Adicionar paciente
                    int travaNome = 1;
                    String nome = " ";
                    do {
                        System.out.println("Digite o nome do paciente que você deseja adicionar: ");
                        nome = key.nextLine();
                        travaNome = cadastro.verificaLetras(nome);
                        if (travaNome == 1) {
                            System.out.println("Nome inválido, tente novamente");
                        }
                    } while (travaNome == 1);

                    int travaCpf = 1;
                    String cpf = " ";
                    do {
                        System.out.println("Digite o cpf do paciente");
                        cpf = key.nextLine();
                        travaCpf = cadastro.verificaSeTemLetras(cpf);
                        if (travaCpf == 1) {
                            System.out.println("Cpf inválido, tente novamente");
                        } else if (cpf.length() != 11) {
                            System.out.println(
                                    "Cpf inválido, digite apenas os números do cpf do paciente, Ex: 11122233345");
                        }
                    } while (cpf.length() != 11 || travaCpf == 1);

                    int travaTelefone;
                    String tel = " ";
                    do {
                        System.out.println("Digite o celular do paciente");
                        tel = key.nextLine();
                        travaTelefone = cadastro.verificaSeTemLetras(tel);
                        if (tel.length() != 9) {
                            System.out.println("Número de celular inválido, tente novamente");
                        } else if (travaTelefone == 1) {
                            System.out.println("Número de celular invá1lido utilize o formato 911223344 ");
                        }
                    } while (tel.length() != 9 || travaTelefone == 1);

                    String diagnostico;
                    int diagnosticoCodigo = 0;
                    do {
                        System.out.println("Escolha o diagnóstico que o paciente recebeu: ");
                        System.out.println("1 - Covid ");
                        System.out.println("2 - Zica ");
                        System.out.println("3 - Chikungunya ");
                        System.out.println("4 - Dengue ");
                        diagnostico = key.nextLine();
                        diagnosticoCodigo = cadastro.tranforma(diagnostico);
                    } while (diagnosticoCodigo < 1 || diagnosticoCodigo > 4);

                    String remedio;
                    int remedioCodigo = 0;
                    do {
                        System.out.println("Escolha o remédio que foi receitado para o paciente: ");
                        System.out.println("1 - CovidUltra (" + medicamento[0].getQuantidadeRemedio() + " em estoque)");
                        System.out.println("2 - Zicox (" + medicamento[1].getQuantidadeRemedio() + " em estoque)");
                        System.out.println("3 - ChikTop (" + medicamento[2].getQuantidadeRemedio() + " em estoque)");
                        System.out.println("4 - Denguenit (" + medicamento[3].getQuantidadeRemedio() + " em estoque)");
                        remedio = key.nextLine();
                        remedioCodigo = cadastro.tranforma(remedio);
                    } while (remedioCodigo < 1 || remedioCodigo > 4);

                    int quant = 0;
                    do {
                        System.out.println("Digite a quantidade de remédio receitada para o paciente: ");
                        quant = key.nextInt();
                        if (quant > medicamento[remedioCodigo - 1].getQuantidadeRemedio()) {
                            System.out.println("Quantidade indisponivel no estoque!");
                        }
                    } while (quant > medicamento[remedioCodigo - 1].getQuantidadeRemedio());
                    cadastro.alterarRemedio(quant, medicamento, remedioCodigo, nome, cpf, tel, diagnosticoCodigo);
                    break;

                case 2: // removerPac paciente
                    String removerPac = " ";
                    do {
                        System.out.println("Digite o cpf do paciente que você deseja remover: ");
                        removerPac = key.nextLine();
                        if (removerPac.length() != 11) {
                            System.out.println(
                                    "Cpf inválido, digite apenas os números do cpf do paciente, Ex: 11122233345");
                        }
                    } while (removerPac.length() != 11);
                    cadastro.removerPaciente(paciente, removerPac);
                    cadastro.organizarVetor(paciente);
                    break;

                case 3: // Menu do sistema de pacientes
                    int menuFichas;
                    do {
                        System.out.println("----------------------------------------------------------- ");
                        System.out.println("|        Sistema de fichas dos pacientes da UPA           | ");
                        System.out.println("| ------------------------------------------------------- | ");
                        System.out.println("| 1 - Mostrar todos os pacientes que estão em atendimento | ");
                        System.out.println("| 2 - Mostrar pacientes e leitos disponiveis              | ");
                        System.out.println("| 3 - Mostrar porcentagem de ocorrência de cada doença:   | ");
                        System.out.println("| 4 - Ordenar todos os pacientes em ordem alfabética:     | "); // NC
                        System.out.println("----------------------------------------------------------- ");
                        menuFichas = key.nextInt();
                    } while (menuFichas >= 4 || menuFichas <= 0);
                    switch (menuFichas) {
                        case 1:
                            System.out.println("Aqui está a ficha com os pacientes internados:  ");
                            System.out.println(" ");
                            cadastro.imprimeOcupado();
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(" ");
                            break;
                        case 2:
                            System.out.println("Aqui está a ficha com os pacientes e os leitos ainda disponiveis: ");
                            System.out.println(" ");
                            cadastro.imprimeTodoVetor();
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(" ");
                            break;
                        case 3:
                            System.out.println("Aqui está o relatório da ocorrência das doenças no hospital: ");
                            System.out.println(" ");
                            cadastro.porcentDoenças();
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(" ");
                            break;
                    }
                    break;

                case 4: // Gerenciar remédios
                    int menuRemedio;
                    do {
                        System.out.println("------------------------------------------------ ");
                        System.out.println("|  Bem-vindo(a) ao estoque de remédios da UPA  | ");
                        System.out.println("| -------------------------------------------- | ");
                        System.out.println("|  1 - Verificar o estoque de remédios:        | ");
                        System.out.println("|  2 - Alterar o estoque:                      | ");
                        System.out.println("------------------------------------------------ ");
                        menuRemedio = key.nextInt();
                    } while (menuRemedio <= 0 || menuRemedio > 2);
                    switch (menuRemedio) {
                        case 1: // Mostrar todo o estoque
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(
                                    "O estoque de CovidUltra possui: " + medicamento[0].getQuantidadeRemedio()
                                            + "caixas");
                            System.out.println(
                                    "O estoque de Zicox possui: " + medicamento[1].getQuantidadeRemedio() + "caixas");
                            System.out.println(
                                    "O estoque de ChikTop possui: " + medicamento[2].getQuantidadeRemedio() + "caixas");
                            System.out
                                    .println("O estoque de Denguenit possui: " + medicamento[3].getQuantidadeRemedio()
                                            + "caixas");
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(" ");
                            break;
                        case 2:// Alterar estoque
                            int opcaoAlteraEstoque = 0;
                            do {
                                System.out.println("Escolha o estoque de remédio que deseja alterar");
                                System.out.println("1 - Alterar estoque de CovidUltra");
                                System.out.println("2 - Alterar estoque de Zicox");
                                System.out.println("3 - Alterar estoque de ChikTop");
                                System.out.println("4 - Alterar estoque de Denguenit");
                                opcaoAlteraEstoque = key.nextInt();
                            } while (opcaoAlteraEstoque > 4 || opcaoAlteraEstoque <= 0);
                            switch (opcaoAlteraEstoque) {
                                case 1: // Alterar quantidade de coviultra
                                    do {
                                        System.out.println("Digite a nova quantidade de CovidUltra do estoque");
                                        int covidAltera = key.nextInt();
                                        medicamento[0].setQuantidadeRemedio(covidAltera);
                                        if (medicamento[0].getQuantidadeRemedio() < 0) {
                                            System.out.println(
                                                    "Quantidades de caixas de CovidUltra inválida, tente novamente");
                                        }
                                    } while (medicamento[0].getQuantidadeRemedio() < 0);
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println("Estoque de CovidUltra atualizado");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println(" ");
                                    break;
                                case 2: // Alterar quantidade de zicox
                                    do {
                                        System.out.println("Digite a nova quantidade de Zicox do estoque");
                                        int zicAltera = key.nextInt();
                                        medicamento[1].setQuantidadeRemedio(zicAltera);
                                        if (medicamento[1].getQuantidadeRemedio() < 0) {
                                            System.out.println(
                                                    "Quantidades de caixas de Zicox inválida, tente novamente");
                                        }
                                    } while (medicamento[1].getQuantidadeRemedio() < 0);
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println("Estoque de Zicox atualizado");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println(" ");
                                    break;
                                case 3: // Alterar a quantidade de ChikTop
                                    do {
                                        System.out.println("Digite a nova quantidade de ChikTop do estoque");
                                        int chikAltera = key.nextInt();
                                        medicamento[2].setQuantidadeRemedio(chikAltera);
                                        if (medicamento[2].getQuantidadeRemedio() < 0) {
                                            System.out.println(
                                                    "Quantidades de caixas de ChikTop inválida, tente novamente");
                                        }
                                    } while (medicamento[2].getQuantidadeRemedio() < 0);
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println("Estoque de ChikTop atualizado");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println(" ");
                                    break;
                                case 4: // alterar a quantidade de Denguenit
                                    do {
                                        System.out.println("Digite a nova quantidade de Denguenit do estoque");
                                        int dengAltera = key.nextInt();
                                        medicamento[3].setQuantidadeRemedio(dengAltera);
                                        if (medicamento[3].getQuantidadeRemedio() < 0) {
                                            System.out.println(
                                                    "Quantidades de caixas de Denguenit inválida, tente novamente");
                                        }
                                    } while (medicamento[3].getQuantidadeRemedio() < 0);
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println("Estoque de Denguenit atualizado");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println(" ");
                                    break;
                            }
                            break;
                    }
                    break;

                case 5:
                    System.out.println("----------------------------------------------------------- ");
                    System.out.println("Obrigado por utilizar nosso programa");
                    System.out.println("----------------------------------------------------------- ");
                    saida = 5;
                    break;

            }
        } while (saida <= 0 || saida > 5);
    }
}
