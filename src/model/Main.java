package model;
import java.util.ArrayList;
import java.util.Scanner;
import model.Tutor;
import model.Adotante;
import model.Funcionario;


public class Main {
    // Lista para armazenar os usuários
    static ArrayList<Pessoa> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Loop do menu
        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    cadastrarTutor(scanner);
                    break;
                case 2:
                    cadastrarAdotante(scanner);
                    break;
                case 3:
                    cadastrarFuncionario(scanner);
                    break;
                case 4:
                    listarUsuarios();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Cadastrar Tutor");
        System.out.println("2. Cadastrar Adotante");
        System.out.println("3. Cadastrar Funcionário");
        System.out.println("4. Listar Usuários");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void cadastrarTutor(Scanner scanner) {
        System.out.println("\n=== Cadastro de Tutor ===");
        Pessoa tutor = new Tutor();

        // Solicitar dados do tutor
        System.out.print("Nome: ");
        tutor.setNome(scanner.nextLine());
        
        System.out.print("Gênero: ");
        tutor.setGenero(scanner.nextLine());

        System.out.print("CPF: ");
        tutor.setCpf(scanner.nextLine());

        System.out.print("Endereço: ");
        tutor.setEndereco(scanner.nextLine());

        System.out.print("Telefone: ");
        tutor.setTelefone(scanner.nextLine());

        System.out.print("Email: ");
        tutor.setEmail(scanner.nextLine());

        // Adicionar o tutor à lista de usuários
        usuarios.add(tutor);
        System.out.println("Tutor cadastrado com sucesso!");
    }

    public static void cadastrarAdotante(Scanner scanner) {
        System.out.println("\n=== Cadastro de Adotante ===");
        Pessoa adotante = new Adotante();

        // Solicitar dados do adotante
        System.out.print("Nome: ");
        adotante.setNome(scanner.nextLine());

        System.out.print("Gênero: ");
        adotante.setGenero(scanner.nextLine());

        System.out.print("CPF: ");
        adotante.setCpf(scanner.nextLine());

        System.out.print("Endereço: ");
        adotante.setEndereco(scanner.nextLine());

        System.out.print("Telefone: ");
        adotante.setTelefone(scanner.nextLine());

        System.out.print("Email: ");
        adotante.setEmail(scanner.nextLine());

        // Adicionar o adotante à lista de usuários
        usuarios.add(adotante);
        System.out.println("Adotante cadastrado com sucesso!");
    }

    public static void cadastrarFuncionario(Scanner scanner) {
        System.out.println("\n=== Cadastro de Funcionário ===");
        Pessoa funcionario = new Funcionario();

        // Solicitar dados do funcionário
        System.out.print("Nome: ");
        funcionario.setNome(scanner.nextLine());

       // System.out.print("Data de Nascimento: ");
        //funcionario.setDataNascimento(scanner.nextLine());

        System.out.print("Gênero: ");
        funcionario.setGenero(scanner.nextLine());

        System.out.print("CPF: ");
        funcionario.setCpf(scanner.nextLine());

        System.out.print("Endereço: ");
        funcionario.setEndereco(scanner.nextLine());

        System.out.print("Telefone: ");
        funcionario.setTelefone(scanner.nextLine());

        System.out.print("Email: ");
        funcionario.setEmail(scanner.nextLine());

        usuarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public static void listarUsuarios() {
        System.out.println("\n=== Lista de Usuários Cadastrados ===");
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Pessoa usuario : usuarios) {
                System.out.println("Nome: " + usuario.getNome());
            }
        }
    }
}