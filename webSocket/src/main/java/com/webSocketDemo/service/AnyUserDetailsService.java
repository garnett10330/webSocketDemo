package com.webSocketDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webSocketDemo.model.User;
import com.webSocketDemo.model.UserPrincipal;



/**
 * 驗證登入者詳情
 * Author :wei.chen
 */
@Service
public class AnyUserDetailsService implements UserDetailsService {
	private final static String ROLE_TAG = "ROLE_USER";

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("用戶不存在");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(ROLE_TAG));
		// 用戶驗證（用戶名稱，密碼，權限）
		UserPrincipal userPrincipal = new UserPrincipal(username, user.getPassword(), authorities);
		userPrincipal.setNickname(user.getNickname());
		userPrincipal.setAvatar(user.getAvatar());
		return userPrincipal;
	}

}
