package br.com.unimed.Caso1.api.security;

import br.com.unimed.Caso1.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        br.com.unimed.Caso1.domain.User user = userRep.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario não Encontrado");
        }
        return User.withUsername(username).password(user.getSenha()).roles("USER").build();
        }
}
