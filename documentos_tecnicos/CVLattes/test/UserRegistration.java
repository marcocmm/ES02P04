/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import model.Credential;
import model.Document;
import model.Institute;
import model.InstituteName;
import model.Language;
import model.Person;
import model.PersonName;
import model.Role;
import model.adress.Address;
import model.adress.AddressType;
import model.adress.City;
import model.adress.Country;
import model.adress.State;
import model.adress.StreetType;
import org.junit.Test;

/**
 *
 * @author marco
 */
public class UserRegistration {
    
    public UserRegistration() {
    }
    Date d = new Date(2016, 11, 22);
    Country country = new Country("Brasil", "BR");
    State s = new State("Paraná", "PR", country);
    City city = new City("Campo Mourao", s);

    Address a = new Address(d, d, AddressType.Trabalho, city, StreetType.Avenida, "Via rosalina", 0, 0, "n");
    
    Credential c = new Credential("login", "senha");

    PersonName pn = new PersonName("Romulo");
    String cpf = "123.123.123-88";
    Person p = new Person(pn, c, cpf);
    
    InstituteName in = new InstituteName("UTFPR");
    String cnpj = "22.369.258/0001-55";
    Institute i = new Institute(c, in, cnpj);
    
    Language l = new Language();
    Map<Person,Role> m = new HashMap<Person,Role>() {};
    
    
    Document doc = new Document(m, "Trabalho", 2000, l);
    @Test
    public void instacias(){
      p.addAddress(a);
      i.addAddress(a);
      
      
//        i.getCNPJ().assert(cnpj);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
