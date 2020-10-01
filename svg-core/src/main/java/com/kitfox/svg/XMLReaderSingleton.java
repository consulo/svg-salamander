package com.kitfox.svg;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author VISTALL
 * @since 2020-10-02
 */
class XMLReaderSingleton {
  static SAXParser saxParser;

  static XMLReader getXMLReader() throws SAXException, ParserConfigurationException {
    if (saxParser == null) {
      SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
      saxParserFactory.setNamespaceAware(true);
      saxParser = saxParserFactory.newSAXParser();
    }
    return saxParser.getXMLReader();
  }
}
