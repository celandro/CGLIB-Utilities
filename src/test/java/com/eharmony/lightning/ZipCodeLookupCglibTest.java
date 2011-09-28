package com.eharmony.lightning;

import static org.cglibutilities.BeanMapAsserts.assertBeanPropertiesAreEqual;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eharmony.lightning.User;
import com.eharmony.lightning.ZipCodeLookup;

public class ZipCodeLookupCglibTest {

    ZipCodeLookup lookup;

    @Before
    public void setUp() throws Exception {
        lookup = new ZipCodeLookup();
    }

    @Test
    public void testUpdateZipCodes() {
        User actual = (new User.Builder()).city("Santa Monica").state("CA").build();
        lookup.updateZipCodes(actual);
        User expected = (new User.Builder()).city("Santa Monica").state("CA").zipCode(90404).zipCode4("90404-1234")
                        .build();
        assertBeanPropertiesAreEqual(expected, actual);
    }

}
