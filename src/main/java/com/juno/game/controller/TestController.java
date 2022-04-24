package com.juno.game.controller;

import com.juno.game.api.common.CommonEnum;
import com.juno.game.api.dto.CommonApi;
import com.juno.game.controller.exception.CommonException;
import com.juno.game.controller.exception.CommonExceptionEnum;
import com.juno.game.entity.UserEntity;
import com.juno.game.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final UserService userService;

    /*
     * controller 반환하는 방법
     */
    @GetMapping("/test")
    public ResponseEntity<CommonApi> test(){

        CommonApi api = new CommonApi(CommonEnum.OK, new TestObject());
        return ResponseEntity.ok(api);
    }

    /*
     * exception 처리하는 방법
     */
    @GetMapping("/exception")
    public ResponseEntity<CommonApi> exce() throws Exception {
        CommonApi api = new CommonApi(CommonEnum.OK, new TestObject());

        //예상된 Exception 발생! 400으로 반환해보자
        if(true) throw new CommonException(CommonExceptionEnum.BAD_REQUEST);

        return ResponseEntity.ok(api);
    }

    /*
     * service에서 데이터 받아와서 반환하는 방법
     */
    @GetMapping("/user")
    public ResponseEntity<CommonApi> user(){
        List<UserEntity> data = userService.user();
        CommonApi api = new CommonApi("200", "정상 실행", data);
        return ResponseEntity.ok(api);
    }

    //test용 객체
    @Data
    public class TestObject{
        private Integer idx = 1;
        private String name = "test1";
    }
}
