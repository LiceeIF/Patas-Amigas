package model;
import java.time.format.DateTimeFormatter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GerarXML {

    public static void gerarXmlTutor(Tutor tutor) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            
            Element rootElement = document.createElement("tutor");
            document.appendChild(rootElement);
            
            criarElemento(document, rootElement, "nome", tutor.getNome());
            criarElemento(document, rootElement, "data_nascimento", tutor.getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            criarElemento(document, rootElement, "genero", tutor.getGenero());
            criarElemento(document, rootElement, "cpf", tutor.getCpf());
            criarElemento(document, rootElement, "endereco", tutor.getEndereco());
            criarElemento(document, rootElement, "telefone", tutor.getTelefone());
            criarElemento(document, rootElement, "email", tutor.getEmail());
            criarElemento(document, rootElement, "senha", tutor.getSenha());
            criarElemento(document, rootElement, "id_tutor", String.valueOf(tutor.getIdTutor()));
            criarElemento(document, rootElement, "num_animais", String.valueOf(tutor.getnAnimais()));
            criarElemento(document, rootElement, "adocoes", tutor.getAdocoes());
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult("tutor.xml");
            
            transformer.transform(source, result);
            System.out.println("Arquivo XML para Tutor criado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void gerarXmlFuncionario(Funcionario funcionario) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            
            Element rootElement = document.createElement("funcionario");
            document.appendChild(rootElement);
            
            criarElemento(document, rootElement, "nome", funcionario.getNome());
            criarElemento(document, rootElement, "data_nascimento", funcionario.getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            criarElemento(document, rootElement, "genero", funcionario.getGenero());
            criarElemento(document, rootElement, "cpf", funcionario.getCpf());
            criarElemento(document, rootElement, "endereco", funcionario.getEndereco());
            criarElemento(document, rootElement, "telefone", funcionario.getTelefone());
            criarElemento(document, rootElement, "email", funcionario.getEmail());
            criarElemento(document, rootElement, "senha", funcionario.getSenha());
            criarElemento(document, rootElement, "id_funcionario", String.valueOf(funcionario.getIdFuncionario()));
            criarElemento(document, rootElement, "dataContratacao", funcionario.getDataContratacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            criarElemento(document, rootElement, "cargo", funcionario.getCargo());
            criarElemento(document, rootElement, "salario", String.valueOf(funcionario.getSalario()));
            criarElemento(document, rootElement, "departamento", funcionario.getDepartamento());

            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult("funcionario.xml");
            
            transformer.transform(source, result);
            System.out.println("Arquivo XML para Funcionário criado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void gerarXmlAdotante(Adotante adotante) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            
            Element rootElement = document.createElement("adotante");
            document.appendChild(rootElement);
            
            criarElemento(document, rootElement, "nome", adotante.getNome());
            criarElemento(document, rootElement, "data_nascimento", adotante.getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            criarElemento(document, rootElement, "genero", adotante.getGenero());
            criarElemento(document, rootElement, "cpf", adotante.getCpf());
            criarElemento(document, rootElement, "endereco", adotante.getEndereco());
            criarElemento(document, rootElement, "telefone", adotante.getTelefone());
            criarElemento(document, rootElement, "email", adotante.getEmail());
            criarElemento(document, rootElement, "senha", adotante.getSenha());
            criarElemento(document, rootElement, "id_adotante", String.valueOf(adotante.getIdAdotante()));
            criarElemento(document, rootElement, "preferencias_de_adocao", adotante.getPreferenciasDeAdocao());
            criarElemento(document, rootElement, "adoções", adotante.getAdocoes());
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult("adotante.xml");
            
            transformer.transform(source, result);
            System.out.println("Arquivo XML para Adotante criado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void criarElemento(Document doc, Element root, String nome, String valor) {
        Element elemento = doc.createElement(nome);
        elemento.appendChild(doc.createTextNode(valor));
        root.appendChild(elemento);
    }
}


