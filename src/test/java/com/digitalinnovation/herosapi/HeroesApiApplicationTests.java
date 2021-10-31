package com.digitalinnovation.herosapi;

import static com.digitalinnovation.herosapi.constans.HeroesConstans.HEROES_ENDPOINT_LOCAL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.digitalinnovation.herosapi.repository.HeroesRepository;


@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class HeroesApiApplicationTests {

  @Autowired
  WebTestClient webTestClient;

  @Autowired
  HeroesRepository heroesRepository;


  @Test
  public void getOneHeroeById(){

    webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"5")
      .exchange()
      .expectStatus().isOk()
      .expectBody();


  }

  @Test
  public void getOneHeronotFound(){

    webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"7")
      .exchange()
      .expectStatus().isNotFound();

  }


  @Test
  public void deleteHero(){

    webTestClient.delete().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"6")
      .accept(MediaType.APPLICATION_JSON)
      .exchange()
      .expectStatus().isNotFound()
      .expectBody(Void.class);

  }

}
