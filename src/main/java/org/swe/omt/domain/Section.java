package org.swe.omt.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nadine on 10/19/16.
 */
@Entity
@Table( name = "Section")
public class Section {

    @OneToMany (mappedBy = "shortSectionName")
    private List<Event> events;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long sectionId;

    private String longSectionName;
    private int paid;
    // calculated
    private String shortSectionName;

    protected Section() {}

    public Section( String longSectionName, int paid) {
        this.longSectionName  = longSectionName;
        this.paid = paid;
    }

    @Override
    public String toString() {
        return String.format(
                "Section[id:%d, longName: %s, shortName: %s]", sectionId, longSectionName, shortSectionName);
    }


    public String getLongSectionName() {
        return longSectionName;
    }

    public void setLongSectionName(String longSectionName) {
        this.longSectionName = longSectionName;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public String getShortSectionName() {
        return shortSectionName;
    }

    public void setShortSectionName(String shortSectionName) {
        // TODO: derive short section name by extracting B [0-9] [0-9] [0-9] from longSectionName
        this.shortSectionName = shortSectionName;
    }
}
