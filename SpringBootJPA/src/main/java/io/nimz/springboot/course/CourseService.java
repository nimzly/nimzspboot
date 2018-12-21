package io.nimz.springboot.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}

	public Course getCourseById(String id) {
		return courseRepository.findById(id).get();

	}

	public void addCourse(Course course) {

		courseRepository.save(course);

	}

	public void deleteCourseById(String id) {

		courseRepository.deleteById(id);

	}

	public void updateCourse(Course course) {

		courseRepository.save(course);

	}
}
