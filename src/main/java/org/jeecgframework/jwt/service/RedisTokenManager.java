package org.jeecgframework.jwt.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.jeecgframework.jwt.def.JwtConstants;
import org.jeecgframework.jwt.model.TokenModel;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.jeecg.wechat.entity.OpenIdTokenModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 通过Redis存储和验证token的实现类
 * 
 * @author ScienJus
 * @date 2015/7/31.
 */
@Component
public class RedisTokenManager implements TokenManager {

	Logger logger = LoggerFactory.getLogger(RedisTokenManager.class);

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Override
	public String createToken(TSUser user) {
		// 使用uuid作为源token
		String token = Jwts.builder().setId(user.getUserName()).setSubject(user.getUserName()).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, JwtConstants.JWT_SECRET).compact();
		// 存储到redis并设置过期时间
		logger.info("存储到Redis - User = " + user.getUserName());
		redisTemplate.boundValueOps(user.getUserName()).set(token, JwtConstants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
		return token;
	}

	@Override
	public String getTokenByUser(String userName) {
		return redisTemplate.opsForValue().get(userName);
	}

	@Override
	public TokenModel getToken(String token, String userId) {
		return new TokenModel(userId, token);
	}

	@Override
	public boolean checkToken(TokenModel model) {
		if (model == null) {
			return false;
		}
		String token = redisTemplate.boundValueOps(model.getUsername()).get();
		if (token == null || !token.equals(model.getToken())) {
			return false;
		}
		// 如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
		redisTemplate.boundValueOps(model.getUsername()).expire(JwtConstants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
		return true;
	}

	@Override
	public void deleteToken(String username) {
		logger.info("删除Token - User = " + username);
		redisTemplate.delete(username);
	}

	@Override
	public String createOpenIdToken(String openid) {
		// 使用uuid作为源token
		String token = Jwts.builder().setId(openid).setSubject(openid).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, JwtConstants.JWT_SECRET).compact();
		// 存储到redis并设置过期时间
		logger.info("存储到Redis - openid = " + openid + ";存储到Redis - token = " + token);

		redisTemplate.boundValueOps(openid).set(token, JwtConstants.XCX_TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);

		return token;
	}

	@Override
	public String getTokenByOpenId(String openid) {
		return redisTemplate.opsForValue().get(openid);
	}

	@Override
	public OpenIdTokenModel getOpenIdToken(String token, String openid) {
		return new OpenIdTokenModel(openid, token);
	}

	@Override
	public boolean checkOpenIdToken(OpenIdTokenModel model) {
		if (model == null) {
			return false;
		}
		String token = redisTemplate.boundValueOps(model.getOpenid()).get();
		if (token == null || !token.equals(model.getToken())) {
			return false;
		}
		// 如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
		redisTemplate.boundValueOps(model.getOpenid()).expire(JwtConstants.XCX_TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
		return true;
	}

	@Override
	public void deleteOpenIdToken(String openid) {
		logger.info("删除Token - User = " + openid);
		redisTemplate.delete(openid);
	}
}
