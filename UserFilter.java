package WN;

import users.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserFilter implements Filter {

    Map<String, User> userMap;
    public static final String USER_ATTRIBUTE= "loggedUser";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        List<User> users = new ArrayList<>();
        users.add(new User("Uzytkownik 1", "user", "tajne"));
        users.add(new User("Admin", "admin", "admin"));

        userMap = users.stream()
                .collect(Collectors.toMap(User::getLogin, Function.identity()));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        String login = httpRequest.getParameter("login");

        if (login !=null && userMap.containsKey(login)){
            servletRequest.setAttribute(USER_ATTRIBUTE, userMap.get(login));
        }
        chain.doFilter(servletRequest, response);
    }

    @Override
    public void destroy() {

    }
}
