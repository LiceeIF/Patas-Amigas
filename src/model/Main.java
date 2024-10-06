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
                    listarEspecificos("Tutor");
                    break;
                case 6:
                    listarEspecificos("Adotante");
                    break;
                case 7:
                    listarEspecificos("Funcionario");
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 8);

        scanner.close();
    }   

    public static void mostrarMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Cadastrar Tutor");
        System.out.println("2. Cadastrar Adotante");
        System.out.println("3. Cadastrar Funcionário");
        System.out.println("4. Listar todos os usuários");
        System.out.println("5. Listar os tutores");
        System.out.println("6. Listar os adotantes");
        System.out.println("7. Listar os funcionários");
        System.out.println("8. Sair");
        System.out.print("Escolha uma opção: ");
    }
public static void cadastrarTutor(Scanner scanner) {
        System.out.println("\n=== Cadastro de Tutor ===");

        // Solicitar dados do tutor
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("Data de Nascimento:");
        System.out.println("Ex: dd/MM/aaaa");
        String nascdate = scanner.nextLine();
        
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.println("Senha: ");
        System.out.println("A senha deve ter pelo menos 12 caracteres e incluir letras maiúsculas, minúsculas, números e caracteres especiais.");
        String senha = scanner.nextLine();

        System.out.print("ID: ");
        int id = scanner.nextInt();

        System.out.print("Número de animais: ");
        int nAnimais = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Adoções: ");
        String adocoes = scanner.nextLine();

        // Adicionar o tutor à lista de usuários
        Tutor tutor = new Tutor(nome, nascdate, genero, cpf, endereco, telefone, email, senha, id, nAnimais,adocoes);
        usuarios.add(tutor);
        GerarXML.gerarXmlTutor(tutor);

        System.out.println("Tutor cadastrado com sucesso!");
    }


    public static void cadastrarAdotante(Scanner scanner) {
        System.out.println("\n=== Cadastro de Adotante ===");

        // Solicitar dados do adotante
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("Data de Nascimento:");
        System.out.println("Ex: dd/MM/aaaa");
        String nascDate = scanner.nextLine();

        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
    
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.println("Senha:");
        System.out.println("A senha deve ter pelo menos 12 caracteres e incluir letras maiúsculas, minúsculas, números e caracteres especiais.");
        String senha = scanner.nextLine();

        System.out.print("ID Adotante: ");
        int idAdotante = scanner.nextInt();
        scanner.nextLine();  

        System.out.println("Preferencias: ");
        String preferencias = scanner.nextLine();

        System.out.print("Adocoes: ");
        String adocoes = scanner.nextLine();


        // Adicionar o adotante à lista de usuários
        Adotante adotante = new Adotante(nome,nascDate,genero,cpf,endereco,telefone,email,senha,idAdotante,preferencias,adocoes);
        usuarios.add(adotante);
        System.out.println("Adotante cadastrado com sucesso!");
        GerarXML.gerarXmlAdotante(adotante);

    }

    public static void cadastrarFuncionario(Scanner scanner) {
        System.out.println("\n=== Cadastro de Funcionário ===");
    
        // Solicitar dados do funcionário
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
    
        System.out.println("Data de Nascimento: ");
        System.out.println("Ex: dd/MM/aaaa");
        String nascDate = scanner.nextLine();
    
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
    
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
    
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
    
        System.out.print("Email: ");
        String email = scanner.nextLine();
    
        System.out.println("Senha:");
        System.out.println("A senha deve ter pelo menos 12 caracteres e incluir letras maiúsculas, minúsculas, números e caracteres especiais.");
        String senha = scanner.nextLine();
    
        System.out.print("ID: ");
        int idFuncionario = scanner.nextInt();
        scanner.nextLine();  
    
        System.out.print("Data de contratação: ");
        String dataContratacao = scanner.nextLine();
    
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
    
        System.out.print("Salário: ");
        float salario = scanner.nextFloat();
        scanner.nextLine();  
    
        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();
    
        Funcionario funcionario = new Funcionario(nome, nascDate, genero, cpf, endereco, telefone, email, senha, idFuncionario, dataContratacao, cargo, salario, departamento);
        usuarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
        GerarXML.gerarXmlFuncionario(funcionario);
    }
    


public static void listarUsuarios() {
    System.out.println("\n=== Lista de Usuários Cadastrados ===");
    if (usuarios.isEmpty()) {
        System.out.println("Nenhum usuário cadastrado.");
    } else {
        for (Pessoa usuario : usuarios) {
            System.out.println("Nome: " + usuario.getNome() + " || Tipo: " + usuario.getClass().getSimpleName());
        }
    }
}


public static void listarEspecificos(String tipo) {

    if (tipo == "Tutor"){
        System.out.println("\n=== Lista de " + tipo + "es Cadastrados ===");
    } else {
        System.out.println("\n=== Lista de " + tipo + "s Cadastrados ===");
    }

    boolean found = false;

    if (usuarios.isEmpty()) {
        System.out.println("Nenhum " + tipo + " cadastrado.");
    } else {
        for (Pessoa usuario : usuarios) {
            // usuario pertence a classe desejada
            if (usuario.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                System.out.println(usuario.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nenhum " + tipo + " cadastrado.");
        }
    }
}


}