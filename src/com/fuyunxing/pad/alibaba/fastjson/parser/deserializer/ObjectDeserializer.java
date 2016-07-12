package com.fuyunxing.pad.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

import com.fuyunxing.pad.alibaba.fastjson.parser.DefaultExtJSONParser;

public interface ObjectDeserializer {
    <T> T deserialze(DefaultExtJSONParser parser, Type type);
    
    int getFastMatchToken();
}
