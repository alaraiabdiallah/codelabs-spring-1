package id.gits.springcodelabs1.Responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Setter
@Getter
public class ApiErrorResponse {

    private Integer code;
    private Boolean status;
    private String message;
    private List<ApiSubError> subErrors;


    private ApiErrorResponse() {
        this.status = false;
        this.message = "Unexpected error";
    }

    public ApiErrorResponse(Integer code) {
        this();
        this.code = code;
    }

    public ApiErrorResponse(Integer code, String message) {
        this();
        this.code = code;
        this.message = message;

    }
}
