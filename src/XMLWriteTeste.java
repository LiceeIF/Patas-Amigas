import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import model.Pessoa;

public class XMLWriteTeste {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            String[] campos = {"nome", "data de nascimento","email", "senha", "gênero", "endereço", "telefone", "CPF"};
            String[] envios = new String[8];

            for (int i = 0; i < campos.length; i++) {
                System.out.println("Insira seu " + campos[i] + ":");
                envios[i] = sc.nextLine();
            }

            String nome = envios[0];
            String nascimento = envios[1];
            String email = envios[2];
            String senha = envios[3];
            String genero = envios[4];
            String endereco = envios[5];
            String telefone = envios[6];
            String cpf = envios[7];

            Pessoa p = new Pessoa(nome,nascimento,genero,cpf,endereco,telefone,email,senha );

            sc.close();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.newDocument();

            Element rootElement = document.createElement("pessoa");
            document.appendChild(rootElement);

            LocalDate dataDeNascimento = LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String dataStr = dataDeNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            criarElemento(document, rootElement, "nome", p.getNome());
            criarElemento(document, rootElement, "email", p.getEmail());
            criarElemento(document, rootElement, "senha", p.getSenha());
            criarElemento(document, rootElement, "genero", p.getGenero());
            criarElemento(document, rootElement, "data_nascimento", dataStr);
            criarElemento(document, rootElement, "endereco", p.getEndereco());
            criarElemento(document, rootElement, "telefone", p.getTelefone());
            criarElemento(document, rootElement, "cpf", p.getCpf());

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult("pessoa.xml");

            transformer.transform(source, result);

            System.out.println("Arquivo XML criado com sucesso!");

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
