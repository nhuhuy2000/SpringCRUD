package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Departs;
import com.example.demo.domain.Staffs;
import com.example.demo.dto.StaffDTO;
import com.example.demo.service.ServiceDepart;
import com.example.demo.service.StaffService;

@Controller
@RequestMapping("admin/staffs")
public class StaffController {
	@Autowired
	StaffService staffService;
	
	@Autowired
	ServiceDepart serviceDepart;
	@RequestMapping("list")
	public String listStaff(ModelMap model,@RequestParam(name = "name" , required = false) String name) {
		List<Staffs> list = null;
		if(StringUtils.hasText(name)) {
			list =  staffService.findByNameContaining(name);
		}else {
			list = staffService.findAll();
		}
		model.addAttribute("liststaff", list);
		return "admin/liststaffs";
	}
	@GetMapping("/")
	public String addOrEdit(ModelMap model) {
		StaffDTO staff = new StaffDTO();
		model.addAttribute("STAFFDTO", staff);
		model.addAttribute("ACTION", "admin/staffs/saveOrUpdate");
		return "admin/staffs";
	}
	@PostMapping("/saveOrUpdate")
	public String save(ModelMap model, @ModelAttribute("STAFFDTO") StaffDTO dto) {
		Optional<Staffs> optionalStaff = staffService.findById(dto.getId());
		Staffs staff = null;
		String image = "Logo.png";
		Path path = Paths.get("uploads/");
		if (optionalStaff.isPresent()) {
			if(dto.getPhoto().isEmpty()) {
				image = optionalStaff.get().getPhoto();
			}else {
				try {
					InputStream inputStream = dto.getPhoto().getInputStream();
					Files.copy(inputStream, path.resolve(dto.getPhoto().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
					image = dto.getPhoto().getOriginalFilename().toString();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
		} else {
			if(!dto.getPhoto().isEmpty()) {
				try {
					InputStream inputStream = dto.getPhoto().getInputStream();
					Files.copy(inputStream, path.resolve(dto.getPhoto().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
					image = dto.getPhoto().getOriginalFilename().toString();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		staff = new Staffs(dto.getId(), dto.getName(), dto.isGender(), dto.getBirthday(), image, dto.getEmail()
				, dto.getPhone(), dto.getSalary(), dto.getNotes(), new Departs(dto.getDepartId() ,"" , null), null);
		staffService.save(staff);
		return "admin/staffs";
	}
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") String id) {
		Optional<Staffs> opStaff = staffService.findById(id);
		StaffDTO dto = null;
		if(opStaff.isPresent()) {
			Staffs st = opStaff.get();
			File file = new File("uploads/" + st.getPhoto());
			FileInputStream input;
			try {
				input = new FileInputStream(file);
				MultipartFile multipartPhoto = new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
				dto = new StaffDTO(st.getId(), st.getName(), st.isGender(), 
						st.getBirthday(), multipartPhoto, st.getEmail(), 
						st.getPhone() , st.getSalary(), st.getNotes(), st.getDeparts().getId());
				
			}catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}catch (Exception e) {
				// TODO: handle exception
			}
			model.addAttribute("STAFFDTO", dto);
		}else {
			model.addAttribute("STAFFDTO", new StaffDTO());
		}
		
		model.addAttribute("ACTION", "admin/staffs/saveOrUpdate");
		return "admin/staffs";
	}
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") String id) {
		staffService.deleteById(id);
		model.addAttribute("liststaff", staffService.findAll());
		return "admin/liststaffs";
		
	}
	@ModelAttribute(name = "DEPARTS")
	public List<Departs> getAllDeparts(){
		return staffService.findAllDeparts();
	}
	@GetMapping("list/page")
	public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Staffs> page = staffService.findAll(pageable);
		int totalPages = page.getTotalPages();
		model.addAttribute("liststaff_page", page);
		return "admin/liststaffspage";
	}
}
