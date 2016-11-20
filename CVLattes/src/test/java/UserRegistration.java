/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
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
    Person p = new Person(pn, c);
    
    InstituteName in = new InstituteName("UTFPR");
    String cnpj = "22.369.258/0001-55";
    Institute i = new Institute(c, in);
    
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
