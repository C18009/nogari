package nogari.loginrestapi.service;

import java.util.List;

import nogari.loginrestapi.vo.OracleMyBatisVo;

public interface OracleMyBatisService {

	int selectCountEmp(OracleMyBatisVo parm1);

	List<OracleMyBatisVo> selectEmpList(OracleMyBatisVo parm1);

	OracleMyBatisVo selectLoginProcess(OracleMyBatisVo parm1) throws Exception;

}