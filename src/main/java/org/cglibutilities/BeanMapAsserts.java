package org.cglibutilities;
import static org.junit.Assert.assertEquals;

import java.util.Map;

import net.sf.cglib.beans.BeanMap;

public class BeanMapAsserts {
    public static void assertBeanPropertiesAreEqual(Object expected, Object actual) {
        Map<String, Object> expectedMap = BeanMap.create(expected);
        Map<String, Object> actualMap = BeanMap.create(actual);
        assertEquals("Objects had different number of properties", expectedMap.size(), actualMap.size());
        for (Map.Entry<String, Object> entry : expectedMap.entrySet()) {
            assertEquals(entry.getKey() + " was not equal", entry.getValue(), actualMap.get(entry.getKey()));
        }

    }

}
