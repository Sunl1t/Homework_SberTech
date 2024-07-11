package sunlit.generics;

import com.sun.net.httpserver.Request;

public interface RequestValidator<Request> {
    boolean validateRequest(Request request);
}
