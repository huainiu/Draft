package Misc;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by Michael.Shreiber on 3/6/14.
 */


public class ModifyXML {

    public static void main(String[] args) {

        try {
            String filepath = "C:/QA_Tools/OneCalaisTester/OneCalaisTester.exe-Copy.config";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            // Get the root element
            //Node company = doc.getFirstChild();

            // Get the staff element by tag name directly
            //Node staff = doc.getElementsByTagName("staff").item(0);

            NodeList nList = doc.getElementsByTagName("setting");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                System.out.println("Current Element: " + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("name : " + eElement.getAttribute("name"));
                    System.out.println("value : " + eElement.getElementsByTagName("value").item(0).getTextContent());
                    if(eElement.getAttribute("name").equals("HeadersPath")){
                        nNode.removeChild(eElement.getElementsByTagName("value").item(0));
                        Element newValue = doc.createElement("value");
                        newValue.appendChild(doc.createTextNode("xxxxxxxxxxxxxxxxxxxxxxxxxx"));
                        nNode.appendChild(newValue);
                    }



                }
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            //StreamResult result = new StreamResult(new File(filepath));
            StreamResult result = new StreamResult(doc.getBaseURI());
            transformer.transform(source, result);

            System.out.println("Done");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
    }
}
