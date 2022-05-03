import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    static ArrayList<Contato> listaContatos = new ArrayList<>(); 
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int opcao = 0;

        limpaTerminal();
        do {
            System.out.println("-------- Opções --------");
            System.out.println("| 1 - Visualizar lista |");
            System.out.println("| 2 - Inserir Contato  |");
            System.out.println("| 3 - Editar Contato   |");
            System.out.println("| 4 - Sair             |");
            System.out.println("------------------------");
            System.out.print("Ação: ");
            opcao = Integer.parseInt(scn.nextLine());

            switch (opcao) {
                case 1:
                    visualizarLista();
                    break;
                case 2:
                    inserirContato();
                    break;
                case 3:
                    if (listaContatos.isEmpty()) {
                        System.out.println("Você deve adicionar um contato primeiro!");
                        System.out.print("Confirme para continuar");
                        scn.nextLine();
                        limpaTerminal();
                    } else {
                        editarContato();
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Invalida!");
                    break;
            }

        } while (opcao != 4);

        scn.close();
    }

    public static void limpaTerminal() {
        for (int i = 0; i <= 999; i++) {
            System.out.println();
        }
    }
    
    public static void visualizarLista() {
        limpaTerminal();
        System.out.println("-------- 1 - Visualizar lista --------");

        if (!listaContatos.isEmpty()) {
            listaContatos.forEach(contato -> System.out.println(contato));
        } else {
            System.out.println("Lista Vazia!");
        }

        System.out.print("Confirme para voltar ao menu");
        scn.nextLine();
        limpaTerminal();
    }
    
    public static void inserirContato() {
        String nome, email, telefone, resp;
        Contato contato;
        boolean sair = false;

        limpaTerminal();
        System.out.println("-------- 2 - Inserir Contato --------");
        System.out.print("Informe o nome do contato: ");
        nome = scn.nextLine();
        System.out.print("Informe o telefone do contato: ");
        telefone = scn.nextLine();
        System.out.print("Informe o email do contato: ");
        email = scn.nextLine();

        do {
            System.out.println("-------- Contato --------");
            System.out.println("Nome: " + nome);
            System.out.println("Telefone: " + telefone);
            System.out.println("Email: " + email);
            System.out.println("--------------------------");
            System.out.print("Salvar Contato? (S/N)");
            resp = scn.nextLine();
            
            if (resp.toUpperCase().equals("S")) {
                contato = new Contato(nome, telefone, email);
                listaContatos.add(contato);
                sair = true;
            } else if (resp.toUpperCase().equals("N")) {
                System.out.println("Ok, Cancelando...");
                sair = true;
            } else {
                System.out.println("Resposta Invalida!");
            }
        } while (!sair);
        limpaTerminal();

    }

    private static void editarContato() {
        limpaTerminal();
        int opcao;
        Contato contato;

        do {
            System.out.println("-------- 3 - Editar Contato --------");
            System.out.println("| 1 - Editar Contato               |");
            System.out.println("| 2 - Voltar Versão                |");
            System.out.println("| 3 - Excluir Contato              |");
            System.out.println("| 4 - Voltar ao Menu               |");
            System.out.println("------------------------------------");
            System.out.print("Ação: ");
            opcao = Integer.parseInt(scn.nextLine());

            switch (opcao) {
                case 1:
                    contato = getContato();
                    if (contato != null) {
                        editarId(contato);
                    }
                    break;
                case 2:
                    contato = getContato();
                    if (contato != null) {
                        voltarVersao(contato);
                    }
                    break;
                case 3:
                    contato = getContato();
                    if (contato != null) {
                        excluirContato(contato);
                    }
                    break;
                case 4:
                    limpaTerminal();
                    break;
                default:
                    System.out.println("Opção Invalida!");
                    break;
            }


        } while (opcao != 4);
            
    }

    public static void editarId(Contato contato) {

    }

    public static void voltarVersao(Contato contato) {
    
    }

    public static void excluirContato(Contato contato) {

    }

    public static Contato getContato() {
        boolean sair = false;
        int id;
        String resp;

        do {
            System.out.print("Informe o id do contato que você quer editar: ");
            id = Integer.parseInt(scn.nextLine());

            for (int i = 0; i < listaContatos.size(); i++) {
                if (listaContatos.get(i).getId() == id) {
                    return listaContatos.get(i);
                }
            }
            
            System.out.print("Id não encontrado, tentar novamente? (S/N)");
            resp = scn.nextLine();

            if (resp.toUpperCase().equals("N")) {
                sair = true;
            }
        } while (!sair);

        return null;
    }
     
}
