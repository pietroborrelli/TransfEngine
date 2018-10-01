//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.09.23 alle 07:31:07 PM CEST 
//


package it.polimi.mapper.viewcomponent.multipleform;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.polimi.mapper.viewcomponent.multipleform package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DescriptorQueryHQLWhere_QNAME = new QName("", "Where");
    private final static QName _DescriptorFormFieldsFieldSlot_QNAME = new QName("", "Slot");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.polimi.mapper.viewcomponent.multipleform
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Descriptor }
     * 
     */
    public Descriptor createDescriptor() {
        return new Descriptor();
    }

    /**
     * Create an instance of {@link Descriptor.FormFields }
     * 
     */
    public Descriptor.FormFields createDescriptorFormFields() {
        return new Descriptor.FormFields();
    }

    /**
     * Create an instance of {@link Descriptor.FormFields.Field }
     * 
     */
    public Descriptor.FormFields.Field createDescriptorFormFieldsField() {
        return new Descriptor.FormFields.Field();
    }

    /**
     * Create an instance of {@link Descriptor.Query }
     * 
     */
    public Descriptor.Query createDescriptorQuery() {
        return new Descriptor.Query();
    }

    /**
     * Create an instance of {@link Descriptor.Query.HQL }
     * 
     */
    public Descriptor.Query.HQL createDescriptorQueryHQL() {
        return new Descriptor.Query.HQL();
    }

    /**
     * Create an instance of {@link Descriptor.FormFields.Field.Slot }
     * 
     */
    public Descriptor.FormFields.Field.Slot createDescriptorFormFieldsFieldSlot() {
        return new Descriptor.FormFields.Field.Slot();
    }

    /**
     * Create an instance of {@link Descriptor.Query.Input }
     * 
     */
    public Descriptor.Query.Input createDescriptorQueryInput() {
        return new Descriptor.Query.Input();
    }

    /**
     * Create an instance of {@link Descriptor.Query.HQL.Where }
     * 
     */
    public Descriptor.Query.HQL.Where createDescriptorQueryHQLWhere() {
        return new Descriptor.Query.HQL.Where();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Descriptor.Query.HQL.Where }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Where", scope = Descriptor.Query.HQL.class)
    public JAXBElement<Descriptor.Query.HQL.Where> createDescriptorQueryHQLWhere(Descriptor.Query.HQL.Where value) {
        return new JAXBElement<Descriptor.Query.HQL.Where>(_DescriptorQueryHQLWhere_QNAME, Descriptor.Query.HQL.Where.class, Descriptor.Query.HQL.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Descriptor.FormFields.Field.Slot }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Slot", scope = Descriptor.FormFields.Field.class)
    public JAXBElement<Descriptor.FormFields.Field.Slot> createDescriptorFormFieldsFieldSlot(Descriptor.FormFields.Field.Slot value) {
        return new JAXBElement<Descriptor.FormFields.Field.Slot>(_DescriptorFormFieldsFieldSlot_QNAME, Descriptor.FormFields.Field.Slot.class, Descriptor.FormFields.Field.class, value);
    }

}
