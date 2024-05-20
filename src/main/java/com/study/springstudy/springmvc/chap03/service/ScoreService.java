package com.study.springstudy.springmvc.chap03.service;

import com.study.springstudy.springmvc.chap03.dto.ScoreDetailResponseDto;
import com.study.springstudy.springmvc.chap03.dto.ScoreListResponseDto;
import com.study.springstudy.springmvc.chap03.dto.ScorePostDto;
import com.study.springstudy.springmvc.chap03.entity.Score;
import com.study.springstudy.springmvc.chap03.repository.ScoreRepository;
import com.study.springstudy.springmvc.chap03.dto.ScoreModifyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
  컨트롤러와 레파지토리 사이에 위치하여 중간 처리를 담당
  - 트랜잭션 처리, 데이터 가공 처리...
  - 의존 관계
  Controller -> Service -> Repository
 */
// 잡일 담당
@RequiredArgsConstructor
@Service
public class ScoreService {

    private final ScoreRepository repository;

    // 목록 조회 중간처리
    // - DB에서 조회한 성적 조회 목록은 민감한 정보를 모두 포함하고있는데
    //   이를 컨트롤러에게 직접 넘기면 보안상 불필요한 정보까지 화면으로
    //   넘어갈 수 있기 떄문에 숨길건 숨기고 뺄건 뺴는 데이터 가공을 처리한다
    public List<ScoreListResponseDto> getList(String sort) {
        List<Score> scoreList = repository.findAll(sort);
        return scoreList.stream()
                .map(score -> new ScoreListResponseDto(score))
                .collect(Collectors.toList());
    }

    // 저장 중간처리
    public boolean insert(ScorePostDto dto) {
        return repository.save(new Score(dto));
    }

    // 삭제 중간처리
    public boolean deleteScore(long stuNum) {
        return repository.delete(stuNum);
    }

    // 개별조회 중간처리
    public ScoreDetailResponseDto retrieve(long stuNum) {
        Score score = repository.findOne(stuNum);
        int[] result = repository.findRankByStuNum(stuNum);
        ScoreDetailResponseDto dto
                = new ScoreDetailResponseDto(score, result[0], result[1]);
        return dto;
    }

    // 수정 완료를 위해 서비스 클래스에서
    // dto를 entity  연걸 및 백업
    public void update(ScoreModifyRequestDto dto) {
        repository.updateScore(new Score(dto));
    }
}
