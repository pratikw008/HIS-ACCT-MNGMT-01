package com.his.admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnlockAccount {
	
	private String email;
	
	private String tempPwd;
	
	private String newPwd;
	
	private String confirmPwd;
}
