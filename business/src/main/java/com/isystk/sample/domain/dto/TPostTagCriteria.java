package com.isystk.sample.domain.dto;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TPostTagCriteria {


    Integer postIdEqual;
    Integer postIdNotEqual;
    boolean postIdIsNull;
    boolean postIdIsNotNull;
    List<Integer> postIdIn;
    List<Integer> postIdNotIn;

    Integer postTagIdEqual;
    Integer postTagIdNotEqual;
    boolean postTagIdIsNull;
    boolean postTagIdIsNotNull;
    List<Integer> postTagIdIn;
    List<Integer> postTagIdNotIn;
}