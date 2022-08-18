package common.mailServer.mail.board.dto;

import common.mailServer.util.paging.PagingDto;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("메일로그 조회를 위한 파라미터 객체")
public class MailLogPagingDto extends PagingDto {


}
