package io.universe.mallframework.common.api;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * BASE实体
 *
 * @author Sir.D
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity<ID extends Serializable> extends RootEntity<ID> {

    protected Date createAt;

    protected Date updateAt;

}
