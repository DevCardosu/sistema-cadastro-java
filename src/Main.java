import model.Usuario;
import service.SistemaCadastro;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SistemaCadastro sistema = new SistemaCadastro();
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Buscar usuário por ID");
            System.out.println("4 - Remover usuário por ID");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            if (opcao == 1) {
                System.out.print("ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("Email: ");
                String email = scanner.nextLine();

                Usuario usuario = new Usuario(id, nome, email);
                sistema.cadastrarUsuario(usuario);

                System.out.println("Usuário cadastrado com sucesso!");

            } else if (opcao == 2) {
                sistema.listarUsuarios();

            } else if (opcao == 3) {
                System.out.print("Digite o ID do usuário: ");
                int idBusca = scanner.nextInt();

                Usuario encontrado = sistema.buscarPorId(idBusca);

                if (encontrado != null) {
                    System.out.println(encontrado);
                } else {
                    System.out.println("Usuário não encontrado.");
                }

            } else if (opcao == 4) {
                System.out.print("Digite o ID do usuário a remover: ");
                int idRemover = scanner.nextInt();

                boolean removido = sistema.removePorId(idRemover);

                if (removido) {
                    System.out.println("Usuário removido com sucesso.");
                } else {
                    System.out.println("Usuário não encontrado.");
                }

            } else if (opcao != 0) {
                System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
        System.out.println("Sistema encerrado.");
    }
}
