package sunlit.generics;

public interface ResponseValidator<Response> {
    boolean validateResponse(Response response);
}
