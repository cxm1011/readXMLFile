package com.imooc.domtest;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by chen on 2017/7/20.
 */
public class DOMTest {
    public static void main(String[] args) {
        //创建DoucmentBuilderFactory的对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //创建DoucmentBuilder对象
        try {
            //创建DocumentBuilder对象
            DocumentBuilder db = dbf.newDocumentBuilder();
            //通过DocumentBuilder对象的parse方法加载book.xml文件到当前路径下
            Document document = db.parse("book.xml");

            //获取所有book节点
            NodeList bookList = document.getElementsByTagName("book");
            System.out.println("book节点个数：" + bookList.getLength());
            //遍历每一个book节点
            for (int i = 0; i < bookList.getLength(); i++) {
                //（1）不知道book的节点名
//                Node bookNode = bookList.item(i);
//                //获取book节点的所有属性集合
//                NamedNodeMap bookNodeMap = bookNode.getAttributes();
//                System.out.println("第" + (i + 1) + "本book共有" + bookNodeMap.getLength() + "个属性");
//                for (int j = 0; j < bookNodeMap.getLength(); j++) {
//
//                    Node node = bookNodeMap.item(j);
//                    System.out.print("属性名："+node.getNodeName());
//                    System.out.println("属性值："+node.getNodeValue());
//                }

                //(2)前提知道book有且只有一个id属性 测试
                Element book = (Element)bookList.item(i);
                String bookVal = book.getAttribute("id");


                System.out.println("id的属性值为："+bookVal);

            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
