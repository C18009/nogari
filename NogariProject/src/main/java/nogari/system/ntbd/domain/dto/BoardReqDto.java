package nogari.system.ntbd.domain.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("BoardReqDto")
public class BoardReqDto {

    @NotNull(message = "필수값")
    String ntbdCd;
    String fileCd;
    String ntbdDiv;
    String topYn;
    String postInDate;
    String postOutDate;
    String postNm;
    String postCont;
    String userId;
}