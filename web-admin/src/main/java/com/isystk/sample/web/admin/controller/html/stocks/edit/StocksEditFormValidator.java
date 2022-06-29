package com.isystk.sample.web.admin.controller.html.stocks.edit;

import com.isystk.sample.common.validator.AbstractValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * 商品 入力チェック
 */
@Component
public class StocksEditFormValidator extends AbstractValidator<StocksEditForm> {

  @Override
  protected void doValidate(StocksEditForm form, Errors errors) {
  }
}