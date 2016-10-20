package org.swe.omt.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by nadine on 10/19/16.
 */
@Entity
@Table( name = "Event")
public class Event {

    @ManyToOne( cascade = CascadeType.PERSIST)
    @JoinColumn (name = "sectionevent")
    //calculated...also foreign key for Sections
    private String shortSectionName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;

    private Timestamp eventDate;
    private int handsOnMultiplier;
    private String sectionLetter;
    private String sectionNumber;

    private int girls;
    private int boys;
    // calculated
    private int totalRaw;
    // calculated
    private int totalWeighted;
    // calculated
    private double score;
    private String kbContent;



    private static Event ourInstance = new Event();

    public static Event getInstance() {
        return ourInstance;
    }

    private Event() {
    }
}
