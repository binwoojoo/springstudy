package com.study.springstudy.database.chap01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringJdbcTest {

    @Autowired
    SpringJdbc springJdbc;

    // 단위 테스트 프레임워크: JUnit5
    // 테스트 == 단언 (Assertion)
    @Test
    @DisplayName("사람의 정보를 입력하면 데이터베이스에 반드시 저장되어야 한다")
    void saveTest() {
        // gwt 패턴
        // given: 테스트에 주어질 데이터
        Person p = new Person(77, "칠칠이", 7);
        // when: 테스트 상황
        int result = springJdbc.save(p);
        // then: 테스트 결과 단언
        assertEquals(1, result);
    }

    @Test
    @DisplayName("아이디가 주어지면 해당 아이디의 사람정보가 데이터베이스로 부터 삭제되어야한다")
    void deleteTest() {
        //given
        long id = 77;
        //when
        boolean flag = springJdbc.delete(id);
        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("새로운 이름과 나이를 전달하면 사람의 정보가 데이터베이스에서 수정된다")
    void modifyTest() {
        //given
        Person p = new Person(99, "페이커", 28);
        //when
        boolean update = springJdbc.update(p);
        //then
        assertTrue(update);
    }

    @Test
    @DisplayName("사람 정보를 전체 조회하면 결과 건수는 4건이며, 첫번째 사람의 이름은 페이커이다")
    void findAllTest() {
        //given

        //when
        List<Person> people = springJdbc.findAll();
        //then
        people.forEach(System.out::println);

        assertEquals(4, people.size());
        assertEquals("페이커", people.get(0).getPersonName());
    }

    @Test
    @DisplayName("사람 정보를 아이디로 단일 조회시 아이디가 200인 사람의 이름은 이찬희이고" +
            "나이는 27이다 ")
    void findOneTest() {
        //given
        long id = 200;
        //when
        Person person = springJdbc.findOne(id);
        //then
        assertNotNull(person);
        assertEquals("이찬희", person.getPersonName());
        assertEquals(27, person.getPersonAge());
    }

}