package com.fuyunxing.pad.framework.db.table;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import com.fuyunxing.pad.framework.db.utils.DateTimeUtil;

/**
 * bean 中每个属性 构建一个Property
 * @author chensf5
 *
 */
public class Property {

	private String fieldName;  //bean 属性名字符串
	private String column;  //sqlite 字段名
	private String defaultValue; //注解时的默认值 
	private Class<?> dataType;
	
	private Method set;
	private Method get;
	
	public void setValue(Object receiver,Object value){
		if(null != set && null != value){
			try{
				if(String.class == dataType){
					set.invoke(receiver, value.toString());
				}else if( int.class == dataType || Integer.class == dataType ){
					set.invoke(receiver, value == null ? (Integer) null : Integer.parseInt(value.toString()));
				}else if (dataType == float.class || dataType == Float.class) {
					set.invoke(receiver, value == null ? (Float) null: Float.parseFloat(value.toString()));
				} else if (dataType == double.class || dataType == Double.class) {
					set.invoke(receiver, value == null ? (Double) null: Double.parseDouble(value.toString()));
				} else if (dataType == long.class || dataType == Long.class) {
					set.invoke(receiver, value == null ? (Long) null: Long.parseLong(value.toString()));
				} else if (dataType == java.util.Date.class || dataType == java.sql.Date.class) {
					set.invoke(receiver, value == null ? (Date) null: DateTimeUtil.stringToDateTime(value.toString()));
				} else {
					set.invoke(receiver, value);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public <T> T getValue(Object obj){
		if(null != obj && null != get){
			try {
				return (T)get.invoke(obj);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public Class<?> getDataType() {
		return dataType;
	}

	public void setDataType(Class<?> dataType) {
		this.dataType = dataType;
	}

	public Method getSet() {
		return set;
	}

	public void setSet(Method set) {
		this.set = set;
	}

	public Method getGet() {
		return get;
	}

	public void setGet(Method get) {
		this.get = get;
	}
	
	
	
}
