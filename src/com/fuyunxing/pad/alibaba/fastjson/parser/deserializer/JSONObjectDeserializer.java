package com.fuyunxing.pad.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

import com.fuyunxing.pad.alibaba.fastjson.parser.DefaultExtJSONParser;
import com.fuyunxing.pad.alibaba.fastjson.parser.JSONToken;

public class JSONObjectDeserializer implements ObjectDeserializer {
    public final static JSONObjectDeserializer instance = new JSONObjectDeserializer();

    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultExtJSONParser parser, Type clazz) {
        return (T) parser.parseObject();
    }

    public int getFastMatchToken() {
        return JSONToken.LBRACE;
    }
}
