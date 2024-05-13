package com.ssafy.jeju.oauth.oauth2.handler;

import com.ssafy.jeju.oauth.CustomOAuth2User;
import com.ssafy.jeju.oauth.jwt.service.JwtService;
import com.ssafy.jeju.user.model.dto.User;
import com.ssafy.jeju.user.model.mapper.UserMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
//@Transactional
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtService jwtService;
    private final UserMapper userMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("OAuth2 Login 성공!");
        try {
            CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
            System.out.println("여기올시다.");
            System.out.println(authentication);
            String accessToken = jwtService.createAccessToken(oAuth2User.getEmail());
            String refreshToken = jwtService.createRefreshToken();
            response.sendRedirect("http://localhost:5173/index?accessToken=" + accessToken + "&refreshToken=" + refreshToken);
            jwtService.sendAccessAndRefreshToken(response, accessToken, refreshToken);
            jwtService.updateRefreshToken(oAuth2User.getEmail(), refreshToken);

            User findUser = userMapper.findByEmail(oAuth2User.getEmail())
                            .orElseThrow(() -> new IllegalArgumentException("이메일에 해당하는 유저가 없습니다."));
            userMapper.updateUser(findUser);

        } catch (Exception e) {
            throw e;
        }

    }

    // TODO : 소셜 로그인 시에도 무조건 토큰 생성하지 말고 JWT 인증 필터처럼 RefreshToken 유/무에 따라 다르게 처리해보기
    private void loginSuccess(HttpServletResponse response, CustomOAuth2User oAuth2User) throws IOException {
        String accessToken = jwtService.createAccessToken(oAuth2User.getEmail());
        String refreshToken = jwtService.createRefreshToken();
        response.addHeader(jwtService.getAccessHeader(), "Bearer " + accessToken);
        response.addHeader(jwtService.getRefreshHeader(), "Bearer " + refreshToken);
        log.info(refreshToken);
        jwtService.sendAccessAndRefreshToken(response, accessToken, refreshToken);
        jwtService.updateRefreshToken(oAuth2User.getEmail(), refreshToken);
    }
}
