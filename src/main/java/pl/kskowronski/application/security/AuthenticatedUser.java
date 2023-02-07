package pl.kskowronski.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.kskowronski.application.data.entity.User;
import com.vaadin.flow.spring.security.AuthenticationContext;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import pl.kskowronski.application.data.services.UserRepository;

@Component
public class AuthenticatedUser {

    private final UserRepository userRepository;


    public AuthenticatedUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private Optional<Authentication> getAuthentication() {
        SecurityContext context = SecurityContextHolder.getContext();
        return Optional.ofNullable(context.getAuthentication())
                .filter(authentication -> !(authentication instanceof AnonymousAuthenticationToken));
    }

    public Optional<User> get() {
         var auth = getAuthentication().map(authentication -> userRepository.findByUsername(authentication.getName()).get());
         return auth;
    }

    public void logout() {
        //authenticationContext.logout();
    }

}
