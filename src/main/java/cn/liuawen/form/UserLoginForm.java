package cn.liuawen.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by 廖师兄
 */
@Data
public class UserLoginForm {

	@NotBlank
	private String username;

	@NotBlank
	private String password;
}
