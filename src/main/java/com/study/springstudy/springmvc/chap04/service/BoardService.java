package com.study.springstudy.springmvc.chap04.service;

import com.study.springstudy.springmvc.chap04.common.Search;
import com.study.springstudy.springmvc.chap04.dto.BoardDetailResponseDto;
import com.study.springstudy.springmvc.chap04.dto.BoardFindAllDto;
import com.study.springstudy.springmvc.chap04.dto.BoardListResponseDto;
import com.study.springstudy.springmvc.chap04.dto.BoardWriteRequestDto;
import com.study.springstudy.springmvc.chap04.entity.Board;
import com.study.springstudy.springmvc.chap04.mapper.BoardMapper;
import com.study.springstudy.springmvc.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardmapper;

    // 목록 조회 중간처리
    public List<BoardListResponseDto> findAll(Search page) {
        List<BoardFindAllDto> boardList = boardmapper.findAll(page);

        // 조회해온 게시물 리스트에서 각 게시물들의 조회수   를 확인하여
        // 조회수가 5이상인 게시물에 특정 마킹
        List<BoardListResponseDto> bList = boardList.stream()
                .map(b -> new BoardListResponseDto(b))
                .collect(Collectors.toList());

        return bList;
    }

    // 등록 요청 중간처리
    public void save(BoardWriteRequestDto dto, HttpSession session) {

        Board b = dto.toEntity();
        // 계정명을 엔터티에 추가 - 세션에서 계정명 가져오기

        b.setAccount(LoginUtil.getLoggedUserAccount(session));

        boardmapper.save(b);

    }

    public void delete(int bno) {
        boardmapper.delete(bno);
    }

    public BoardDetailResponseDto findOne(int bno) {
        Board board = boardmapper.findOne(bno);

        if (board != null) boardmapper.viewCount(bno);

//        List<Reply> replies = replyMapper.findAll(bno);

        BoardDetailResponseDto responseDto = new BoardDetailResponseDto(board);
//        responseDto.setReplies(replies);

        return responseDto;
    }

    public int getCount(Search page) {
        return boardmapper.getCount(page);
    }

}
