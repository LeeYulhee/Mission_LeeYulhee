## Title: [1Week] 이율희

### 미션 요구사항 분석 & 체크리스트

---

### 필수 미션 : 호감 상대 삭제 ###

- **목표**

    - 호감 목록 페이지에서 특정 항목의 삭제 버튼을 누르면, 해당 항목은 삭제되어야 한다.

        - 삭제를 처리하기 전에 해당 항목에 대한 소유권이 본인(로그인한 사람)에게 있는지 체크해야 한다.
    - 삭제 후 다시 호감 목록 페이지로 돌아와야 한다.

        - rq.redirectWithMsg 함수 사용

**[LikeablePerson Controller & Service & Repository]**
- [X] list.html에 구현되어 있는 삭제 버튼에 연결된 URL 확인
- [X] Controller에 GetMapping으로 삭제 기능에 대한 URL 연결
- [X] Controller의 delete 메서드에 LikeablePerson에 대한 객체 생성 후, LikeablePerson에 대한 정보 대입
- [X] Controller의 delete 메서드에서 객체에 대한 정보가 들어오면 Service의 delete 메서드 실행
- [X] Service에 delete 메서드 생성하고 Repository의 delete 메서드(이건 따로 생성할 필요 없음) 실행

**[Rq 및 RsData에 대한 내용 파악 후 맞춰서 재구현]**
- [X] Rq 및 RsData에 대한 내용 및 Member 클래스쪽 구현 내용 보며 파악
- [X] Controller의 delete 메서드의 return 값을 rq.redirectWithMsg로 변경
- [X] 삭제를 처리하기 전에 로그인한 사람과 해당 호감 상대를 등록한 사람이 같은지 확인하는 과정 필요

### 1주차 미션 요약

---

**[접근 방법]**

- list.html에 th:href="@{|delete/${likeablePerson.id}|} 부분 확인해서 해당 부분을 Controller의 URL로 매핑
- {likeablePerson.id} 부분을 받기 위해 @PathVariable로 id 값을 받고, 매개변수로 넣음
- return redirect: 로 list URL 매핑
- SBB의 질문, 답변 삭제하는 부분을 참고해 Question question = this.questionService.getQuestion(id) 처럼 Service에서 id로 정보를 받아 객체 생성
- SBB를 따라 throw Exception을 작성했지만 오류 나서 다시 지우고, this.likeablePersonService.delete(likeableperson) 작성
- 오류를 따라 Service로 이동해 this.likeablePersonRepository.delete(likeablePerson) 작성
- 큰 흐름 및 대략적인 메서드를 작성하기 위해 위의 과정을 실행했으나 당연하게도 오류 발생 및 미션 조건 미충족
- Controller에서 delete 메서드의 return을 rq.redirectWithMsg 변경
- 오류를 따라서 rq 클래스 및 RsData 클래스 확인, 이미 해당 클래스들로 구현되어 있는 Member쪽 클래스들 확인
- 오류를 하나씩 수정해가며 챗GPT 및 SBB, 복습 강의들 참고. 디버깅으로 URL로 잘 이동되는지 확인하고 DB에 삭제 여부 확인해가며 진행

    - 이 부분은 오류를 수정하며 이해가 안 가는 부분들을 주먹구구식으로 풀어 나감


**[특이사항]**

- SBB를 위주로 공부했어서 강사님이 구현하며 리팩토링한 코드가 익숙치 않아 어려웠다.
- 시간이 촉박해서 필요한 부분들만 빠르게 훑으며 넘겼는데 Rq 클래스와 RsData에 대해서는 시간이 있을 때 다시 한 번 제대로 공부해야겠다.
- SBB 따라쓰기를 틈틈이 할 필요성을 느꼈다.

**[Refactoring]**
- 전반적으로 지저분한 부분이나 더 깔끔하게 표현할 수 있는 부분들 확인
- 메서드나 기능들의 구현이 알맞은 클래스에 위치하고 있는지