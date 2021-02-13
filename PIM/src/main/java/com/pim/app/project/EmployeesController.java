package com.pim.app.project;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import com.pim.domain.entity.Employees;
import com.pim.domain.entity.Room;
import com.pim.domain.entity.meeting;
import com.pim.domain.repository.EmployeesRepository;
import com.pim.domain.service.ProjectService;




@Controller
@RequestMapping("/project")
public class EmployeesController {
	

	@Autowired
	ProjectService projectService;

	private int ID;

	private int IdRoom;

	private String DateF;

	private List<Employees> employees;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelAndView modelAndView) {
		List<Employees> employees = projectService.findAllEmployees();
		this.employees = employees;
		return "employees/login";
	}

	@RequestMapping(value = "create", params = "form", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("EmployeeLogin", new employeeLogin());
		return "employees/createEmployees";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String doneCreate(@RequestParam("name") String name, @RequestParam("pass") String pass) {
		projectService.save(name, pass);
		return "employees/login";
	}

	@RequestMapping(value = "fine", method = RequestMethod.POST)
	public String fine(@RequestParam("date") String date) {
		this.DateF = date ;
		return "redirect:/project/Fine_Meeting";
	}

	@RequestMapping(value = "Fine_Meeting", method = RequestMethod.GET)
	public String Fine_Meeting(Model model, Model model2, Model model3, Model model4) {
		List<Room> rooms = projectService.findRoom();
		List<meeting> roomMeeting = projectService.findMeeting();
		int meetroom = 0 ;
		boolean chack = false ;
		
		for(int i = 0 ; i<roomMeeting.size() ; i++) {
			if(roomMeeting.get(i).getBookDate().equals(this.DateF)) {
				meetroom = i ;
				chack = true;
			}
		}
		
		if(chack == true) {
			for(int i = 0 ; i < rooms.size() ; i++) {
				if(rooms.get(i).getId() == roomMeeting.get(meetroom).getId()) {
					rooms.remove(i);
					break ;
				}
			}
		}	
		
		
		model.addAttribute("whoLogin", projectService.findEmployees(this.ID));
		model2.addAttribute("room", rooms);
		model3.addAttribute("canroom" , this.DateF);
		model4.addAttribute("roombook", roomMeeting);
		return "employees/bookMeeting";
	}

	@RequestMapping(value = "addMeeting", method = RequestMethod.POST)
	public String addMeeting() {
		projectService.saveMeeting(this.DateF, this.ID, this.IdRoom);
		return "redirect:/project/Add_Meeting";
	}
	
	@RequestMapping(value = "Add_Meeting",  method = RequestMethod.GET)
	public String Add_Meeting(Model model, Model model2, Model model3) {
		List<Room> rooms = projectService.findRoom();
		List<meeting> roomMeeting = projectService.findMeeting();

		model.addAttribute("whoLogin", projectService.findEmployees(this.ID));
		model2.addAttribute("room", rooms);
		model3.addAttribute("roombook", roomMeeting);
		return "employees/bookMeeting";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(@RequestParam("name") String name, 
			@RequestParam("pass") String pass, Model model) {
		List<Employees> employees = projectService.findAllEmployees();
		

		boolean login = false;
		int id = 0;
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getName().equals(name) && employees.get(i).getPass().equals(pass)) {
				login = true;
				id = employees.get(i).getId();
				break;
			}
		}
		this.ID = id;
		if (login == true) {
			return "redirect:/project/Log_in";
		} else {
			return "employees/login";
		}

	}

	@RequestMapping(value = "Log_in", method = RequestMethod.GET)
	public String Log_in(Model model, Model model2, Model model3) {
		List<Room> rooms = projectService.findRoom();
		List<meeting> roomMeeting = projectService.findMeeting();

		model.addAttribute("whoLogin", projectService.findEmployees(this.ID));
		model2.addAttribute("room", rooms);
		model3.addAttribute("roombook", roomMeeting);
		return "employees/bookMeeting";
	}

	@RequestMapping(value = "bookRoom/{id}", method = RequestMethod.GET)
	public String bookRoom(@PathVariable("id") int id, Model model) {
		this.IdRoom = id;
		return "redirect:/project/Book_Room";
	}

	@RequestMapping(value = "Book_Room", method = RequestMethod.GET)
	public String Book_Room(Model model, Model model2 ,Model model3 ) {
		model.addAttribute("room", projectService.findIdRoom(this.IdRoom));
		model2.addAttribute("whoLogin", projectService.findEmployees(this.ID));
		model3.addAttribute("canroom" , this.DateF);
		return "employees/bookRoom";
	}

}
