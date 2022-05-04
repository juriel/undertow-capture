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
        
        String query = "";
        if (ex.getQueryString() != null && ex.getQueryString().length()>0){
            query  =  "?"+ex.getQueryString();
        }
        System.out.println("===============[ "+ex.getRequestMethod()+" -> " + ex.getRequestURL()+ query + "]==================");
        
        
        System.out.println("query_string   "+ex.getQueryString());
        System.out.println("request_path   "+ex.getRequestPath());
        System.out.println("request_uri    "+ex.getRequestURI());
        System.out.println("url            "+ex.getRequestURL());
        System.out.println("Scheme         "+ex.getRequestScheme());
        
        
        
        
        System.out.println("---- Headers     -------");
        HeaderMap headers = ex.getRequestHeaders();
        headers.forEach(hv -> System.out.println("" + hv.getHeaderName() + ": " + hv.element()));
        System.out.println("---- Headers end -------");
        System.out.println("PAYLOAD");
        ex.getRequestReceiver().receiveFullBytes(new CustomFullBytesCallback());
        
        
        ex.getResponseHeaders().add(new HttpString("Content-type"), "text/plain");

        ex.getResponseSender().send("Hello");
        System.out.println("----------------------------------------");

    }

}
