
import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.NodeList;


public class XMLRead {

    public static void main(String[] args) {

        try {

            // Cria uma instância de DocumentBuilderFactory

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Cria um DocumentBuilder

            DocumentBuilder builder = factory.newDocumentBuilder();

            // Carrega o arquivo XML

            Document document = builder.parse("pessoa.xml");

            // Normaliza o documento

            document.getDocumentElement().normalize();

            

            // Obtém o elemento raiz

            Element root = document.getDocumentElement();

            System.out.println("Elemento raiz: " + root.getNodeName());

            

            // Obtém e exibe os dados dos elementos
            String[] arr = {"nome", "email", "senha", "genero", "endereco", "telefone"};
            for (String tipo :arr){
                NodeList tituloList = document.getElementsByTagName(tipo);
                System.out.println( tipo.toUpperCase()+": " + tituloList.item(0).getTextContent());

            }

            

            


            


            

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}