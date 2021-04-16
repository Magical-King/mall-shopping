package io.universe.mallframework.common.api;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

/**
 * ROOT实体
 *
 * @author Sir.D
 */
@JsonIdentityInfo(
    generator = RootEntity.IdxUUIDGenerator.class,
    resolver = RootEntity.RepeatableObjectIdResolver.class
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RootEntity<ID extends Serializable> implements Serializable {

    /**
     * ID
     */
    @TableId(type= IdType.AUTO)
    protected ID id;

    /**
     * 未匹配的反序列化字段
     */
    private Map<String, Object> extendFields = new LinkedHashMap<>();

    @SuppressWarnings("unchecked")
    public <T> T get(String fieldName) {
        return this.extendFields == null ? null : (T) this.extendFields.get(fieldName);
    }

    @SuppressWarnings("unchecked")
    @JsonAnySetter
    public <T> T set(String fieldName, T value) {
        if (Objects.isNull(extendFields)) {
            this.extendFields = new LinkedHashMap<>();
        }

        EntityFieldTypeConvertor convertor = EntityFieldTypeConvertor.instance();
        Object result = value;
        if (Objects.nonNull(convertor)) {
            result = convertor.convert(fieldName, value, this.getClass());
        }
        return (T) this.extendFields.put(fieldName, result);
    }

    @JsonIgnore
    public Map<String, Object> getFields() {
        return this.extendFields;
    }

    @JsonIgnore
    public void setFields(Map<String, Object> extendFields) {
        this.extendFields = extendFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RootEntity<?> that = (RootEntity<?>) o;
        return Objects.equals(id, that.id) && Objects.equals(extendFields, that.extendFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, extendFields);
    }

    /**
     * ID生成器
     */
    @NoArgsConstructor
    public static final class IdxUUIDGenerator extends ObjectIdGenerator<String> {

        @Override
        public Class<?> getScope() {
            return Object.class;
        }

        @Override
        public boolean canUseFor(ObjectIdGenerator<?> generator) {
            return generator.getClass() == this.getClass();
        }

        @Override
        public ObjectIdGenerator<String> forScope(Class<?> scope) {
            return this;
        }

        @Override
        public ObjectIdGenerator<String> newForSerialization(Object o) {
            return this;
        }

        @Override
        public IdKey key(Object key) {
            return key == null ? null : new IdKey(this.getClass(), null, key);
        }

        @Override
        public String generateId(Object o) {
            return UUID.randomUUID().toString();
        }
    }

    @NoArgsConstructor
    public static final class RepeatableObjectIdResolver extends SimpleObjectIdResolver {
        @Override
        public void bindItem(ObjectIdGenerator.IdKey id, Object ob) {
            if (this._items == null) {
                this._items = new HashMap<>(1);
            } else if (this._items.containsKey(id)) {
                return;
            }

            this._items.put(id, ob);
        }

        @Override
        public ObjectIdResolver newForDeserialization(Object context) {
            return  new RepeatableObjectIdResolver();
        }
    }
}
