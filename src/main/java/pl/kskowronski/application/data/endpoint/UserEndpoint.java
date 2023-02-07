package pl.kskowronski.application.data.endpoint;

import pl.kskowronski.application.data.entity.User;
import pl.kskowronski.application.security.AuthenticatedUser;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Endpoint
@AnonymousAllowed
public class UserEndpoint {

    @Autowired
    private AuthenticatedUser authenticatedUser;

    public Optional<User> getAuthenticatedUser() {
        Optional<User> user = authenticatedUser.get();
        return user;
    }
}
