package exercicios.amigoSecreto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Mensagem> mensagens = new ArrayList<>();
        List<Amigo> amigos = new ArrayList<>();
        SistemaAmigo sistema = new SistemaAmigo(mensagens, amigos);

        try {
            // Cadastrando amigos na lista:
            sistema.cadastraAmigo("José", "jose@email.com");
            sistema.cadastraAmigo("Maria","maria@email.com");

            // Configurando seus emails:
            sistema.configuraAmigoSecretoDe("jose@email.com","maria@email.com");
            sistema.configuraAmigoSecretoDe("maria@email.com", "jose@email.com");

        } catch (AmigoJaExisteException | AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println(e.getMessage());        }
        try {
            System.out.println("Email do amigo secreto de Maria: " + sistema.pesquisaAmigoSecretoDe("maria@email.com"));
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println(e.getMessage());
        }

        // Enviando mensagens:
        sistema.enviarMensagemParaAlguem("Olá, José!", "maria@email.com","jose@gmail.com", true);
        sistema.enviarMensagemParaTodos("Olá a todos!", "maria@email.com", true);
        sistema.enviarMensagemParaTodos("Esta mensagem não é anônima", "maria@email.com", false);


        // Exibindo as mensagens anonimas:
        for (Mensagem msg: sistema.pesquisaMensagensAnonimas()) {
            System.out.println(msg.getTextoCompletoAExibir());
        }

        // Questão 3. f)
        try {
            if (sistema.pesquisaAmigoSecretoDe("jose@email.com").equalsIgnoreCase("maria@email.com")) {
                System.out.println("OK");
            }
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println(e.getMessage());
        }


    }
}
