package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.CourseModel;

@Service
public class CourseDAOImpl implements CourseDAO{
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public CourseModel selectCourse(String id_course) {
		CourseModel course = restTemplate.getForObject("http:8080/rest/course/view/"+id_course, CourseModel.class);
		return course;
	}
	
	@Override
	public List<CourseModel> selectAllCourse() {
		List<CourseModel> allCourses = restTemplate.getForObject("http:8080/rest/course/viewall", List.class);
		return allCourses;
	}
}
