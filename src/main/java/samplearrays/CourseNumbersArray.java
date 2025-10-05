package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};

        // Appending new element
        int new_element = 2090;

        // Creating a new array with one case larger
        int[] updatedCourses = new int[registeredCourses.length + 1];

        // Copying the old array in it
        for (int i = 0; i < registeredCourses.length; i++) {
            updatedCourses[i] = registeredCourses[i];
        }

        // Set the last item to be the copied element
        updatedCourses[updatedCourses.length - 1] = new_element;

        // Printing the updatedCourses
        System.out.println("\n== All Courses == ");
        for (int course : updatedCourses) System.out.println(course);

        // Checking if a course exist in updatedCourses
        int specific_course = 2091;
        System.out.println("\n== Checking the existance of the course: " + specific_course + " ==");
        boolean course_found = false;

        // Iterating through all courses and compare the course with each of the courses
        for (int course : updatedCourses) {
            if (course == specific_course) {
                System.out.println("Course found");
                course_found = true;
            }
        }

        if (!course_found) System.out.println("Course not found");
    }
}
