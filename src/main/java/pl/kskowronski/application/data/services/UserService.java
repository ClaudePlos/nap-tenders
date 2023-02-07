package pl.kskowronski.application.data.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.kskowronski.application.data.entity.User;
import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    protected UserRepository getRepository() {
        return repo;
    }

//    public Optional<User> findById(BigDecimal prcId){
//        return repo.findById(prcId);
//    }

    public User findByUsername(String username){
        Optional<User> user = repo.findByUsername(username);
        return user.orElseThrow(()-> new EntityNotFoundException("No findByUsername: " + username));
    }

//    public Optional<User> findByPassword(String pesel){ return repo.findByPassword(pesel);}
//
//    public List<User> findAll(){ return repo.findAll(Sort.by(Sort.Direction.ASC, "username"));}
//
//    public Optional<List<User>> findFastUsers(String word){ return repo.findFastUsers(word.toLowerCase()); }

}