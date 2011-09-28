package com.eharmony.lightning;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eharmony.lightning.User;
import com.eharmony.lightning.ZipCodeLookup;

public class ZipCodeLookupBuilderTest {

    ZipCodeLookup lookup;

    @Before
    public void setUp() throws Exception {
        lookup = new ZipCodeLookup();
    }

    @Test
    public void testUpdateZipCodes() {
        User user = (new User.Builder()).city("Santa Monica").state("CA").build();
        lookup.updateZipCodes(user);
        assertEquals(90404, user.getZipCode());
    }

}
