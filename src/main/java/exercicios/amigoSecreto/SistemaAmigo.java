package exercicios.amigoSecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo(List<Mensagem> mensagens, List<Amigo> amigos) {
        this.mensagens = mensagens;
        this.amigos = amigos;
    }

    public SistemaAmigo() {
        //TODO Auto-generated constructor stub
    }


    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws  AmigoJaExisteException {
        Amigo newAmigo = new Amigo(nomeAmigo, emailAmigo, "");
        if (this.amigos.contains(newAmigo)) {
            throw new AmigoJaExisteException("Amigo já existe na lista");
        } else {
            this.amigos.add(newAmigo);
        }
    }


    public Amigo pesquisaAmigo(String email) throws AmigoInexistenteException {

        Amigo amigoEncontrado = null;
        for (Amigo amigo: this.amigos) {
            if (amigo.getEmail().equalsIgnoreCase(email)) {
                amigoEncontrado = amigo;
                break;
            }
        }
        if (amigoEncontrado == null || this.amigos.isEmpty()) {
            throw new AmigoInexistenteException("Amigo inexistente");
        } return amigoEncontrado;
    }


    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {

        MensagemParaTodos msg = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        this.mensagens.add(msg);
        if (msg.ehAnonima()) {
            System.out.println("De: <anônimo> " + "\nPara @Todos\n" + texto);
        } else {
            System.out.println("De: " + emailRemetente + "\nPara @Todos\n" + texto);

        }

    }


    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        MensagemParaAlguem msg = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        this.mensagens.add(msg);
        if (msg.ehAnonima()) {
            System.out.println("De: <anônimo> " + "\nPara: " + emailDestinatario + "\n" + texto);
        } else {
            System.out.println("De: " + emailRemetente + "\nPara: " + emailDestinatario + "\n" + texto);

        }
    }


    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for (Mensagem mensagem : this.mensagens) {
            if (mensagem.ehAnonima()) {
                mensagensAnonimas.add(mensagem);
            }
        }
        return mensagensAnonimas;
    }


    public List<Mensagem> pesquisaTodasAsMensagens() {
        List<Mensagem> todasMensagens = this.mensagens;
        return todasMensagens;
    }


    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        if (amigoExiste(emailDaPessoa)) {
            for (Amigo amigo : this.amigos) {
                if (amigo.getEmail().equalsIgnoreCase(emailDaPessoa)) {
                    amigo.setEmailAmigoSorteado(emailAmigoSorteado);
                    break;
                }
            }
        } else {
            throw new AmigoNaoSorteadoException("Amigo não encontrado na lista");
        }
    }


    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {

        // As informações desejadas serão impressas na seguinte String:
        String amigoSecreto = "";

        // Verifica se o amigo procurado está na lista:
        if (amigoExiste(emailDaPessoa)) {

            for (Amigo amigo : this.amigos) {

                if (amigo.getEmailAmigoSorteado() == null) {
                    throw new AmigoNaoSorteadoException("Amigo sorteado não encontrado");
                } else if (amigo.getEmail().equalsIgnoreCase(emailDaPessoa)) {
                    amigoSecreto = amigo.getEmailAmigoSorteado();
                    break;
                }
            }
            return amigoSecreto;

            // Se o amigo não está na lista:
        } else {
            throw new AmigoInexistenteException("Amigo não econtrado na lista");
        }
    }


    public boolean amigoExiste(String emailAmigo) {
        boolean estaNaLista = false;
        if (this.amigos!= null){
            for (Amigo amigo : this.amigos) {
                if (amigo.getEmail().equalsIgnoreCase(emailAmigo)) {
                    estaNaLista = true;
                }
            }
        }
        return estaNaLista;
    }
}
