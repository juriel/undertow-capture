package net.comtor.undertow.capture;

import io.undertow.io.Receiver;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HeaderMap;
import io.undertow.util.HttpString;

/**
 *
 * @author juriel
 */
public class CaptureAllHandler implements HttpHandler {

    @Override
    public void handleRequest(HttpServerExchange ex) throws Exception {
        System.out.println("===============[ " + ex.getHostAndPort() + "" + ex.getRequestURI() + " " + ex.getQueryString() + "]==================");
        HeaderMap headers = ex.getRequestHeaders();
        headers.forEach(hv -> System.out.println("" + hv.getHeaderName() + ": " + hv.element()));
        System.out.println("---- Headers end -------");
        System.out.println("PAYLOAD");
        ex.getRequestReceiver().receiveFullBytes(new CustomFullBytesCallback());
        
        
        ex.getResponseHeaders().add(new HttpString("Content-type"), "text/plain");

        ex.getResponseSender().send("Hello");

    }

}
