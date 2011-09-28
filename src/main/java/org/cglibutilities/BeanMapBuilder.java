package org.cglibutilities;

import net.sf.cglib.beans.BeanMap;

public class BeanMapBuilder {
    public static <T> Builder<T> build(Class<T> clazz) {
        return new Builder<T>(clazz);
    }
    public static class Builder<T> {
        private BeanMap beanMap;
        public Builder(Class<T> clazz)  {
            try {
                T bean = clazz.getConstructor().newInstance();
                BeanMap.Generator generator = new BeanMap.Generator();
                generator.setRequire(BeanMap.REQUIRE_SETTER);
                generator.setBean(bean);
                beanMap = generator.create();
            } catch (Exception e) {
                throw new IllegalArgumentException("Could not create a BeanMap for " + clazz.getCanonicalName());
            }
        }
        public Builder<T> set(String property, Object value) {
            beanMap.put(property, value);
            return this;
        }
        
        @SuppressWarnings("unchecked")
        public T build() {
            return (T) beanMap.getBean();
        }
    }

}
