package ro.andreistoian.SpringNotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.andreistoian.SpringNotes.dao.UserDAO;
import ro.andreistoian.SpringNotes.models.User;


import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDAO repo;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUser = repo.findByUsername(s);

        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            String[] roleList = new String[user.getRoles().size()];
            for (int i = 0; i < roleList.length ; i++) {
                roleList[i] = user.getRoles().get(i).getRoleName();
            }
            return org.springframework.security.core.userdetails.User.builder().
                    username(user.getUsername()).roles(roleList).password(user.getPassword()).build();
        }
        else throw new UsernameNotFoundException("username not found");
    }



}
