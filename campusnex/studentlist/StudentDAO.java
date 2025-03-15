package com.campusnex.studentlist;

public interface StudentDAO {
    PersonalProfile getPersonalProfile(String enrollmentNo);
    PlacementProfile getPlacementProfile(String enrollmentNo);
}
