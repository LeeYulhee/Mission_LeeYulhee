## Title: [4Week] 이율희

### 미션 요구사항 분석 & 체크리스트

---

**[필수 미션]**

- 네이버클라우드플랫폼을 통한 배포, 도메인, HTTPS 까지 적용
- 내가 받은 호감리스트(/usr/likeablePerson/toList)에서 성별 필터링기능 구현

**[선택 미션]**

- 젠킨스를 통해서 리포지터리의 main 브랜치에 커밋 이벤트가 발생하면 자동으로 배포가 진행되도록
- 내가 받은 호감리스트(/usr/likeablePerson/toList)에서 호감사유 필터링기능 구현
- 내가 받은 호감리스트(/usr/likeablePerson/toList)에서 정렬기능

### 4주차 미션 요약

---

### 접근 방법 ###

**[네이버클라우드플랫폼을 통한 배포, 도메인, HTTPS 까지 적용]**
  - [X] 강의 따라하기

**[내가 받은 호감리스트(/usr/likeablePerson/toList)에서 성별 필터링기능 구현]**
  - [X] 힌트를 기반으로 stream 기본 구현
  - [X] stream의 filter 기능을 이용해서 gender와 매개변수로 들어온 gender가 같은 경우만 필터링
  - [X] 후에 확인해보니 성별 필터링 후 다시 전체를 누르면 아무 것도 안 뜨는 오류 발생 -> 해결
    - gender가 빈 문자열로 들어온 경우에도 필터링 적용된 것이 원인 -> !gender.isEmpty()를 사용해 해결

**[내가 받은 호감리스트(/usr/likeablePerson/toList)에서 호감사유 필터링 기능, 정렬 기능 구현]**
  - [X] 힌트를 기반으로 stream 기본 구현
  - [X] stream의 filter 기능을 이용해서 attractiveTypeCode와 매개변수로 들어온 attractiveTypeCode가 같은 경우만 필터링
  - [X] 각 경우 별 sortCode를 URL에서 확인(1, 2, 3, 4, 5, 6)
  - [X] 힌트로 기본 구현되어 있는 stream에 해당하는 조건들을 넣음(최신순은 역순으로 하는 등)
  - [X] 인기 많은 순/적은 순으로 정렬이 적용 안 되는 오류 발생 -> 해결
    - to와 from이 헷갈려서 getFromLikeablePeople의 size를 가져옴 -> 테스트와 DB 등으로 확인 후 getToLikeablePeople의 size로 수정

### 특이사항 ###
- Stream은 여전히 어려운 것 같았다.
- 엔티티 간의 관계와 서로 통해서 들어가는 과정이 여전히 헷갈리는 경우가 많았다.
- 혼자서 구현하려고 하니, 대략 이런 위치에 무엇이 들어가야 하는지는 그려지는데 구현하는 과정이 생각보다 어려웠다.
- 동적쿼리도 sbb에서 배웠어서 대략은 그려지는데 구현하려니 손을 대야 할 곳이 너무 많은 것 같아 여기저기 건들다가 실패했다.