package exercicio_bilheteunico;

import javax.swing.*;

import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {
    //banco de dados de mentira
    private BilheteUnico[] bilhete = new BilheteUnico[2];
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
}
