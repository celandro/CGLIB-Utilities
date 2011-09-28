package com.eharmony.lightning;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eharmony.lightning.User;
import com.eharmony.lightning.ZipCodeLookup;

public class ZipCodeLookupTest {

    ZipCodeLookup lookup;

    @Before
    public void setUp() throws Exception {
        lookup = new ZipCodeLookup();
    }

    @Test
    public void testUpdateZipCodes() {
        User user = new User();
        user.setCity("Santa Monica");
        user.setState("CA");
        lookup.updateZipCodes(user);
        assertEquals(90404, user.getZipCode());
    }

}
