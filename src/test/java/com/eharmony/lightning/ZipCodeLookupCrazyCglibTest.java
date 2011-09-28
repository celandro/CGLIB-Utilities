package com.eharmony.lightning;

import static org.cglibutilities.BeanMapAsserts.assertBeanPropertiesAreEqual;
import static org.cglibutilities.BeanMapBuilder.build;

import org.junit.Before;
import org.junit.Test;

import com.eharmony.lightning.User;
import com.eharmony.lightning.ZipCodeLookup;

public class ZipCodeLookupCrazyCglibTest {

    ZipCodeLookup lookup;

    @Before
    public void setUp() throws Exception {
        lookup = new ZipCodeLookup();
    }

    @Test
    public void testUpdateZipCodes() {
        User actual = build(User.class).set("city", "Santa Monica").set("state", "CA").build();
        lookup.updateZipCodes(actual);
        User expected = build(User.class).set("city", "Santa Monica").set("state", "CA").set("zipCode", 90404).set("zipCode4","90404-1234")
                        .build();
        assertBeanPropertiesAreEqual(expected, actual);
    }

}
