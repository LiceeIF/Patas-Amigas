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

public class XMLWrite {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            String[] campos = {"nome", "email", "senha", "gênero", "endereço", "telefone", "CPF"};
            String[] envios = new String[7];

            for (int i = 0; i < campos.length; i++) {
                System.out.println("Insira seu " + campos[i] + ":");
                envios[i] = sc.nextLine();
            }

            Pessoa p = new Pessoa();
            p.setNome(envios[0]);
            p.setEmail(envios[1]);
            p.setSenha(envios[2]);
            p.setGenero(envios[3]);
            p.setEndereco(envios[4]);
            p.setTelefone(envios[5]);
            p.setCpf(envios[6]);

            sc.close();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.newDocument();

            Element rootElement = document.createElement("pessoa");
            document.appendChild(rootElement);

            criarElemento(document, rootElement, "nome", p.getNome());
            criarElemento(document, rootElement, "email", p.getEmail());
            criarElemento(document, rootElement, "senha", p.getSenha());
            criarElemento(document, rootElement, "genero", p.getGenero());
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
