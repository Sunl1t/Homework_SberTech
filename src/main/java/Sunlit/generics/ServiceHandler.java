package Sunlit.generics;

public abstract class ServiceHandler<P, Response, Request> {
    private ResponseValidator <Response> responseValidator;
    private RequestValidator <Request> requestValidator;
    private ServiceProcessor <P, Response, Request>serviceProcessor;

    public void serviceHandler(ResponseValidator <Response> responseValidator,
                        RequestValidator <Request> requestValidator,
                        ServiceProcessor <P, Response, Request>serviceProcessor) {
        this.responseValidator = responseValidator;
        this.requestValidator = requestValidator;
        this.serviceProcessor = serviceProcessor;
    }

    public Response handleRequest(Request request) throws Exception {
        if (!requestValidator.validateRequest(request)) {
            throw new IllegalArgumentException("Недопустимый запрос");
        }

        Response response = serviceProcessor.process(request);

        if (response == null) {
            throw new NullPointerException("Не удалось подключиться к серверу");
        }

        if (!responseValidator.validateResponse(response)) {
            throw new IllegalArgumentException("Не удалось подключиться к серверу");
        }
        return response;
    }
    protected abstract Response process(Request request) throws Exception;
    public abstract boolean validateRequest(String request);

    public abstract boolean validateResponse(Integer response);
}
