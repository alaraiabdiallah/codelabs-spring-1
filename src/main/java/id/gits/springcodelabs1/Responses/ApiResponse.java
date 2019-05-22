package id.gits.springcodelabs1.Responses;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ApiResponse<T> {

    private Integer code;

    private Boolean status;

    private String message;

    private T data;

    public ApiResponse(Integer code) {
        this.code = code;
        this.mapStatus();
        this.mapMessage();
    }

    public ApiResponse(Integer code,  T data) {
        this.code = code;
        this.data = data;
        this.mapStatus();
        this.mapMessage();
    }

    public ApiResponse(Integer code, T data, String message) {
        this.code = code;
        this.message = message;
        this.data    = data;
        this.mapStatus();
    }



    private void mapStatus(){
        if (code == 200) this.setStatus(true);
        else this.setStatus(false);
    }

    private void mapMessage(){
        switch (this.code){
            case 200:
                this.setMessage("Request processed successfully");
                break;
            case 404:
                this.setMessage("Not found");
                break;
        }
    }
}
