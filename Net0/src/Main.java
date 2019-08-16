import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by sam on 4/30/19.
 */
public class Main {
    public static void main(String[] args){
        File fXmlFile = new File("/Users/sam/Projects/MakerProjects/Net0/src/example.xml");

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            Element root = doc.getDocumentElement();

            Collection<Server> servers = new ArrayList<Server>();
            servers.add(new Server());

            for (Server server : servers) {
                // server elements
                Element newServer = doc.createElement("server");

                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(server.getName()));
                newServer.appendChild(name);

                Element port = doc.createElement("port");
                port.appendChild(doc.createTextNode(Integer.toString(server.getPort())));
                newServer.appendChild(port);

                root.appendChild(newServer);
            }

            DOMSource source = new DOMSource(doc);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("/Users/sam/Projects/MakerProjects/Net0/src/example.xml");
            transformer.transform(source, result);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("staff");


            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Staff id : " + eElement.getAttribute("id"));
                    System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

                }
            }






        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}

class Server {
    public String getName() { return "foo"; }
    public Integer getPort() { return 12345; }
}
