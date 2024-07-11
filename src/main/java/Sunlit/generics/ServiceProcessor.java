package sunlit.generics;

public interface ServiceProcessor<P, Response, Request> {
    Response process(Request request);
}
