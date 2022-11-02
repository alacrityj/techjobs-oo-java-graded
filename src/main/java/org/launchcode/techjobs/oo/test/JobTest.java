package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job_one = new Job();
        Job job_two = new Job();
        assertNotEquals(job_one, job_two);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job_three = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job_three instanceof Job);
        assertTrue(job_three.getEmployer() instanceof Employer);
        assertTrue(job_three.getLocation() instanceof Location);
        assertTrue(job_three.getPositionType() instanceof PositionType);
        assertTrue(job_three.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(job_three.getName(), "Product tester");
        assertEquals(job_three.getEmployer().getValue(), "ACME");
        assertEquals(job_three.getLocation().getValue(), "Desert");
        assertEquals(job_three.getPositionType().getValue(), "Quality control");
        assertEquals(job_three.getCoreCompetency().getValue(), "Persistence");

    }

    @Test
    public void testJobsForEquality() {
        Job job_four = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job_five = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job_four.equals(job_five));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job_six = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        char firstChar = job_six.toString().charAt(0);
        char lastChar = job_six.toString().charAt(job_six.toString().length()-1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job_seven = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String output =

                "\nID: " + job_seven.getId() +
                "\nName: " + job_seven.getName() +
                "\nEmployer: " + job_seven.getEmployer() +
                "\nLocation: "  + job_seven.getLocation() +
                "\nPosition Type: "  + job_seven.getPositionType() +
                "\nCore Competency: " + job_seven.getCoreCompetency() + "\n";

        assertEquals(output, job_seven.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job_eight = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String output =

                "\nID: " + job_eight.getId() +
                        "\nName: " + job_eight.getName() +
                        "\nEmployer: " + "Data not available" +
                        "\nLocation: "  + job_eight.getLocation() +
                        "\nPosition Type: "  + job_eight.getPositionType() +
                        "\nCore Competency: " + job_eight.getCoreCompetency() + "\n";

        assertEquals(output, job_eight.toString());

        assertEquals("Data not available", job_eight.getEmployer().toString());
    }
}

