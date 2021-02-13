package com.pim.domain.service;

import java.util.Calendar;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pim.app.project.RoomForm;
import com.pim.app.project.employeeLogin;
import com.pim.domain.entity.Employees;
import com.pim.domain.entity.Room;
import com.pim.domain.entity.meeting;
import com.pim.domain.repository.EmployeesRepository;
import com.pim.domain.repository.RoomMeetingRepository;
import com.pim.domain.repository.RoomRepository;

@Service
@Transactional
public class ProjectService {

	@Autowired
	EmployeesRepository employeesRepository;

	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	RoomMeetingRepository roomMeetingRepository ;

	public void save(String name, String pass) {
		Date date = Calendar.getInstance().getTime();
		Employees employees = new Employees();
		employees.setName(name);
		employees.setPass(pass);
		employees.setCreatedDate(date);
		employees.setUpdatedDate(date);
		employeesRepository.save(employees);
	}
	
	public void saveMeeting(String dateBook, int idE , int idR) {
		Date date = Calendar.getInstance().getTime();
		meeting roomMeeting = new meeting();  
		roomMeeting.setRoom(roomRepository.getOne(idR)); 
		roomMeeting.setEmployees(employeesRepository.getOne(idE));
		roomMeeting.setBookDate(dateBook);
		roomMeeting.setCreatedDate(date);
		roomMeeting.setUpdatedDate(date);
		roomMeetingRepository.save(roomMeeting);
	}
	
	public void saveRoom(Date name) {
		Employees employees = new Employees();
		employeesRepository.save(employees);
	}

	public List<Employees> findAllEmployees() {
		return employeesRepository.findAll();
	}

	public RoomForm findIdRoom(int id) {
		Room room = roomRepository.getOne(id);
		return new RoomForm(room.getId(), room.getBranch(), room.getBuilding(), room.getFloor(), room.getCapacity(),
				room.getName(), room.getStatuRoom(), room.getBookDate());
	}
	
	public List<Room> findRoom() {
		return roomRepository.findAll();
	}
	public List<meeting> findMeeting() {
		return roomMeetingRepository.findAll();
	}

	public employeeLogin findEmployees(int id) {
		Employees EmployeeLogin = employeesRepository.getOne(id);
		return new employeeLogin(EmployeeLogin.getId(), EmployeeLogin.getName(), EmployeeLogin.getPass());
	}

}
