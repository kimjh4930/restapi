package com.example.restapi.events;

import lombok.*;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter @EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location;
    private int basePrice;
    private int maxPrice;
    private int limitOfEnrollment;
    private boolean offline;
    private boolean free;

    @Enumerated(value = EnumType.STRING)
    private EventStatus eventStatus = EventStatus.DRAFT;

    public void update() {
        this.free = (this.basePrice == 0 && this.maxPrice == 0) ? true : false;

        if(this.location == null || this.location.isBlank()){
            this.offline = false;
        }else{
            this.offline = true;
        }
    }
}
