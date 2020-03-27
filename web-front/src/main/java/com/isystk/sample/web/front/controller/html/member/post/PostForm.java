package com.isystk.sample.web.front.controller.html.member.post;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.isystk.sample.web.base.controller.html.BaseForm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostForm extends BaseForm {

    private static final long serialVersionUID = 7593564324192730932L;

    Integer postId;

    @NotNull
    Integer userId;

    @NotEmpty
    String title;

    @NotEmpty
    String text;

	@Override
	public Integer getId() {
		return postId;
	}

}