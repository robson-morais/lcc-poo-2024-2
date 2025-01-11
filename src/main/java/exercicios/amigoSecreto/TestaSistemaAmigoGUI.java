package exercicios.amigoSecreto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Mensagem> mensagens = new ArrayList<>();
        List<Amigo> amigos = new ArrayList<>();
        SistemaAmigo sistema = new SistemaAmigo(mensagens, amigos);
        int quant = 2;

        System.out.println("Quantidade de participantes da brincadeira: " + quant);

        // Cadastrando usuários:
        for (int p = 0; p < quant; p++) {
            String nome = sc.nextLine();
            String emailRemetente = sc.nextLine();
            try {
                sistema.cadastraAmigo(nome, emailRemetente);
            } catch (AmigoJaExisteException e) {
                System.out.println(e.getMessage());
            }
        }

        // Enviando uma mensagem:
        System.out.println("Enviar uma mensagem\nDe: ");

        String emailRemetente = sc.nextLine();
        String texto = sc.nextLine();
        boolean ehAnonima = sc.nextBoolean();

        sistema.enviarMensagemParaTodos(texto, emailRemetente, ehAnonima);
    }
}
