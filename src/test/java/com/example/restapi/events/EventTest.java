package com.example.restapi.events;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {

    @Test
    void builder(){
        Event event = Event.builder()
                .name("Inflearn Spring REST API")
                .description("REST API development with Spring")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    void javaBean(){
        //given
        String name = "Event";
        String description = "Spring";

        //when
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);

        //then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }

    @Test
    void testFree (){
        //given
        Event event = Event.builder()
                .basePrice(0)
                .maxPrice(0)
                .build();

        //when
        event.update();

        //then
        assertThat(event.isFree()).isTrue();
    }

    @Test
    void testNotFree (){
        //given
        Event event = Event.builder()
                .basePrice(0)
                .maxPrice(100)
                .build();

        //when
        event.update();

        //then
        assertThat(event.isFree()).isFalse();
    }

    @Test
    void testOffline(){
        //given
        Event event = Event.builder()
                .location("강남역 토즈")
                .build();
        //when
        event.update();

        //then
        assertThat(event.isOffline()).isTrue();
    }

    @Test
    void testOnline(){
        //given
        Event event = Event.builder()
                .build();

        //when
        event.update();

        //then
        assertThat(event.isOffline()).isFalse();
    }

}