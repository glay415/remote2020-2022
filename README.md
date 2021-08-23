# Study
공부 일지
- 1일차 back->security-practice
jwt를 사용하지않고 로그인 회원가입 api를 만들어보기로함
회원가입 기능완성
/시큐리티 loginform에서 값을받아오는 방식이 request.getParameter()이기 때문에 body에 json을 실어서 보내면 block됨
해결방안으로 username으로 db에서 값을조회한후 password를 디코드하여 직접 비교하여 연결해주기로함
/로그인 기능자체는 구혔했지만 loginform으로 username과 password를 전송하는 방법을 모르겠음

->jwt를 사용한 옛날 프로젝트에서 찾은 방법인데
loginform을 disable해주고 ObjectMapper를 활용해 json데이터를 파싱한 UsernamePasswordAuthenticationFilter를만들어 새로 갈아끼면 됨
하지만 이해가 잘 안되기때문에 이번 프로젝트는 잠시 접어두기로함

오늘의 의문점: security는 도데체 어떻게 공부해야할까?
