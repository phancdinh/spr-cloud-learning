package me.example.springgson;

import me.example.springgson.dto.RequestDto;
import me.example.springgson.dto.ResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @PostMapping("/demo")
  public ResponseDto demo(@RequestBody RequestDto requestDto) {
    System.out.println(requestDto.getDemo());
    ResponseDto dto = new ResponseDto();
//    dto.setTestData2("2222");
    return dto;
  }
}
