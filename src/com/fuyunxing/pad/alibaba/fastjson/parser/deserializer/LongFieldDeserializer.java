package com.fuyunxing.pad.alibaba.fastjson.parser.deserializer;

import com.fuyunxing.pad.alibaba.fastjson.parser.DefaultExtJSONParser;
import com.fuyunxing.pad.alibaba.fastjson.parser.JSONLexer;
import com.fuyunxing.pad.alibaba.fastjson.parser.JSONToken;
import com.fuyunxing.pad.alibaba.fastjson.parser.ParserConfig;
import com.fuyunxing.pad.alibaba.fastjson.util.FieldInfo;
import com.fuyunxing.pad.alibaba.fastjson.util.TypeUtils;

public class LongFieldDeserializer extends FieldDeserializer {

    private final ObjectDeserializer fieldValueDeserilizer;

    public LongFieldDeserializer(ParserConfig mapping, Class<?> clazz, FieldInfo fieldInfo){
        super(clazz, fieldInfo);

        fieldValueDeserilizer = mapping.getDeserializer(fieldInfo);
    }

    @Override
    public void parseField(DefaultExtJSONParser parser, Object object) {
        Long value;
        
        final JSONLexer lexer = parser.getLexer();
        if (lexer.token() == JSONToken.LITERAL_INT) {
            long val = lexer.longValue();
            lexer.nextToken(JSONToken.COMMA);
            setValue(object, val);
            return;
        } else if (lexer.token() == JSONToken.NULL) {
            value = null;
            lexer.nextToken(JSONToken.COMMA);
 
        } else {
            Object obj = parser.parse();

            value = TypeUtils.castToLong(obj);
        }
        
        if (value == null && getFieldClass() == long.class) {
            // skip
            return;
        }
        
        setValue(object, value);
    }

    @Override
	public int getFastMatchToken() {
        return fieldValueDeserilizer.getFastMatchToken();
    }
}
