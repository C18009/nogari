package nogari.usermngrestapi.service.impl;

import org.apache.ibatis.annotations.Mapper;

import nogari.usermngrestapi.vo.UserMngVo;


@Mapper
public interface UserMngMapper {

	void insertUserMng(UserMngVo parm1);

	void updateUserMng(UserMngVo param);

	void updateUserMngDelYn(UserMngVo param);

	void deleteUserMngDel(UserMngVo param);

}//end 
