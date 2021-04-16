package io.universe.mallframework.common.api;

import lombok.NoArgsConstructor;

/**
 * 字段转换
 *
 * @author Sir.D
 */
@NoArgsConstructor
public abstract class EntityFieldTypeConvertor {
    protected static EntityFieldTypeConvertor instance;
    public static EntityFieldTypeConvertor instance() {
        return instance;
    }

    /**
     * 转换
     */
    public abstract <T> T convert(String fieldName, Object value, Class<?> modelClass);

}
