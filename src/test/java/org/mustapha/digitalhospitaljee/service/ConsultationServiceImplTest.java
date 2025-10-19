package org.mustapha.digitalhospitaljee.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mustapha.digitalhospitaljee.Exceptions.ConsultationException;
import org.mustapha.digitalhospitaljee.Repository.ConsultationRepository;
import org.mustapha.digitalhospitaljee.model.Consultation;
import org.mustapha.digitalhospitaljee.model.Doctor;
import org.mustapha.digitalhospitaljee.model.enums.ConsultationStatus;
import org.mustapha.digitalhospitaljee.service.impl.ConsultationServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConsultationServiceImplTest {

    @Mock
    private ConsultationRepository consultationRepository;

    @InjectMocks
    private ConsultationServiceImpl consultationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateConsultation_success() throws ConsultationException {
        Consultation consultation = new Consultation();
        consultation.setId(1L);

        doNothing().when(consultationRepository).create(consultation);

        consultationService.create(consultation);

        verify(consultationRepository, times(1)).create(consultation);
    }

    @Test
    void testUpdateConsultation_success() throws ConsultationException {
        Consultation consultation = new Consultation();
        consultation.setId(1L);

        doNothing().when(consultationRepository).update(consultation);

        consultationService.update(consultation);

        verify(consultationRepository, times(1)).update(consultation);
    }

    @Test
    void testDeleteConsultation_success() throws ConsultationException {
        Long consultationId = 1L;
        doNothing().when(consultationRepository).delete(consultationId);

        consultationService.delete(consultationId);

        verify(consultationRepository, times(1)).delete(consultationId);
    }

    @Test
    void testFindConsultation_success() throws ConsultationException {
        Consultation consultation = new Consultation();
        consultation.setId(1L);
        when(consultationRepository.getConsultationById(1L)).thenReturn(consultation);

        Consultation found = consultationService.findConsultation(1L);

        assertNotNull(found);
        assertEquals(1L, found.getId());
    }

    @Test
    void testChangeStatus_success() throws ConsultationException {
        Long consultationId = 1L;
        ConsultationStatus newStatus = ConsultationStatus.CONFIRMED;
        when(consultationRepository.changeStatus(consultationId, newStatus)).thenReturn(true);

        boolean result = consultationService.changeStatus(consultationId, newStatus);

        assertTrue(result);
        verify(consultationRepository, times(1)).changeStatus(consultationId, newStatus);
    }

    @Test
    void testCanBookRoom_success() throws ConsultationException {
        Long roomId = 1L;
        LocalDateTime startTime = LocalDateTime.of(2025, 10, 19, 10, 0);

        when(consultationRepository.canBookRoom(roomId, startTime)).thenReturn(true);

        boolean canBook = consultationService.canBookRoom(roomId, startTime);

        assertTrue(canBook);
        verify(consultationRepository, times(1)).canBookRoom(roomId, startTime);
    }

    @Test
    void testGetAvailableTimesForDoctor() throws ConsultationException {
        Doctor doctor = new Doctor();
        doctor.setId(1L);

        LocalDate date = LocalDate.of(2025, 10, 19);

        Consultation booked = new Consultation();
        booked.setDoctor(doctor);
        booked.setDateTime(LocalDateTime.of(2025, 10, 19, 9, 30));

        when(consultationRepository.consultationList()).thenReturn(List.of(booked));

        List<String> availableTimes = consultationService.getAvailableTimesForDoctor(1L, date);

        // 9:30 should be removed
        assertFalse(availableTimes.contains("09:30"));
        assertTrue(availableTimes.contains("09:00"));
        assertTrue(availableTimes.contains("10:00"));
    }
}
