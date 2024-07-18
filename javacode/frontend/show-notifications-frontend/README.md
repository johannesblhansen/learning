###### Spring DeferredResult

DeferredResult is a return type in spring used with async request / response patterns. It returns immediately releasing the http worker thread, but the underlying servlet container (typically tomcat), does not send the response to the client until .setResult is called.

The idea is to offload work from the http thread to a worker thread that can block without disturbing the http workers processing other requests.


###### Long polling

https://www.baeldung.com/spring-mvc-long-polling

###### Spring events
https://www.baeldung.com/spring-events


###### Websocket

https://spring.io/guides/gs/messaging-stomp-websocket

STOMP messages
https://stomp.github.io/


https://docs.spring.io/spring-framework/reference/web/websocket.html
and
https://docs.spring.io/spring-framework/reference/web/websocket/stomp.html
