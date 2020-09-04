package com.his;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.his.model.AccountStatus;
import com.his.model.DeleteState;
import com.his.model.Gender;
import com.his.model.PlanEntity;
import com.his.model.UserEntity;
import com.his.repository.PlanEntityRepository;
import com.his.repository.RoleRepository;
import com.his.repository.UserRepository;

@SpringBootApplication
public class HisAdminApplication implements CommandLineRunner{

	private PlanEntityRepository planRepo;
	
	private UserRepository userRepo;
	
	private RoleRepository roleRepo;

	public HisAdminApplication(PlanEntityRepository planRepo, UserRepository userRepo, RoleRepository roleRepo) {
		super();
		this.planRepo = planRepo;
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(HisAdminApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<PlanEntity> planEntities = Arrays.asList(
												new PlanEntity(101l,"SNAP","Food Stamp",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),DeleteState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(102l,"CCAP","Child Care",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),DeleteState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(103l,"MEDICARE","Medicare",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),DeleteState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(104l,"MEDICAIDE","Medicaide",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),DeleteState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(105l,"ASD","ASD",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),DeleteState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(106l,"BSD","BSD",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),DeleteState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(107l,"CSD","CSD",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),DeleteState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(108l,"DSD","DSD",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),DeleteState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(109l,"ESD","ESD",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),DeleteState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(110l,"FSD","FSD",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),DeleteState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(111l,"GSD","GSD",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),DeleteState.ACTIVE,LocalDateTime.now(),null)
				);
		planRepo.saveAll(planEntities);
		
		
		  List<UserEntity> entities = Arrays.asList( new UserEntity(1l, "Virat", "Kohli", "vk@g.com", "vk123",Gender.MALE, 
				  roleRepo.findById(102l).get(), AccountStatus.UNLOCKED, DeleteState.ACTIVE,
				  						LocalDateTime.now(), null),
				  		 new UserEntity(2l, "Rohit", "Sharma", "hitman@g.com", "hitman123",Gender.MALE, 
				  				roleRepo.findById(101l).get(), AccountStatus.UNLOCKED, DeleteState.ACTIVE,
	  						LocalDateTime.now(), null));
		  
		  userRepo.saveAll(entities);
	}
}
