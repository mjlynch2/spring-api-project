package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

import static com.example.demo.XMLParser.getAllServices;
import static com.example.demo.XMLParser.getDoc;


@RestController
public class Controller {

    public Controller() throws IOException, SAXException, ParserConfigurationException {
    }

    String xmlUrl = "https://data.baltimorecity.gov/api/views/k5ry-ef3g/rows.xml";

    XMLParser xml = new XMLParser();
    Document xmlDoc = xml.getDoc(xmlUrl);



    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @GetMapping("/restaurant/all")
    public Document test() throws IOException, SAXException, ParserConfigurationException {
        return xmlDoc;
    }

    @GetMapping("/restaurant/{tagName}")
    public String[] test2(@PathVariable String tagName) throws IOException, SAXException, ParserConfigurationException {
        XMLParser myXmlDoc = new XMLParser();
        return myXmlDoc.getAllServices(xmlDoc, tagName);
    }
}
