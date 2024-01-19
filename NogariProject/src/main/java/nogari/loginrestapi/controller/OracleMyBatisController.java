/**
 * 
 */
package nogari.loginrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nogari.loginrestapi.service.OracleMyBatisService;
import nogari.loginrestapi.vo.OracleMyBatisVo;


@RestController
public class OracleMyBatisController{
	
	@Autowired(required = true)
	private OracleMyBatisService oracleMyBatisService;
	
	@GetMapping("/selectEmpLists")//Get만 가능
    public ResponseEntity<List<OracleMyBatisVo>> selectEmpList(OracleMyBatisVo parm1) {
        List<OracleMyBatisVo> list = oracleMyBatisService.selectEmpList(parm1);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
	
	@GetMapping("/selectTestLoginProcess3") //post만 가능
	public ResponseEntity<OracleMyBatisVo> selectLoginProcess3(OracleMyBatisVo parm1) throws Exception{
		OracleMyBatisVo resultVo = oracleMyBatisService.selectLoginProcess(parm1);
		return ResponseEntity.status(HttpStatus.OK).body(resultVo); 
	}
	
	@GetMapping("/selectTestLoginProcess")
    public ResponseEntity<OracleMyBatisVo> selectLoginProcess(OracleMyBatisVo parm1) throws Exception{
		OracleMyBatisVo resultVo = oracleMyBatisService.selectLoginProcess(parm1);
		return ResponseEntity.status(HttpStatus.OK).body(resultVo);
    }

	@RequestMapping("/selectTestLoginProcess2")//GET과 POST 동시에 다한다
	public ResponseEntity<OracleMyBatisVo> selectLoginProcess2(OracleMyBatisVo parm1) throws Exception{
		OracleMyBatisVo resultVo = oracleMyBatisService.selectLoginProcess(parm1);
		return ResponseEntity.status(HttpStatus.OK).body(resultVo);
	}


}// end 
