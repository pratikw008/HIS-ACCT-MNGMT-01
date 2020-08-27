package com.his.admin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.his.admin.model.PlanAccountState;
import com.his.admin.model.PlanEntity;
import com.his.admin.repository.PlanEntityRepository;

@SpringBootApplication
public class HisAdminApplication implements CommandLineRunner{

	private PlanEntityRepository planRepo;
	
	public HisAdminApplication(PlanEntityRepository planRepo) {
		this.planRepo = planRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(HisAdminApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<PlanEntity> planEntities = Arrays.asList(
												new PlanEntity(101l,"SNAP","Food Stamp",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),PlanAccountState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(102l,"CCAP","Child Care",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),PlanAccountState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(103l,"MEDICARE","Medicare",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),PlanAccountState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(104l,"MEDICAIDE","Medicaide",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),PlanAccountState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(105l,"ASD","ASD",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),PlanAccountState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(106l,"BSD","BSD",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),PlanAccountState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(107l,"CSD","CSD",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),PlanAccountState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(108l,"DSD","DSD",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),PlanAccountState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(109l,"ESD","ESD",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),PlanAccountState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(110l,"FSD","FSD",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),PlanAccountState.ACTIVE,LocalDateTime.now(),null),
												new PlanEntity(111l,"GSD","GSD",LocalDate.of(2020, 8, 26),LocalDate.of(2021,8, 26),PlanAccountState.ACTIVE,LocalDateTime.now(),null)
				);
		planRepo.saveAll(planEntities);
	}
}
