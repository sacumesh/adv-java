package datamodel;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "memid")
    private Integer id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "address")
    private String address;
    @Column(name = "zipcode")
    private Integer zipcode;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "recommendedby")
    private Integer recommendedBy;

    @Column(name = "joindate")
    private Timestamp joinDate;

    public Member() {
    }


    public Member(String surname, String firstName, String address, Integer zipcode, String telephone, Integer recommendedBy, Timestamp joinDate) {
        this.surname = surname;
        this.firstName = firstName;
        this.address = address;
        this.zipcode = zipcode;
        this.telephone = telephone;
        this.recommendedBy = recommendedBy;
        this.joinDate = joinDate;
    }

    public Member(Integer id, String surname, String firstName, String address, Integer zipcode, String telephone, Integer recommendedBy, Timestamp joinDate) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.address = address;
        this.zipcode = zipcode;
        this.telephone = telephone;
        this.recommendedBy = recommendedBy;
        this.joinDate = joinDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getRecommendedBy() {
        return recommendedBy;
    }

    public void setRecommendedBy(Integer recommendedBy) {
        this.recommendedBy = recommendedBy;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "Members{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", zipcode=" + zipcode +
                ", telephone='" + telephone + '\'' +
                ", recommendedBy=" + recommendedBy +
                ", joinDate=" + joinDate +
                '}';
    }
}
