package com.study.springstudy.springmvc.chap04.controller;

import com.study.springstudy.springmvc.chap04.dto.BoardDetailResponseDto;
import com.study.springstudy.springmvc.chap04.dto.BoardWriteRequestDto;
import com.study.springstudy.springmvc.chap04.dto.BoardListResponseDto;
import com.study.springstudy.springmvc.chap04.entity.Board;
import com.study.springstudy.springmvc.chap04.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

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
        // 1. 데이터베이스로부터 게시글 목록 조회
        List<Board> boardList = repository.findAll();

        // 2. 클라이언트에 데이터를 보내기 전에 렌더링에 필요한 데이터만 추출하기
//        List<BoardListResponseDto> bList = new ArrayList<>();
//        for (Board b : boardList) {
//            BoardListResponseDto responseDto = new BoardListResponseDto(b);
//            bList.add(responseDto);
//        }
        List<BoardListResponseDto> bList = boardList.stream()
                .map(b -> new BoardListResponseDto(b))
                .collect(Collectors.toList());

        // 3. JSP파이렝 해당 목록 데이터를 보냄
        model.addAttribute("bList", bList);
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
    public String write(BoardWriteRequestDto dto) {
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

        // 1. 상세조회하고 싶은 글번호를 읽기
        System.out.println("bno = " + bno);

        // 2. 데이터베이스로부터 해당 글번호 데이터 조회하기
        Board board = repository.findOne(bno);
        if (board != null) repository.viewCount(bno);

        // 3. JSP 파일에 조회한 데이터 보내기
        model.addAttribute("b", new BoardDetailResponseDto(board));

        return "board/detail";
    }
}