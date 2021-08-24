# Study
-----------------------------------

security동작과정중 - loginProcessingUrl 이 호출되면 UserDetailService가 유저객체를 찾아 UserDetails로 넘겨주는부분이있다.

Security Session <- PrincipalDetails <- UserDetails <- UserEntity (<-세션에 유저정보가 들어가는 과정

이를 활용하여 controller에서 로그인 로직을 만들어 UserEntity에 유저객체를 리턴해주면 @RequsetBody로 로그인을 진행할 수 있다. 

---------------------------------------------------------------------------------------------------------------------------------
