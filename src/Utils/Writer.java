package Utils;


import Constants.Data;
import model.Root;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Purely read and write the .xml file, if file exist, will replace;
 */
public class Writer {
    JAXBContext jaxbContext;
    Data data = Data.account;

    public Writer(Class... classes){
        try {
            jaxbContext = JAXBContext.newInstance(classes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write(Data data, Root root){
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            QName qName = new QName(data.getName());
            JAXBElement<Root> jaxbElement = new JAXBElement<Root>(qName,Root.class,root);
            marshaller.marshal(jaxbElement,new File(data.getPath()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Object read(Data data){
        try{
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StreamSource xml = new StreamSource(data.getPath());
            return  unmarshaller.unmarshal(xml,Root.class).getValue();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
