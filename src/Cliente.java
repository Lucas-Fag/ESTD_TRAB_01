public class Cliente {
    public static void main(String[] args) throws Exception {
        Contato dj = new Contato("Djonatan", "47 400395686", "djonatan@email.com");
        System.out.println(dj.toString());
        dj.setNome("Dj o natan");
        System.out.println(dj.toString());
        dj.desfazer();
        System.out.println(dj.toString());
    } 
}
