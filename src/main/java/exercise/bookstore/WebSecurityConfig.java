package exercise.bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
// This Config class does not extend ...Adapter class anymore.
public class WebSecurityConfig {
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		// these endpoints don't need authentication
		// Enable css when logged out
		http.authorizeRequests().antMatchers("/index").permitAll().anyRequest().authenticated().and()

				.formLogin().loginPage("/login").defaultSuccessUrl("/booklist", true).permitAll().and().logout()
				.permitAll().and().httpBasic();
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {

		List<UserDetails> users = new ArrayList<>();
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		UserDetails user1 = User.withUsername("user").password(passwordEncoder.encode("user")).roles("USER").build();
		users.add(user1);

		UserDetails user2 = User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN")
				.build();
		users.add(user2);

		return new InMemoryUserDetailsManager(users);
	}
}
