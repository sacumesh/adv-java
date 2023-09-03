package datamodel;

import javax.persistence.*;

@Entity
@Table(name = "facilities")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "facid")
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "membercost")
    private Integer memberCost;
    @Column(name = "guestcost")
    private Integer guestCost;
    @Column(name = "initialoutlay")
    private Integer initialOutlay;

    @Column(name = "monthlymaintenance")
    private Integer monthlyMaintenance;


    public Facility() {
    }

    public Facility(String name, Integer memberCost, Integer guestCost, Integer initialOutlay, Integer monthlyMaintenance) {
        this.name = name;
        this.memberCost = memberCost;
        this.guestCost = guestCost;
        this.initialOutlay = initialOutlay;
        this.monthlyMaintenance = monthlyMaintenance;
    }

    public Facility(Integer id, String name, Integer memberCost, Integer guestCost, Integer initialOutlay, Integer monthlyMaintenance) {
        this.id = id;
        this.name = name;
        this.memberCost = memberCost;
        this.guestCost = guestCost;
        this.initialOutlay = initialOutlay;
        this.monthlyMaintenance = monthlyMaintenance;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMemberCost() {
        return memberCost;
    }

    public void setMemberCost(Integer memberCost) {
        this.memberCost = memberCost;
    }

    public Integer getGuestCost() {
        return guestCost;
    }

    public void setGuestCost(Integer guestCost) {
        this.guestCost = guestCost;
    }

    public Integer getInitialOutlay() {
        return initialOutlay;
    }

    public void setInitialOutlay(Integer initialOutlay) {
        this.initialOutlay = initialOutlay;
    }

    public Integer getMonthlyMaintenance() {
        return monthlyMaintenance;
    }

    public void setMonthlyMaintenance(Integer monthlyMaintenance) {
        this.monthlyMaintenance = monthlyMaintenance;
    }

    @Override
    public String toString() {
        return "Facilities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", memberCost=" + memberCost +
                ", guestCost=" + guestCost +
                ", initialOutlay=" + initialOutlay +
                ", monthlyMaintenance=" + monthlyMaintenance +
                '}';
    }
}
