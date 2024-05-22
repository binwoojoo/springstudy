package com.study.springstudy.springmvc.chap04.controller;

import com.study.springstudy.springmvc.chap04.common.Page;
import com.study.springstudy.springmvc.chap04.dto.BoardWriteRequestDto;
import com.study.springstudy.springmvc.chap04.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

//    private final BoardRepository repository;
    private final BoardService repository;

//    @Autowired
//    public BoardController(BoardRepository repository) {
//        this.repository = repository;
//    }

    // 1. 목록 조회 요청 (/board/list : GET)
    @GetMapping("/list")
    public String list(Page page,Model model) {

        // 서비스에게 조회 요청 위임
        // JSP파일에게 해당 목록 데이터를 보냄
        model.addAttribute("bList", repository.findAll(page));

        return "board/list";
    }

    // 2. 게시글 쓰기 양식 화면 열기 요청 (/board/write : GET)
    @GetMapping("/write")
    public String writeList() {

        return "board/write";
    }

    // 3. 게시글 등록 요청 (/board/write : POST)
// -> 목록조회 요청 리다이렉션
    @PostMapping("/write")
    public String write(BoardWriteRequestDto dto) {

        repository.save(dto);

        return "redirect:/board/list";
    }

    @GetMapping("/delete")
    public String delete(int bno) {

        repository.delete(bno);

        return "redirect:/board/list";
    }

    // 5. 게시글 상세 조회 요청 (/board/detail : GET)
    @GetMapping("/detail")
    public String detail(int bno, Model model) {

        model.addAttribute("b", repository.findOne(bno));

        return "board/detail";
    }
}