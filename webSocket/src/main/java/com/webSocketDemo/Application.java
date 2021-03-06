package com.webSocketDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 *
 * Author :wei.chen
 */
@SpringBootApplication
@EnableWebSocket
public class Application {

  public static void main(String[] args) {
	  //test sourcetree commit  
    SpringApplication.run(Application.class, args);
  }

}
