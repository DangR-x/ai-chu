package com.aichu.app.authorization.jwt;

import com.aichu.common.util.auth.manager.TokenValidator;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName JwtTokenValidator
 * @Description JwtTokenValidator
 * @Author Melon
 * @Date 2019/7/18 10:24
 * @Version 1.0.0
 **/
@Component
public class JwtTokenValidator implements TokenValidator {

  @Autowired
  private JwtTokenBuilder jwtTokenBuilder;

  @Autowired
  private JwtConfig jwtConfig;

  @Override
  public boolean validate(String token) {
    // 验证token
    Claims claims = jwtTokenBuilder.decodeToken(token, jwtConfig.getBase64Secret());
    if (claims != null) {
      // 如果token验证成功
      String subject = claims.getSubject();// 用户信息
      return true;
    }
    return false;
  }
}
