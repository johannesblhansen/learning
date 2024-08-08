
Streams of requests and responses are handled by the StreamObserver<ItemsInTheStream>

```
@Override  
public StreamObserver<MyClientRequest> getMyResponse(StreamObserver<MyClientResponse> responseObserver) {  
             
    /*  
    The implementation of StreamObserver<MyClientRequest> that is returned by the method, is used to handle inbound    message from the client.    To give a response to such a message, the RequestHandler (which is an StreamObserver<MyClientRequest> impl) gets    the server response stream observer to act on it.     */    return new RequestHandler(responseObserver);  
}
```

*NOTE: The if the scenario is client streaming, then only one response can be sent.*

In the impl of client request stream observer:

```
public class RequestHandler implements StreamObserver<MyClientRequest> {  
  
    private final StreamObserver<MyClientResponse> responseStreamObserver;  
  
    private int requestCount = 0;  
  
    //Get the response stream observer, to act on it, according to client input from the client stream observer  
    public RequestHandler(StreamObserver<MyClientResponse> responseStreamObserver) {  
        this.responseStreamObserver = responseStreamObserver;  
    }  
  
    @Override  
    public void onNext(MyClientRequest myClientRequest) {  
        if (requestCount > 2) {  
            System.out.println("I got as many requests as I want. Shutting down...");  
            this.onCompleted();  
        }  
        System.out.println("I got something from the client");  
        requestCount++;  
    }  
  
    @Override  
    public void onError(Throwable throwable) {  
        //Not impl in this example  
    }  
  
    @Override  
    public void onCompleted() {  
        System.out.println("RequestHandler shutting down");  
        //Send a message to the client  
        responseStreamObserver.onNext(MyClientResponse.newBuilder().setMyResponseId(1).setMyResponseMessage("I got something from you").build());  
        //Shut down the connection  
        responseStreamObserver.onCompleted();  
  
    }  
}
```