/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.example.etl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Ein Datensatz eines Kunden, der in ein XML geschrieben oder ausgelesen werden kann
 *
 * @author https://github.com/apache/camel/tree/master/examples/camel-example-etl
 * @author Erceg (serceg@student.tgm.ac.at) (Kommentare)
 * @author Kritzl (mkritzl@student.tgm.ac.at) (Kommentare)
 * @version 20150219
 */

//Name des Eintrags
@Entity(name = "customer")
//Root-Element in dem XML-File
@XmlRootElement(name = "customer")
//Spezifiziert, dass Felder serialisiert werden sollen
@XmlAccessorType(XmlAccessType.FIELD)
//Beschreibt, wie der Kunde anhand seines Namens aus der Datenbank ausgelesen werden kann
@NamedQuery(name = "findCustomerByUsername", query = "SELECT c FROM customer c WHERE c.userName = :userName")
public class CustomerEntity {
    //Attribute des XML-Files
    @XmlAttribute
    private Long id;

    private String userName;
    private String firstName;
    private String surname;
    private String street;
    private String city;
    private String zip;
    private String phone;

    //Definition eine Id, dessen Wert automatisch generiert wird
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String toString() {
        return "Customer[userName: " + getUserName() + " firstName: " + getFirstName() + " surname: " + getSurname() + "]";
    }

}