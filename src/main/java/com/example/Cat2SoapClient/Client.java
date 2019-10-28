package com.example.Cat2SoapClient;

import localhost.movies.GetMovieRequest;
import localhost.movies.GetMovieResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class Client extends WebServiceGatewaySupport {

    public GetMovieResponse getMovieResponse(String movieName){
        GetMovieRequest request = new GetMovieRequest();
        request.setName(movieName);

        GetMovieResponse response = (GetMovieResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws",
                        request,
                        new SoapActionCallback("http://localhost/movies"));

        return response;

    }

}
