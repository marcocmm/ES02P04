/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.cvlattes.controller.LoggableController;
import br.com.cvlattes.controller.exception.ItemNotFoundException;
import br.com.cvlattes.model.Credential;
import br.com.cvlattes.model.Document;
import br.com.cvlattes.model.Institute;
import br.com.cvlattes.model.InstituteName;
import br.com.cvlattes.model.Language;
import br.com.cvlattes.model.Person;
import br.com.cvlattes.model.PersonName;
import br.com.cvlattes.model.Role;
import br.com.cvlattes.model.adress.Address;
import br.com.cvlattes.model.adress.AddressType;
import br.com.cvlattes.model.adress.City;
import br.com.cvlattes.model.adress.State;
import br.com.cvlattes.model.adress.Country;
import br.com.cvlattes.model.adress.StreetType;
import br.com.cvlattes.persistence.LoggablePersistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author marco
 */
public class UserRegistration {

    Date d;
    Country country;
    State s;
    City city;
    Address a;
    Credential c;
    PersonName pn;
    String cpf;
    Person p;
    Person pr;
    InstituteName in;
    String cnpj;
    Institute i;
    Language l;
    Document doc;
    LoggablePersistence loggablePersistence;
    LoggableController loggableController;

    public UserRegistration() {
        d = new Date(2016, 11, 22);
        country = new Country("Brasil", "BR");
        s = new State("Paraná", "PR", country);
        city = new City("Campo Mourao", s);

        a = new Address(d, d, AddressType.Trabalho, city, StreetType.Avenida, "Via rosalina", 0, 0, "n");

        c = new Credential("login", "senha");

        pn = new PersonName("Romulo");
        cpf = "123.123.123-88";
        p = new Person(pn, c);

        in = new InstituteName("UTFPR");
        cnpj = "22.369.258/0001-55";
        i = new Institute(in, c);

        l = new Language();
        Map<Person, Role> m = new HashMap<Person, Role>() {
        };

        doc = new Document(m, "Trabalho", 2000, l);

        loggablePersistence = new LoggablePersistence();
        loggableController = new LoggableController(loggablePersistence);

    }

    @Test
    public void instacias() throws ItemNotFoundException {
        p.addAddress(a);
        i.addAddress(a);
        Assert.assertEquals(((ArrayList<Address>) p.getAddress()).get(0).getCity().getName(), "Campo Mourao");
        loggableController.add(p);

        pr = (Person) loggableController.get(p);
        Assert.assertEquals(p, pr);
        Assert.assertEquals(((ArrayList<Address>) pr.getAddress()).get(0).getCity().getName(), "Campo Mourao");
        loggableController.remove(p);
        Assert.assertEquals(((ArrayList<Address>) pr.getAddress()).get(0).getCity().getName(), "Campo Mourao");
        try {
            pr = (Person) loggableController.get(p);
        } catch (ItemNotFoundException e) {
            System.out.println(e);
        }
//        i.getCNPJ().assert(cnpj);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
