package com.juno.game.controller;

import com.juno.game.api.common.CommonEnum;
import com.juno.game.api.dto.CommonApi;
import com.juno.game.controller.exception.CommonException;
import com.juno.game.controller.exception.CommonExceptionEnum;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<CommonApi> test(){

        CommonApi api = new CommonApi(CommonEnum.OK, new TestObject());
        return ResponseEntity.ok(api);
    }

    @GetMapping("/exception")
    public ResponseEntity<CommonApi> exce() throws Exception {
        CommonApi api = new CommonApi(CommonEnum.OK, new TestObject());

        //예상된 Exception 발생! 400으로 반환해보자
        if(true) throw new CommonException(CommonExceptionEnum.BAD_REQUEST);

        return ResponseEntity.ok(api);
    }

    //test용 객체222
    @Data
    public class TestObject{
        private Integer idx = 1;
        private String name = "test1";
    }
}
