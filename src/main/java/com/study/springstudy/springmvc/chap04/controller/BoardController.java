package com.study.springstudy.springmvc.chap04.controller;

import com.study.springstudy.springmvc.chap04.dto.BoardDto;
import com.study.springstudy.springmvc.chap04.entity.Board;
import com.study.springstudy.springmvc.chap04.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository repository;

//    @Autowired
//    public BoardController(BoardRepository repository) {
//        this.repository = repository;
//    }

    // 1. 목록 조회 요청 (/board/list : GET)
    @GetMapping("/list")
    public String list(Model model) {
        System.out.println("list@@@@@@@@@@@@@@");
        List<Board> boardList = repository.findAll();

        model.addAttribute("bList", boardList);
        return "board/list";
    }

    // 2. 게시글 쓰기 양식 화면 열기 요청 (/board/write : GET)
    @GetMapping("/write")
    public String writeList() {
        System.out.println("Tq");

        return "board/write";
    }

    // 3. 게시글 등록 요청 (/board/write : POST)
// -> 목록조회 요청 리다이렉션
    @PostMapping("/write")
    public String write(BoardDto dto) {
        // 1. 브라우저가 등록한 게시물 내용 읽기
        System.out.println(dto);
        // 2. 해당 게시글을 데이터베이스에 저장하기 위해 엔터티 클래스로 전환
        Board b = dto.toEntity();
//        Board b = new Board(dto);
        // 3. 데이터베이스 저장 명령
        repository.save(b);

        return "redirect:/board/list";
    }

    // 4. 게시글 삭제 요청 (/board/delete : GET)
    // -> 목록조회 요청 리다이렉션
    @GetMapping("/delete")
    public String delete(int bno) {

        repository.delete(bno);

        return "redirect:/board/list";
    }

    // 5. 게시글 상세 조회 요청 (/board/detail : GET)
    @GetMapping("/detail")
    public String detail(int bno, Model model) {
        Board board = repository.findOne(bno);

        model.addAttribute("bList", board);

        return "board/detail";
    }
}