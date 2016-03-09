package ua.shykun.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ua.shykun.delivery.domain.User;
import ua.shykun.delivery.domain.UserRole;

import java.util.ArrayList;
import java.util.List;

@Component("JPAAuthProvider")
public class JPAAuthentificationProvider implements AuthenticationProvider {


    @Autowired
    UserService userService;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String login = auth.getName();
        String passwd = auth.getCredentials().toString();
        User user = userService.findByLogin(login);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (user != null && encoder.matches(passwd, user.getPassword())) {
        //if (user != null && passwd.equals(user.getPassword())) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (UserRole role : user.getUserRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.toString()));
            }
            return new UsernamePasswordAuthenticationToken(login, passwd, grantedAuthorities);
        }
        throw new BadCredentialsException("Bad Credentials");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
