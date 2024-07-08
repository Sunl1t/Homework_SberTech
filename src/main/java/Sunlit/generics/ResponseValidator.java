package Sunlit.generics;

public interface ResponseValidator<Response> {
    boolean validateResponse(Response response);
}
