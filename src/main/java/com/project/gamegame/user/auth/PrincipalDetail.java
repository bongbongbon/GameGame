//package com.project.gamegame.user.auth;
//
//import com.project.gamegame.user.model.User;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//public class PrincipalDetail implements UserDetails {
//
//    private User user;
//
//    public PrincipalDetail(User user) {
//        this.user = user;
//    }
//
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    public boolean isCredentialsNonExprired() {
//        return true;
//    }
//
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> collectors = new ArrayList<>();
//        collectors.add(() -> {
//            return "Role_" + user.getRold();
//
//        });
//        return collectors;
//    }
//
//}
