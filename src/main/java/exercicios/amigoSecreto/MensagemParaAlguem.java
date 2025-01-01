public class MensagemParaAlguem extends Mensagem {
    
    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }
    
    public String getTextoCompletoAExibir() {
        return "Mensagem para alguém => De: " + getEmailRemetente() + "\nPara: " + this.emailDestinatario +
        "\n" + getTexto() + " <=\n";
    }
}