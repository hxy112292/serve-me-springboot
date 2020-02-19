package edu.uta.serveme.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Maps;
import edu.uta.serveme.constant.Constant;
import edu.uta.serveme.utils.JsonUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

/**
 * @author housirvip
 */
@Getter
@Setter
@ToString
public class PageDto implements Serializable {

    private Integer pageNum;

    private Integer pageSize;

    private String param;

    @JsonIgnore
    private Map<String, Object> paramAsMap = Maps.newHashMap();

    public PageDto putUid(Integer uid) {

        paramAsMap.put(Constant.UID, uid);

        return this;
    }

    public PageDto putDisable() {

        paramAsMap.put(Constant.ENABLE, Boolean.FALSE);

        return this;
    }

    public PageDto putParam() {

        Optional.ofNullable(JsonUtils.convertToMap(param, String.class, Object.class))
                .ifPresent(map -> paramAsMap.putAll(map));

        return this;
    }
}
