package com.imooc.domtest.saxtest;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by chen on 2017/7/22.
 */
public class SAXParserHandler extends DefaultHandler{
    int bookIndex = 0;
    //标识解析开始
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SAX解析开始");
    }

    //标识解析结束
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("SAX解析结束");
    }

    //解析xml元素开始
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        //开始解析book元素属性
        if(qName.equals("book")){
            bookIndex++;
            System.out.println("———开始遍历第"+bookIndex+"本书————");
//            //已知book元素下属性的名称，根据属性名称获取属性值
//            String value = attributes.getValue("id");
//            System.out.println("book的属性值是："+value);

            //不知道book元素下属性的名称以及个数，如何获取属性名以及属性值
            int num = attributes.getLength();
            for(int i = 0;i<num;i++){
                System.out.print("book元素的第"+(i+1)+"个属性名是："+attributes.getQName(i));
                System.out.println(" 属性值是："+attributes.getValue(i));
            }
        }else if(!qName.equals("bookstore")){
            System.out.print("节点名是：" + qName+"----");
        }
    }



    //解析xml元素结束
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        //判断是否针对一本书已经遍历结束
        if(qName.equals("book")){
            System.out.println("——结束遍历第"+bookIndex+"本书——");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch,start,length);
        if(!value.trim().equals("")) {
            System.out.println("节点值是："+value);
        }
    }
}
