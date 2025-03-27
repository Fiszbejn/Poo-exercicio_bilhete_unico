package exercicio_bilheteunico;

import javax.swing.*;

import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {
    //banco de dados de mentira
    private BilheteUnico[] bilhete = new BilheteUnico[5];
    private int index = 0;
    public void menuPrincipal() {
        int opcao;
        String menu = "1. Administrador\n2. Usuário\n3. Finalizar";
        do {
            opcao = parseInt(showInputDialog(menu));
            switch(opcao) {
                case 1:
                    menuAdministrador();
                    break;
                case 2:
                    menuUsuario();
                    break;
            }
        }while(opcao != 3);
    }

    private void menuAdministrador() {
        int opcao;
        String menu = "MENU ADMINISTRADOR\n" +
                "1. Emitir Bilhete\n" +
                "2. Listar bilhetes\n" +
                "3. Excluir bilhete\n" +
                "4. Sair";
        do {
            opcao = parseInt(showInputDialog(menu));
            switch (opcao) {
                case 1:
                    emitirBilhete();
                    break;
                case 2:
                    listarBilhetes();
                    break;
                case 3:
                    excluirBilhete();
                    break;
            }
        }while(opcao != 4);
    }

    private void menuUsuario() {
        int opcao;

        String menu = "MENU USUÁRIO\n" +
                "1. Carregar bilhete\n" +
                "2. Consultar saldo\n" +
                "3. Passar na catraca\n" +
                "4. Sair";
        do {
            opcao = parseInt(showInputDialog(menu));
            if(opcao < 1 || opcao > 4) {
                showMessageDialog(null, "Opção Inválida!", "Aviso", WARNING_MESSAGE);
            }else {
                switch (opcao) {
                    case 1:
                        carregarBilhete();
                        break;
                    case 2:
                        consultaSaldo();
                        break;
                    case 3:
                        passaCatraca();
                        break;
                }

            }
        }while(opcao != 4);
    }

    private void emitirBilhete() {
        if(index < bilhete.length) {
            String msgNome = "Digite o Nome do usuário:";
            String nome = showInputDialog(msgNome);
            String msgCpf = "Digite o CPF do usuário:";
            Long cpf = parseLong(showInputDialog(msgCpf));
            String msgPerfil = "Digite o perfil do usuário\nProfessor, Estudante ou Comum:";
            String perfil = showInputDialog(msgPerfil);
            bilhete[index] = new BilheteUnico(nome, cpf, perfil);
            index++;
        }else {
            String msgErroEmissao = "LIMITE DE BILHETES ATINGIDO!\nEntre em contato com a SPTRANS.";
            showMessageDialog(null, msgErroEmissao, "Erro", ERROR_MESSAGE);
        }
    }

    private void listarBilhetes() {
        DecimalFormat df = new DecimalFormat("0.00");
        String aux = "";
        for (int i = 0; i < index; i++) {
             aux += "Bilhete Número: " + bilhete[i].numero
                    + "\nSaldo: R$" + df.format(bilhete[i].saldo)
                    + "\nNome: " + bilhete[i].usuario.nome
                    + "\nPerfil: " + bilhete[i].usuario.perfil
                    + "\nCPF: " + bilhete[i].usuario.cpf + "\n\n";
        }
        showMessageDialog(null, aux);
    }

    private void excluirBilhete() {
        int resposta;
        int indice = pesquisaBilhete();
        if(indice != -1) {
            resposta = showConfirmDialog(null,"Tem certeza que deseja excluir?");
            if(resposta == YES_OPTION) {
                bilhete[indice] = bilhete[index - 1];
                index--;
            }
        }
    }

    private int pesquisaBilhete() {
        long cpf = parseLong(showInputDialog("CPF:"));
        for (int i = 0; i < index; i++) {
            if(bilhete[i].usuario.cpf == cpf) {
                return i;
            }
        }
        showMessageDialog(null, cpf + " não encontrado", "aviso", WARNING_MESSAGE);
        return -1;
    }

    private void carregarBilhete() {
        int indice = pesquisaBilhete();
        double valor;
        if(indice != -1) {
            valor = parseDouble(showInputDialog("Digite o valor da recarga:"));
            bilhete[indice].carregar(valor);
        }
    }

    private void consultaSaldo() {
        int indice = pesquisaBilhete();
        if(indice != -1) {
            showMessageDialog(null, "Saldo = R$" + bilhete[indice].consultaSaldo());
        }
    }

    private void passaCatraca() {
        int indice = pesquisaBilhete();
        if(indice != -1) {
            showMessageDialog(null, bilhete[indice].passarNaCatraca());
        }
    }

}
