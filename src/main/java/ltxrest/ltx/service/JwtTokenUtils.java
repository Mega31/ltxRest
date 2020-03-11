package ltxrest.ltx.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtils  {
    @Value("${jwt.secret}")
    private String secret;
    public  String jwtTokenGenrator (String id,String issuer,String subject,long time){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
        long nowMilli = System.currentTimeMillis();
        Date today = new Date(nowMilli);
        byte[] apiSecretArray = DatatypeConverter.parseBase64Binary(secret);
        Key signingKey = new SecretKeySpec(apiSecretArray, signatureAlgorithm.getJcaName());
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(today)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        if (nowMilli > 0) {
            long expMillis = nowMilli + time;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }
    public  Claims decodeJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(secret))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }
    public String getUserName(String jwt){
        return decodeJWT(jwt).getSubject();
    }
    public Date getExpriation(String jwt){
       return decodeJWT(jwt).getExpiration();
    }
}

