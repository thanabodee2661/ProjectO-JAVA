package com.example.TestCreateProject.Security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.TestCreateProject.Model.JwtAuthenticationToken;
import com.example.TestCreateProject.Model.JwtUserDetails;
import com.example.TestCreateProject.Model.User;


@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private JwtValidator validator;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

	}

	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

		System.out.println("jwtProvider");
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
		String token = jwtAuthenticationToken.getToken();

		User jwtUser = validator.validate(token);

		if (jwtUser == null) {
			throw new RuntimeException("JWT Token is incorrect");
		}

		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(jwtUser.getEmail());
		return new JwtUserDetails(jwtUser.getEmail(), token, grantedAuthorities);
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
	}
}
