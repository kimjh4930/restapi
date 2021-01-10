package com.example.restapi.events;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class EventResource extends EntityModel<Event> {

    public EventResource(Event event, Link... links){

    }

}
