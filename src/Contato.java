import Pilha.PilhaCheiaException;
import Pilha.PilhaEstatica;
import Pilha.PilhaVaziaException;

public class Contato {
    private static int proximoId = 0;
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private PilhaEstatica pilhaBackup;

    
    private void salvaBackup() throws PilhaCheiaException {
        Contato bkp = new Contato(this.id, this.nome, this.telefone, this.email);
        this.pilhaBackup.push(bkp);
    }

    public Contato(String nome, String telefone, String email) {
        Contato.proximoId++;
        this.id = Contato.proximoId;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.pilhaBackup = new PilhaEstatica(10);
    }

    private Contato(int id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public void desfazer() throws PilhaVaziaException {
        Contato backup;
        backup = (Contato) this.pilhaBackup.pop();
        this.nome = backup.getNome();
        this.telefone = backup.getTelefone();
        this.email = backup.getEmail();
    }

    @Override
    public String toString() {
        return "Contato " + this.id + ":\nNome: " + this.nome + "\nTelefone: " + this.telefone + "\nEmail: " + this.email;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        try {
            this.salvaBackup();
        } catch (PilhaCheiaException e) {
            System.out.println("Não foi possivel salvar um backup. Motivo: Pilha Cheia");
        }
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        try {
            this.salvaBackup();
        } catch (PilhaCheiaException e) {
            System.out.println("Não foi possivel salvar um backup. Motivo: Pilha Cheia");
        }
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        try {
            this.salvaBackup();
        } catch (PilhaCheiaException e) {
            System.out.println("Não foi possivel salvar um backup. Motivo: Pilha Cheia");
        }
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

}
