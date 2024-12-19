package net.szymonsawicki.application;

import java.util.Set;

import net.szymonsawicki.persistence.UserEntity;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtSignature;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TokenService {

  @Inject
  private UserEntity userEntity;

  @ConfigProperty(name = "mp.jwt.verify.issuer")
  String jwtIssuer;

  public String generateToken(String username, Set<String> roles) {
    return Jwt.issuer(jwtIssuer).upn(username).groups(roles).sign();
  }
}
