import datamodel.Facility;
import datamodel.Member;

import java.sql.Timestamp;
import java.util.logging.Logger;

public class TestMVD2 {


    public static void main(String[] args) {

        Logger logger = Logger.getLogger("FacilityLogger");

        Facility facility = new Facility(1, "Swimming Pool", 100, 50, 1000, 50);
        logger.info("[FACILITY] " + facility.toString());

        Member member = new Member(1, "Doe", "John", "123 Main St", 12345, "555-1234", 2, Timestamp.valueOf("2022-01-01 00:00:00"));
        logger.info("[MEMBER] " + member.toString());


    }
}
