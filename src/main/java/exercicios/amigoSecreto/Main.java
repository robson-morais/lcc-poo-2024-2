import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    public static void main (String [] args) {
        
        List<Mensagem> mensagens = new ArrayList<>();
        List<Amigo> amigos = new ArrayList<>();
        SistemaAmigo sistema = new SistemaAmigo(mensagens, amigos);


        // Armazenando Mensagens na lista:
        Mensagem m1 = new MensagemParaAlguem("Olá, tudo joia?\nSó passando para desejar boas festas!", "remetente@email.com", "destinatario@email.com", false);
        Mensagem m2 = new MensagemParaAlguem("Hello World!", "remetente@email.com", "destinatario@email.com", false);
        Mensagem mpt1 = new MensagemParaTodos("Sejam todos bem-vindos(as)!", "adm@email.com", false);

        mensagens.add(m1); mensagens.add(m2); mensagens.add(mpt1);

        // Adicionando Amigos na lista:
        Amigo jose = new Amigo("José", "jose@email.com", "primeiro email");
        Amigo maria = new Amigo("Maria", "maria@email.com", "Primeiro email de maria");
        
        amigos.add(jose);
        amigos.add(maria);


        //Configurando o amigo sorteado de Maria:
        try {
            sistema.configuraAmigoSecretoDe("maria@email.com", "joao@email.com");
        } catch (AmigoInexistenteException e) {
            e.printStackTrace();
        }
        //Configurando o amigo sorteado de Joao:
        try {  
            sistema.configuraAmigoSecretoDe("jose@email.com", "maria@email.com");
        } catch (AmigoInexistenteException e) {
            e.printStackTrace();
        }

        // Printando o email do amigo sorteado de João:
        try {
            System.out.println(sistema.pesquisaAmigoSecretoDe("jose@email.com"));
        } catch (AmigoNaoSorteadoException a) {
            System.out.println(a.getMessage());
        } catch (AmigoInexistenteException a) {
            System.out.println(a.getMessage());
        }

        // Printando o email do amigo sorteado de Maria:
        try {
            System.out.println(sistema.pesquisaAmigoSecretoDe("maria@email.com"));
            } catch (AmigoNaoSorteadoException e) {
                System.out.println(e.getMessage());
    
            } catch (AmigoInexistenteException i) {
                System.out.println(i.getMessage());
        }

        System.out.println(maria.getEmailAmigoSorteado());

    }
}
