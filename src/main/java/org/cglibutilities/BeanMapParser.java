package org.cglibutilities;

import java.lang.reflect.Constructor;

import net.sf.cglib.beans.BeanMap;

import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;

public class BeanMapParser<T> {

    protected final BeanMap beanMap;
    protected final String[] headers;
    protected final ConvertUtilsBean converters;
    protected final Constructor<T> constructor;

    public BeanMapParser(Class<T> clazz, String[] headers) {
        BeanMap.Generator generator = new BeanMap.Generator();
        generator.setRequire(BeanMap.REQUIRE_SETTER);
        generator.setBeanClass(clazz);
        this.beanMap = generator.create();

        this.headers = headers;
        this.converters = new ConvertUtilsBean();
        try {
            constructor = clazz.getConstructor();
        } catch (SecurityException e) {
            throw new IllegalArgumentException("Could not get constructor", e);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("No argument constructor is required for " + clazz.getCanonicalName());
        }
    }

    /* (non-Javadoc)
     * @see com.eharmony.matching.commagg.parser.Parser#parse(java.lang.String, java.lang.String)
     */
    @SuppressWarnings({ "rawtypes" })
    public T parse(String delim, String line) {

        String[] elements = line.split(delim);

        if (elements.length != headers.length) {
            throw new IllegalArgumentException("Invalid number of properties. Was:" + elements.length + " Expected:"
                            + headers.length);
        }
        final T retval;
        try {
            retval = constructor.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not instantiate instance of "
                            + constructor.getClass().getCanonicalName());
        }

        for (int count = 0; count < headers.length; count++) {
            try {
                Class c = beanMap.getPropertyType(headers[count]);
                Object value = converters.convert(elements[count], c);
                // use the 3 argument put method for thread safety
                beanMap.put(retval, headers[count], value);
            } catch (Exception e) {
                throw new IllegalStateException("Could not set property " + headers[count], e);
            }
        }

        return retval;

    }

    @SuppressWarnings("rawtypes")
    public void registerConverter(Converter converter, Class clazz) {
        this.converters.register(converter, clazz);
    }

}
