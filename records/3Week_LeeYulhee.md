## Title: [3Week] 이율희

### 미션 요구사항 분석 & 체크리스트

---

**[필수 미션]**

- 네이버클라우드플랫폼을 통한 배포(도메인 없이, IP로 접속)
- 호감표시/호감사유변경 후, 개별 호감표시건에 대해서, 3시간 동안은 호감취소와 호감사유변경을 할 수 없도록 작업

**[추가 미션]**

- 알림기능 구현

### 3주차 미션 요약

---

### 접근 방법 ###

**[네이버클라우드 플랫폼을 통한 배포]**
  - [X] 강의 따라하기

**[호감표시/호감사유변경 후, 개별 호감표시건에 대해서, 3시간 동안은 호감취소와 호감사유변경 불가]**
  - [X] 어느 클래스에 구현해야 하는지 내용 확인 및 뷰에서 남은 시간을 계산하는 부분을 어디서 불러오는지 확인
  - [X] application.yml에 modifyCoolTime 시간 범위 설정하고, AppConfig에서 setLikeablePersonModifyCoolTime로 설정 및 genLikeablePersonModifyUnlockDate 설정
  - [X] Service 쪽에서 수정에 관한 성공/실패를 return하는 메서드 확인 후 해당 부분에 F-3으로 실패 케이스 추가
  - [X] Service 쪽에서 취소에 관한 성공/실패를 return하는 메서드 확인 후 해당 부분에 F-3으로 실패 케이스 추가
  - [X] Entity에 추가한 getModifyUnlockDateRemainStrHuman이 뷰에 전달되는 내용 -> 현재 시간과 수정/삭제 가능한 시간 사이의 차 계산해서 return

**[알림기능 구현]**
  - [X] 어느 클래스에 어떤 내용을 구현해야 하는지 확인
  - [X] 일단 페이지에서 알람 모양 누르면(usr/notification/list로 이동되면) 인스타 아이디가 없을 때 기존 usr/instaMember/connec URL로 연결되는 부분 usr/instaMember/connectByApi 연결되게 변경
  - [X] notification의 list.html에서 notification의 list가 비어있지 않은 경우에만 알림 메세지가 뜨도록 th:if="${!#lists.isEmpty(notifications)}" 추가
  - [X] NotificationService에 Like가 발생하면 정보가 NotificationRepository에 저장되는 메서드 구현
  - [X] NotificationController에 LikeablePerson도 받아서 View에 전달할 수 있도록 작성(LikeablePersonService에도 메서드 추가)
  - [X] notification의 list.html에 성별과 사유가 전달되도록 수정
  - [X] modifyAttractiveType 메서드 구현
  - [X] notification의 list.html에 하드 코딩한 부분 수정 및 여러 건 발생했을 때 오류나 중복 등의 버그 수정
  - [X] readDate 기능 추가
  - [X] 호감 수정 시 기존 호감이 안 불러와지는 오류 발견 -> LikeablePerson에 int 매개변수를 받는 getAttractiveTypeDisplayName 생성해서 해결

### 특이사항 ###

**[호감표시/호감사유변경 후, 개별 호감표시건에 대해서, 3시간 동안은 호감취소와 호감사유변경 불가]**

  - 버튼이 기본적으로 비활성화 되어 있어서 해당 부분 활성화 후 테스트 완료

**[알림기능 구현]**

  - 전반적으로 어디에 구현해야 하는지는 알겠는데 클래스들을 서로 연결하는 과정이나 View로 넘기는 과정이 너무 어려워서 ChatGPT의 도움을 받으며 작성
  - ChatGPT도 오류 코드를 많이 써서 해당 부분들을 찾아가며 수정하느라 시간이 굉장히 오래 걸리고 어려웠음