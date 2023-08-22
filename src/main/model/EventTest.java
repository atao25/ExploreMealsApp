package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

// This class references code from: https://github.students.cs.ubc.ca/CPSC210/AlarmSystem.git


/**
 * Unit tests for the Event class
 */

public class EventTest {
    private Event event;
    private Date date;

    //NOTE: these tests might fail if time at which line (2) below is executed
    //is different from time that line (1) is executed.  Lines (1) and (2) must
    //run in same millisecond for this test to make sense and pass.

    @BeforeEach
    public void runBefore() {
        event = new Event("Meal added");   // (1)
        date = Calendar.getInstance().getTime();   // (2)
    }

    @Test
    public void testEvent() {
        assertEquals("Meal added", event.getDescription());
        assertEquals(date, event.getDate());
    }

    @Test
    public void testToString() {
        assertEquals(date.toString() + "\n" + "Meal added", event.toString());
    }

    @Test
    public void testEquals() {
        assertFalse(event.equals(null));
        assertFalse(event.equals(new Object()));
    }

    @Test
    public void testHashCode() {
        assertEquals(new Event("Meal added").hashCode(),
                new Event("Meal added").hashCode());
    }

}




