package com.aichu.app.authorization.jwt;

import com.alibaba.fastjson.JSON;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.manager.enums.ResultCodeEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName JwtTokenBuilder
 * @Description JWT 处理token的生成、解码
 * @Author Melon
 * @Date 2019/7/18 9:53
 * @Version 1.0.0
 **/
@Component
public class JwtTokenBuilder {

  /**
   * @Author Melon
   * @Description 生成token
   * @Date 9:53 2019/7/18
   * @Param [subject, ttlMillis, base64Secret]
   * @Return java.lang.String
   **/
  @SuppressWarnings("unused")
  public String buildToken(String subject, long ttlMillis, String base64Secret) throws Exception {
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);

    // 生成签名密钥
    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Secret);
    SecretKey key = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

    JwtBuilder builder = Jwts.builder().setIssuedAt(now).setSubject(subject).signWith(signatureAlgorithm, key);

    // 设置token过期时间
    if (ttlMillis >= 0) {
      long expMillis = nowMillis + ttlMillis;
      Date exp = new Date(expMillis);
      // builder.setExpiration(exp).setNotBefore(now);
    }
    return builder.compact();
  }

  /***
   * @Author Melon
   * @Description 解码token
   * @Date 9:54 2019/7/18
   * @Param [jwt, base64Secret]
   * @Return io.jsonwebtoken.Claims
   **/
  public Claims decodeToken(String jwt, String base64Secret) {
    try {
      Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(base64Secret)).parseClaimsJws(jwt)
          .getBody();
      return claims;
    } catch (ExpiredJwtException | SignatureException e) {
    	throw new BusinessException(ResultCodeEnum.TOKEN_DECODE_FAILED.getCode(), ResultCodeEnum.TOKEN_DECODE_FAILED.getMessage());
    } catch (Exception e) {
    	throw new BusinessException(ResultCodeEnum.TOKEN_DECODE_FAILED.getCode(), ResultCodeEnum.TOKEN_DECODE_FAILED.getMessage());
    }
  }

  public static String buildSubject(Map map) {
    String subject = JSON.toJSONString(map);
    return subject;
  }
}
