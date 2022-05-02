import Pilha.PilhaEstatica;

public class Contato {
    private static int proximoId = 0;
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private PilhaEstatica pilhaBackup;

    
    private void salvaBackup() {
        Contato bkp = new Contato(this.id, this.nome, this.telefone, this.email);
        try {
            this.pilhaBackup.push(bkp);
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
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

    public void desfazer() {
        Contato backup;
        try {
            backup = (Contato) this.pilhaBackup.pop();
            this.nome = backup.getNome();
            this.telefone = backup.getTelefone();
            this.email = backup.getEmail();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Contato [email=" + email + ", id=" + id + ", nome=" + nome + ", pilhaBackup=" + pilhaBackup
                + ", telefone=" + telefone + "]";
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.salvaBackup();
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.salvaBackup();
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.salvaBackup();
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

}
