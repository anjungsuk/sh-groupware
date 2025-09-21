package com.shlogis.groupware.groupwareapi.sample.controller;


import com.shlogis.groupware.groupwareapi.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Sample Controller
 *
 *
 * @author  junguKang
 * @version
 * @since   ${DATE}
 */

@RestController
@RequestMapping("/api/sample")
@RequiredArgsConstructor
public class sampleController {

    private final SampleService sampleService;

    /**
     * 조회 - sample
     *
     * @param id 사용자 ID
     * @return 사용자 이름
     */
    @GetMapping("/{id}")
    public void getUser(@PathVariable Long id) {
        sampleService.getAllUsers();
    }

    /**
     * 등록 - sample
     *
     * @param name 사용자 이름
     * @return 등록된 사용자 ID
     */
    @PostMapping
    public void createUser(@RequestParam String name) {


    }

    /**
     * 수정 - sample
     *
     * @param id 사용자 ID
     * @param name 새로운 이름
     * @return 수정 결과 메시지
     */
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestParam String name) {

        return "User not found";
    }

    /**
     *  삭제 - sample
     *
     * @param id 삭제 ID
     * @return 삭제 결과 메시지
     */
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        return "User not found";
    }
}
