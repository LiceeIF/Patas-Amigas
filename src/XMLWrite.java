import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.Pessoa;

public class XMLWrite {

    public static void main(String[] args) {

        try {

            Pessoa p = new Pessoa();
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Insira seu nome:");
            p.setNome(sc.nextLine());

            System.out.println("Insira seu email:");
            p.setEmail(sc.nextLine());

            System.out.println("Insira sua senha:");
            p.setSenha(sc.nextLine());

            System.out.println("Insira seu gênero:");
            p.setGenero(sc.nextLine());

            System.out.println("Insira seu endereço:");
            p.setEndereco(sc.nextLine());

            System.out.println("Insira seu telefone:");
            p.setTelefone(sc.nextLine());

            sc.close();

            // Cria uma instância de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Cria um DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Cria um novo documento XML
            Document document = builder.newDocument();

            // Cria o elemento raiz
            Element rootElement = document.createElement("pessoa");
            document.appendChild(rootElement);

            // Cria e adiciona os elementos filhos
            Element nome = document.createElement("nome");
            nome.appendChild(document.createTextNode(p.getNome()));
            rootElement.appendChild(nome);

            Element email = document.createElement("email");
            email.appendChild(document.createTextNode(p.getEmail()));
            rootElement.appendChild(email);

            Element senha = document.createElement("senha");
            senha.appendChild(document.createTextNode(p.getSenha()));
            rootElement.appendChild(senha);

            Element genero = document.createElement("genero");
            genero.appendChild(document.createTextNode(p.getGenero()));
            rootElement.appendChild(genero);

            Element endereco = document.createElement("endereco");
            endereco.appendChild(document.createTextNode(p.getEndereco()));
            rootElement.appendChild(endereco);

            Element telefone = document.createElement("telefone");
            telefone.appendChild(document.createTextNode(p.getTelefone()));
            rootElement.appendChild(telefone);

            // Cria um Transformer para converter o documento para XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult("pessoa.xml");

            // Escreve o documento XML para o arquivo
            transformer.transform(source, result);

            System.out.println("Arquivo XML criado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
