package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pessoa {
    private String nome;
    private LocalDate dataDeNascimento;
    private String genero;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;
    private String senha;

    public Pessoa() {}

    public Pessoa(String nome, String dataDeNascimento, String genero, String cpf, String endereco, String telefone, String email, String senha) {
        setNome(nome);
        this.dataDeNascimento = convertDate(dataDeNascimento);
        setGenero(genero);
        setCpf(cpf);
        setEndereco(endereco);
        setTelefone(telefone);
        setEmail(email);
        setSenha(senha);
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    private void setTelefone(String telefone) {
        if (telefone == null || telefone.isEmpty()) {
            throw new IllegalArgumentException("Telefone não pode ser vazio.");
        }
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public static boolean isValidEmail(String email) {
        final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

        if (email == null) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    private LocalDate convertDate(String nascDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(nascDate, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data de nascimento inválida. Use o formato dd/MM/yyyy.");
        }
    }

    public String getGenero() {
        return genero;
    }

    private void setGenero(String genero) {
        if (genero == null || genero.isEmpty()) {
            throw new IllegalArgumentException("Gênero não pode ser vazio.");
        }
        this.genero = genero;
    }

    public String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        if (!validarCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.cpf = cpf.replaceAll("[.-]", ""); // Remove caracteres especiais
    }

    public String getEndereco() {
        return endereco;
    }

    private void setEndereco(String endereco) {
        if (endereco == null || endereco.isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser vazio.");
        }
        this.endereco = endereco;
    }

    private void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email inválido.");
        }
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    private void setSenha(String senha) {
        if (!validarSenha(senha)) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 12 caracteres e incluir letras maiúsculas, minúsculas, números e caracteres especiais.");
        }
        this.senha = senha;
    }

    public boolean validarSenha(String senha) {
        return senha.length() >= 12 &&
               senha.matches(".*[A-Z].*") &&
               senha.matches(".*[a-z].*") &&
               senha.matches(".*[0-9].*") &&
               senha.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\|,.<>\\/?].*");
    }

    public boolean validarCPF(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            return false;
        }
        cpf = cpf.replaceAll("[.-]", "");
        if (cpf.length() != 11) {
            return false;
        }

        String semUltimosDois = cpf.substring(0, 9);
        int[] num = new int[]{10, 11};
        int[] resto = new int[2];

        for (int i = 0; i < 2; i++) {
            int valor = 0;
            for (int j = 0; j < semUltimosDois.length(); j++) {
                valor += num[i] * (cpf.charAt(j) - '0');
                num[i]--;
            }
            if (valor % 11 >= 2) {
                resto[i] = 11 - (valor % 11);
            } else {
                resto[i] = 0;
            }

            semUltimosDois += resto[i];
        }
        return resto[0] == (cpf.charAt(9) - '0') && resto[1] == (cpf.charAt(10) - '0');
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Pessoa {" +
                "Nome='" + nome + '\'' +
                ", Data de Nascimento='" + dataDeNascimento.format(formatter) + '\'' +
                ", Gênero='" + genero + '\'' +
                ", CPF='" + cpf + '\'' +
                ", Endereço='" + endereco + '\'' +
                ", Telefone='" + telefone + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }
}
