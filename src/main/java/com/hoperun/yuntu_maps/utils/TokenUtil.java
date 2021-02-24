package com.hoperun.yuntu_maps.utils;

//jwt框架相关类
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
//jre
import java.util.Date;
//用户业务
import com.hoperun.yuntu_maps.entities.UserInfo;

public class TokenUtil {

	private static final long EXPIRE_TIME= 10*60*60*1000;
	private static final String TOKEN_SECRET="yuntu_maps";  //密钥盐
	
	/**
	 * 生成签名
	 * @param user
	 * @return
	 */
	public static String sign(UserInfo user){
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("username", user.getName())
                    .withExpiresAt(expiresAt)                  
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));  // 使用了HMAC256加密算法。
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

	/**
     * 签名验证
     * @param token
     * @return
     */
    public static boolean verify(String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("username: " + jwt.getClaim("username").asString());
            System.out.println("过期时间：      " + jwt.getExpiresAt());
            return true;
        } catch (Exception e){
            return false;
        }
    }
}