public class MensagemParaTodos extends Mensagem {

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        super(texto,emailRemetente,anonima);
    }

    public String getTextoCompletoAExibir(){
        return "Mensagem para todos => De " + getEmailRemetente() + "\nPara @Todos\n" + getTexto() + " <=\n";
    }
    
}
