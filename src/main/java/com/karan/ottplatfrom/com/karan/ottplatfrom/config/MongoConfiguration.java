package com.karan.ottplatfrom.com.karan.ottplatfrom.config;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.context.annotation.Configuration;
import java.sql.Timestamp;
import java.util.Date;

@Configuration
public class MongoConfiguration  implements  Converter<Date, Timestamp>{
    /**
     * Main conversion method.
     *
     * @param value
     */
    @Override
    public Timestamp convert(Date value) {
        return new Timestamp(value.getTime());
    }

    /**
     * Method that can be used to find out actual input (source) type; this
     * usually can be determined from type parameters, but may need
     * to be implemented differently from programmatically defined
     * converters (which cannot change static type parameter bindings).
     *
     * @param typeFactory
     * @since 2.2
     */
    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    /**
     * Method that can be used to find out actual output (target) type; this
     * usually can be determined from type parameters, but may need
     * to be implemented differently from programmatically defined
     * converters (which cannot change static type parameter bindings).
     *
     * @param typeFactory
     * @since 2.2
     */
    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }
}
