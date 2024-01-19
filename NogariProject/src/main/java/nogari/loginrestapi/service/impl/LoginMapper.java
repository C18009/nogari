package nogari.loginrestapi.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import nogari.loginrestapi.vo.LoginVo;


@Mapper
public interface LoginMapper {

	List<LoginVo> selectEmpList(LoginVo param1);

	int selectCountEmp(LoginVo param1);

	int selectCountEmpPw(LoginVo paramVo1);

	void updateFalieCnt(LoginVo paramVo1);

	void updateLoginUseYn(LoginVo paramVo1);

}//end 
