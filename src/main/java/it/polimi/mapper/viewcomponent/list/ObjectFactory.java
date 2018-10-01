//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.09.18 alle 08:08:13 PM CEST 
//


package it.polimi.mapper.viewcomponent.list;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.polimi.mapper.viewcomponent.list package. 
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

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.polimi.mapper.viewcomponent.list
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
     * Create an instance of {@link Descriptor.SortAttributes }
     * 
     */
    public Descriptor.SortAttributes createDescriptorSortAttributes() {
        return new Descriptor.SortAttributes();
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
     * Create an instance of {@link Descriptor.Results }
     * 
     */
    public Descriptor.Results createDescriptorResults() {
        return new Descriptor.Results();
    }

    /**
     * Create an instance of {@link Descriptor.SortAttributes.Attribute }
     * 
     */
    public Descriptor.SortAttributes.Attribute createDescriptorSortAttributesAttribute() {
        return new Descriptor.SortAttributes.Attribute();
    }

    /**
     * Create an instance of {@link Descriptor.Query.Input }
     * 
     */
    public Descriptor.Query.Input createDescriptorQueryInput() {
        return new Descriptor.Query.Input();
    }

    /**
     * Create an instance of {@link Descriptor.Query.Output }
     * 
     */
    public Descriptor.Query.Output createDescriptorQueryOutput() {
        return new Descriptor.Query.Output();
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

}
