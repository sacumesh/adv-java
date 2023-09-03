package datamodel;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookid")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="memid", referencedColumnName="memid")
    private Member member;

    @ManyToOne
    @JoinColumn(name="facid", referencedColumnName="facid")
    private Facility facility;

    @Column(name = "startTime")
    private Timestamp startTime;

    @Column(name = "slots")
    private Integer slots;

    public Booking() {
    }

    public Booking(Integer id, Member member, Facility facility, Timestamp startTime, Integer slots) {
        this.id = id;
        this.member = member;
        this.facility = facility;
        this.startTime = startTime;
        this.slots = slots;
    }

    public Booking(Member member, Facility facility, Timestamp startTime, Integer slots) {
        this.member = member;
        this.facility = facility;
        this.startTime = startTime;
        this.slots = slots;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Integer getSlots() {
        return slots;
    }

    public void setSlots(Integer slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", member=" + member +
                ", facility=" + facility +
                ", startTime=" + startTime +
                ", slots=" + slots +
                '}';
    }
}
