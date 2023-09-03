package app.messages;

import datamodel.Facility;

public class FacilityDTO {
    private Integer id;

    private String name;

    private Integer memberCost;

    private Integer guestCost;

    private Integer initialOutlay;

    private Integer monthlyMaintenance;


    public FacilityDTO() {
    }

    public FacilityDTO(String name, Integer memberCost, Integer guestCost, Integer initialOutlay, Integer monthlyMaintenance) {
        this.name = name;
        this.memberCost = memberCost;
        this.guestCost = guestCost;
        this.initialOutlay = initialOutlay;
        this.monthlyMaintenance = monthlyMaintenance;
    }

    public FacilityDTO(Facility facility) {
        this.id = facility.getId();
        this.name = facility.getName();
        this.memberCost = facility.getMemberCost();
        this.initialOutlay = facility.getInitialOutlay();
        this.monthlyMaintenance = facility.getMonthlyMaintenance();
        this.guestCost = facility.getGuestCost();
    }

    public FacilityDTO(Integer id, String name, Integer memberCost, Integer guestCost, Integer initialOutlay, Integer monthlyMaintenance) {
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

    public Integer getGuestCost() {
        return guestCost;
    }

    public void setGuestCost(Integer guestCost) {
        this.guestCost = guestCost;
    }

    @Override
    public String toString() {
        return "FacilityDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", memberCost=" + memberCost +
                ", guestCost=" + guestCost +
                ", initialOutlay=" + initialOutlay +
                ", monthlyMaintenance=" + monthlyMaintenance +
                '}';
    }
}
