//package com.example.notepro.util;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.TimeUnit;
//
//@Component
//public class JwtUtils {
//
//    //@Autowired
//    //private RedisTemplate<String, String> redisTemplate;
//
//    private Map<String,String> tokenStore = new ConcurrentHashMap<>();
//
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.expiration}")
//    private  long expiration;
//
//    /**
//     * 生成token
//     * @Param email
//     * @return
//     */
//    public  String generateToken(String email) {
//        String token = Jwts.builder()
//                .setSubject(email)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//
//        // 将 Token 存储到 Redis 中
//        //redisTemplate.opsForValue().set(email, token, expiration, TimeUnit.MILLISECONDS);
//        tokenStore.put(email,token);
//        return token;
//    }
//
//    /**
//     * 验证token
//     * @param token
//     * @return
//     */
//    public boolean validateToken(String token) {
//        // 从 Token 中获取用户名
//        String email = getEmailFromToken(token);
//
//        // 从 Redis 中获取存储的 Token
//        //String storedToken = redisTemplate.opsForValue().get(email);
//        String storedToken = tokenStore.get(email);
//        return storedToken != null && storedToken.equals(token);
//        // 判断 Redis 中存储的 Token 是否与传入的 Token 相同
//        //return storedToken != null && storedToken.equals(token);
//    }
//
//    /**
//     * 删除token
//     * @param email
//     */
//    public void removeToken(String email) {
//        // 从 Redis 中删除 Token
//        //redisTemplate.delete(email);
//    }
//
//    /**
//     * 根据token获取用户信息
//     * @param token
//     * @return
//     */
//    public String getEmailFromToken(String token) {
//        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//        Claims claims = claimsJws.getBody();
//        return claims.getSubject();
//    }
//
//    /**
//     * 判断token是否存在
//     * @param email
//     * @return
//     */
//    public String getTokenIfExists(String email) {
//        // Check if a valid token exists in Redis for the given username
//        //String storedToken = redisTemplate.opsForValue().get(email);
//        String storeToken = tokenStore.get(email);
//        // Validate the stored token
//        if (storeToken != null && validateToken(storeToken)) {
//            return storeToken;
//        } else {
//            return null;
//        }
//    }
//
//
//}