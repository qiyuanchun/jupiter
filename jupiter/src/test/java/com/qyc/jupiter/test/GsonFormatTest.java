package com.qyc.jupiter.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class GsonFormatTest implements Serializable {



    @JsonProperty("userName")
    private String userName;
    @JsonProperty("age")
    private Integer age;

/**
 * {
 * "userName":"jack",
 *   "age":18
 *
 * }
 */

}
