package com.imooc.domtest.saxtest;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by chen on 2017/7/22.
 */
public class SAXTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //获取一个SAXParserFactory的实例
        SAXParserFactory factory = SAXParserFactory.newInstance();

        //通过factory获取SAXParser实例
        SAXParser parser = factory.newSAXParser();
        SAXParserHandler handler = new SAXParserHandler();

        parser.parse("book.xml",handler);
    }
}
