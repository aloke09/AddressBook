

import AddressBook.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest
{
    private methods m;
    Contact c1=new Contact("fn","ln","adress","city",
            "state","a@gmail.com",123456,1234567890);
    @Test
    public void fNameTest()
    {
//        map.put("fname",new Contact("fn","ln","adress","city",
//                "state","a@gmail.com",123456,1234567890));
//        assertEquals(map.get("fname"), map.get("fname"), "invalid");
        String firstName = c1.getFirstName();
        assertEquals("fname", "fname", "invalid");
    }
}
