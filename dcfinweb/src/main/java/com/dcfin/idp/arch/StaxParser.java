package com.dcfin.idp.arch;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.dcfin.idp.model.Action;

public class StaxParser {

    public static Map<String, Action> parse(InputStream path) {
        Map<String, Action> actionsMap = new HashMap<String, Action>();
        
        Action action = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(path);
            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    switch (startElement.getName()
                        .getLocalPart()) {
                    case "action":
                        action = new Action();
                        Attribute className = startElement.getAttributeByName(new QName("className"));
                        if (className != null) {
                            action.setClassName(className.getValue());
                        }
                        break;
                    case "name":
                        nextEvent = reader.nextEvent();
                        action.setName(nextEvent.asCharacters().getData());
                        break;
                    case "successPath":
                        nextEvent = reader.nextEvent();
                        action.setSuccessPath(nextEvent.asCharacters().getData());
                        break;
                    case "failurePath":
                        nextEvent = reader.nextEvent();
                        action.setFailurePath(nextEvent.asCharacters().getData());
                        break;
                    }
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    if (endElement.getName()
                        .getLocalPart()
                        .equals("action")) {
                    	actionsMap.put(action.getName(), action);
                    }
                }
            }
        } catch (XMLStreamException xse) {
            System.out.println("XMLStreamException");
            xse.printStackTrace();
        }
        return actionsMap;
    }

}
