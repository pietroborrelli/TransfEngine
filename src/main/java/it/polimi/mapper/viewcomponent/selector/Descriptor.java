//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.09.23 alle 09:58:30 PM CEST 
//


package it.polimi.mapper.viewcomponent.selector;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MaxResults" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Query">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Input" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="param" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="implied" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="expandStyle" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="function" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="attribute" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Output">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="HQL">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Where">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="defaultPolicy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="allImplied" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="entity" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="service" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "maxResults",
    "query"
})
@XmlRootElement(name = "Descriptor")
public class Descriptor {

    @XmlElement(name = "MaxResults", required = true)
    protected String maxResults;
    @XmlElement(name = "Query", required = true)
    protected Descriptor.Query query;
    @XmlAttribute(name = "service")
    protected String service;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Recupera il valore della proprietà maxResults.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxResults() {
        return maxResults;
    }

    /**
     * Imposta il valore della proprietà maxResults.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxResults(String value) {
        this.maxResults = value;
    }

    /**
     * Recupera il valore della proprietà query.
     * 
     * @return
     *     possible object is
     *     {@link Descriptor.Query }
     *     
     */
    public Descriptor.Query getQuery() {
        return query;
    }

    /**
     * Imposta il valore della proprietà query.
     * 
     * @param value
     *     allowed object is
     *     {@link Descriptor.Query }
     *     
     */
    public void setQuery(Descriptor.Query value) {
        this.query = value;
    }

    /**
     * Recupera il valore della proprietà service.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getService() {
        return service;
    }

    /**
     * Imposta il valore della proprietà service.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setService(String value) {
        this.service = value;
    }

    /**
     * Recupera il valore della proprietà name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il valore della proprietà name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Input" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="param" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="implied" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="expandStyle" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="function" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="attribute" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Output">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="HQL">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Where">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="defaultPolicy" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="allImplied" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="entity" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "input",
        "output",
        "hql"
    })
    public static class Query {

        @XmlElement(name = "Input")
        protected List<Descriptor.Query.Input> input;
        @XmlElement(name = "Output", required = true)
        protected Descriptor.Query.Output output;
        @XmlElement(name = "HQL", required = true)
        protected Descriptor.Query.HQL hql;
        @XmlAttribute(name = "entity")
        protected String entity;

        /**
         * Gets the value of the input property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the input property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInput().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Descriptor.Query.Input }
         * 
         * 
         */
        public List<Descriptor.Query.Input> getInput() {
            if (input == null) {
                input = new ArrayList<Descriptor.Query.Input>();
            }
            return this.input;
        }

        /**
         * Recupera il valore della proprietà output.
         * 
         * @return
         *     possible object is
         *     {@link Descriptor.Query.Output }
         *     
         */
        public Descriptor.Query.Output getOutput() {
            return output;
        }

        /**
         * Imposta il valore della proprietà output.
         * 
         * @param value
         *     allowed object is
         *     {@link Descriptor.Query.Output }
         *     
         */
        public void setOutput(Descriptor.Query.Output value) {
            this.output = value;
        }

        /**
         * Recupera il valore della proprietà hql.
         * 
         * @return
         *     possible object is
         *     {@link Descriptor.Query.HQL }
         *     
         */
        public Descriptor.Query.HQL getHQL() {
            return hql;
        }

        /**
         * Imposta il valore della proprietà hql.
         * 
         * @param value
         *     allowed object is
         *     {@link Descriptor.Query.HQL }
         *     
         */
        public void setHQL(Descriptor.Query.HQL value) {
            this.hql = value;
        }

