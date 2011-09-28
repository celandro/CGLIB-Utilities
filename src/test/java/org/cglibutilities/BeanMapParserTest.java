package org.cglibutilities;


import org.apache.commons.beanutils.Converter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import com.eharmony.lightning.User;
public class BeanMapParserTest {
    BeanMapParser<User> parser;

    @Before
    public void setUp() throws Exception {
        String[] headers = new String[] {"firstName", "lastName", "birthDate", "zipCode" };

        parser = new BeanMapParser<User> (User.class, headers);
        parser.registerConverter(new DateMidnightConverter(), DateTime.class);
    }
    
    private final class DateMidnightConverter implements Converter {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMdd");

        @SuppressWarnings("rawtypes")
        @Override
        public Object convert(Class targetClass, Object arg1) {
            //this returns midnight of local timezone
            return formatter.parseDateTime(arg1.toString());
        }
    }
    @Test
    public void testParse() {
        String line = "John Doe 20110111 90404";
        String delimiter = " ";
        User actual = parser.parse(delimiter, line);
        User expected = (new User.Builder()).firstName("John").lastName("Doe").birthDate(new DateTime(2011,01,11,0,0,0,0)).zipCode(90404).build();
        BeanMapAsserts.assertBeanPropertiesAreEqual(expected, actual);
    }

}
