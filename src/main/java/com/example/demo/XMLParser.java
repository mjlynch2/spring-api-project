package com.example.demo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;

public class XMLParser {

    public static Document getDoc(String url) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL(url).openStream());
        return doc;
    }


    public static JSONArray getAllServices (Document doc, String tagName) {
        NodeList allNodes = doc.getElementsByTagName(tagName);
        String[] nodeList = new String[allNodes.getLength()];
        JSONObject jo = new JSONObject();
        JSONArray jsArr = new JSONArray();

        for(int i=0; i<allNodes.getLength(); i++)
        {
            Node serviceNode = allNodes.item(i);
            if(serviceNode.getNodeType() == Node.ELEMENT_NODE)
            {
                Element serviceElement = (Element) serviceNode;
                String serviceName = serviceElement.getTextContent();
                nodeList[i] = serviceName;
                jo.put(tagName, serviceName);
                jsArr.put(jo.toMap());
            }
        }

        return jsArr;

    }
}