        /**
         * Recupera il valore della proprietà entity.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEntity() {
            return entity;
        }

        /**
         * Imposta il valore della proprietà entity.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEntity(String value) {
            this.entity = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Where">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="defaultPolicy" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="allImplied" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "content"
        })
        public static class HQL {

            @XmlElementRef(name = "Where", type = JAXBElement.class)
            @XmlMixed
            protected List<Serializable> content;

            /**
             * Gets the value of the content property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the content property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getContent().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link JAXBElement }{@code <}{@link Descriptor.Query.HQL.Where }{@code >}
             * {@link String }
             * 
             * 
             */
            public List<Serializable> getContent() {
                if (content == null) {
                    content = new ArrayList<Serializable>();
                }
                return this.content;
            }


            /**
             * <p>Classe Java per anonymous complex type.
             * 
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="defaultPolicy" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="allImplied" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Where {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "defaultPolicy")
                protected String defaultPolicy;
                @XmlAttribute(name = "allImplied")
                protected String allImplied;

                /**
                 * Recupera il valore della proprietà value.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Imposta il valore della proprietà value.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Recupera il valore della proprietà defaultPolicy.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDefaultPolicy() {
                    return defaultPolicy;
                }

                /**
                 * Imposta il valore della proprietà defaultPolicy.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDefaultPolicy(String value) {
                    this.defaultPolicy = value;
                }

                /**
                 * Recupera il valore della proprietà allImplied.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAllImplied() {
                    return allImplied;
                }

                /**
                 * Imposta il valore della proprietà allImplied.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAllImplied(String value) {
                    this.allImplied = value;
                }

            }

        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="param" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="implied" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="expandStyle" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="function" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="attribute" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Input {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "id")
            protected String id;
            @XmlAttribute(name = "param")
            protected String param;
            @XmlAttribute(name = "type")
            protected String type;
            @XmlAttribute(name = "implied")
            protected String implied;
            @XmlAttribute(name = "expandStyle")
            protected String expandStyle;
            @XmlAttribute(name = "function")
            protected String function;
            @XmlAttribute(name = "attribute")
            protected String attribute;

            /**
             * Recupera il valore della proprietà value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Imposta il valore della proprietà value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Recupera il valore della proprietà id.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getId() {
                return id;
            }

            /**
             * Imposta il valore della proprietà id.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setId(String value) {
                this.id = value;
            }

            /**
             * Recupera il valore della proprietà param.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getParam() {
                return param;
            }

            /**
             * Imposta il valore della proprietà param.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setParam(String value) {
                this.param = value;
            }

            /**
             * Recupera il valore della proprietà type.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * Imposta il valore della proprietà type.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }

            /**
             * Recupera il valore della proprietà implied.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getImplied() {
                return implied;
            }

            /**
             * Imposta il valore della proprietà implied.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setImplied(String value) {
                this.implied = value;
            }

            /**
             * Recupera il valore della proprietà expandStyle.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getExpandStyle() {
                return expandStyle;
            }

            /**
             * Imposta il valore della proprietà expandStyle.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setExpandStyle(String value) {
                this.expandStyle = value;
            }

            /**
             * Recupera il valore della proprietà function.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFunction() {
                return function;
            }

            /**
             * Imposta il valore della proprietà function.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFunction(String value) {
                this.function = value;
            }

            /**
             * Recupera il valore della proprietà attribute.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAttribute() {
                return attribute;
            }

            /**
             * Imposta il valore della proprietà attribute.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAttribute(String value) {
                this.attribute = value;
            }

        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Output {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "id")
            protected String id;
            @XmlAttribute(name = "name")
            protected String name;
            @XmlAttribute(name = "index")
            protected Byte index;

            /**
             * Recupera il valore della proprietà value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Imposta il valore della proprietà value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Recupera il valore della proprietà id.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getId() {
                return id;
            }

            /**
             * Imposta il valore della proprietà id.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setId(String value) {
                this.id = value;
            }

            /**
             * Recupera il valore della proprietà name.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Imposta il valore della proprietà name.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Recupera il valore della proprietà index.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getIndex() {
                return index;
            }

            /**
             * Imposta il valore della proprietà index.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setIndex(Byte value) {
                this.index = value;
            }

        }

    }

}
