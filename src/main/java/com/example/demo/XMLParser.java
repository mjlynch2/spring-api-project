package com.example.demo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

public class XMLParser {

    public static Document getDoc(String url) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL(url).openStream());
        return doc;
    }


    public static String[] getAllServices (Document doc, String tagName) {
        NodeList allNodes = doc.getElementsByTagName(tagName);
        String[] nodeList = new String[allNodes.getLength()];

        for(int i=0; i<allNodes.getLength(); i++)
        {
            Node serviceNode = allNodes.item(i);
            if(serviceNode.getNodeType() == Node.ELEMENT_NODE)
            {
                Element serviceElement = (Element) serviceNode;
                String serviceName = serviceElement.getTextContent();
                nodeList[i] = serviceName;
            }
        }

        return nodeList;

    }
}
