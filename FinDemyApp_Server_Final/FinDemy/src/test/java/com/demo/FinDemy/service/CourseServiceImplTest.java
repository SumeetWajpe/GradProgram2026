package com.demo.FinDemy.service;

import com.demo.FinDemy.beans.Course;
import com.demo.FinDemy.beans.Trainer;
import com.demo.FinDemy.dto.CourseRequest;
import com.demo.FinDemy.dto.CourseResponse;
import com.demo.FinDemy.exceptions.CourseNotFoundException;
import com.demo.FinDemy.mapper.CourseMapper;
import com.demo.FinDemy.repository.CourseRepository;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    @Test
    void returnsAllCoursesAsResponsesWhenRepositoryHasCourses() {
        Course c = new Course(1, "Java Basics", 10, LocalDate.of(2025, 1, 1), new Trainer(2, "Alice", 6));
        when(courseRepository.findAll()).thenReturn(List.of(c));

        List<CourseResponse> responses = courseService.getAllCourses();

        assertThat(responses).hasSize(1);
        assertThat(responses.get(0).getCid()).isEqualTo(1);
        assertThat(responses.get(0).getTname()).isEqualTo("xxx");
       // assertEqual(responses.get(0).getTname(),"Alice");
        verify(courseRepository).findAll();
    }

    @Test
    void returnsEmptyListWhenRepositoryHasNoCourses() {
        when(courseRepository.findAll()).thenReturn(List.of());

        List<CourseResponse> responses = courseService.getAllCourses();

        assertThat(responses).isEmpty();
        verify(courseRepository).findAll();
    }

    @Test
    void returnsCourseResponseWhenFoundById() {
        Course c = new Course(3, "Advanced", 20, LocalDate.of(2025, 6, 1),null, new Trainer(5, "Bob", 10));
        when(courseRepository.findById(3)).thenReturn(Optional.of(c));

        CourseResponse response = courseService.getById(3);

        assertThat(response).isNotNull();
        assertThat(response.getCid()).isEqualTo(3);
        assertThat(response.getTname()).isEqualTo("Bob");
        verify(courseRepository).findById(3);
    }

     @Test
    void throwsCourseNotFoundWhenGetByIdNotFound() {
        when(courseRepository.findById(99)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> courseService.getById(99))
                .isInstanceOf(CourseNotFoundException.class)
                .hasMessageContaining("Course not found with id: 99");

        verify(courseRepository).findById(99);
    }

    @Test
    void addsCourseFromRequestAndReturnsSavedCourseWithId() {
        CourseRequest req = new CourseRequest(0, "New Course", 5, LocalDate.of(2026, 1, 1), 10, "Carol", 3);
        Course mapped = CourseMapper.convertRequestToBean(req);
        Course saved = new Course(42, mapped.getCname(), mapped.getDuration(), mapped.getStartdate(), mapped.getTrainer());

        when(courseRepository.save(any(Course.class))).thenReturn(saved);

        Course result = courseService.addCourse(req);

        assertThat(result).isNotNull();
        assertThat(result.getCid()).isEqualTo(42);
        assertThat(result.getCname()).isEqualTo("New Course");
        verify(courseRepository).save(any(Course.class));
    }

    @Test
    void updatesExistingCourseFieldsWhenCourseExists() {
        Course existing = new Course(7, "Old Name", 3, LocalDate.of(2024, 4, 4),null, null);
        CourseRequest req = new CourseRequest(7, "Updated Name", 12, LocalDate.of(2025, 5, 5), 0,null, null, 0);

        when(courseRepository.findById(7)).thenReturn(Optional.of(existing));
        when(courseRepository.save(any(Course.class))).thenAnswer(invocation -> invocation.getArgument(0));

        courseService.updateCourse(req);

        assertThat(existing.getCname()).isEqualTo("Updated Name");
        assertThat(existing.getDuration()).isEqualTo(12);
        assertThat(existing.getStartdate()).isEqualTo(LocalDate.of(2025, 5, 5));
        verify(courseRepository).findById(7);
        verify(courseRepository).save(existing);
    }

    @Test
    void updateCourseThrowsWhenCourseDoesNotExist() {
        CourseRequest req = new CourseRequest(999, "Doesn't Matter", 1, LocalDate.now(), 0, null, 0);
        when(courseRepository.findById(999)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> courseService.updateCourse(req))
                .isInstanceOf(CourseNotFoundException.class)
                .hasMessageContaining("Course not found with id: 999");

        verify(courseRepository).findById(999);
        verify(courseRepository, never()).save(any());
    }

    @Test
    void removeByIdDelegatesToRepositoryDelete() {
        doNothing().when(courseRepository).deleteById(5);

        courseService.removeById(5);

        verify(courseRepository).deleteById(5);
    }
}
