package com.example.jwtapp.security;



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class JwtFilter implements Filter {
    private static final Logger log = Logger.getLogger(JwtFilter.class.getName());

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        try {
            String path = req.getRequestURI();

            if (path.equals("/login")) {
                chain.doFilter(request, response);
                return;
            }

            String authHeader = req.getHeader("Authorization");

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            String token = authHeader.substring(7);

            if (!jwtUtil.validarToken(token)) {
                log.info("token inválido");
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            log.info("token válido");
            String username = jwtUtil.getUsername(token);

            // 🔥 AQUI
            UserContext.setUsername(username);

            chain.doFilter(request, response);

        } finally {
            // 🔐 OBRIGATÓRIO
            UserContext.clear();
        }
    }
}

