package com.example.Cat2SoapClient;

import localhost.movies.GetMovieResponse;
import localhost.movies.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Cat2SoapClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cat2SoapClientApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(Client movieClient){

		return args -> {
			String name = "The Boys";
			if(args.length>0){
				name = args[0];
			}

			GetMovieResponse response = movieClient.getMovieResponse(name);
			Movie movie = response.getMovie();
			System.err.println(
					"Movie Name: "+movie.getName()+
							"\n Movie's genre: "+movie.getGenre()+
							"\n Year Released: "+movie.getYearReleased()
			);
		};

	}

}
