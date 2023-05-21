# codesite  
jsp 프레임워크 프로젝트  
------------------------------------------------  
<h4>환경<h4>
<p>spring boot 3.0.5</p>
<p>java 17</p>
<p>lombook</p>
<p>mybatis</p>
<p>mysql 8.0.31</p>
<br/>
<br/>
<h4>학습목표</h4>
<p>1. mybatis, jsp 환경 습득</p>
<p>2. oauth, security 적용</p>
<p>&nbsp;&nbsp;&nbsp;ㄴnaver인증 못 받아서 다른 계정은 불가...</p>
<p>3. aws 서버등록 및 파일 업로드(리눅스 환경)</p>
<br/>
<br/>
<h4>현재 진행상황</h4>
<p>3/26 - 버블정렬 페이지 작성</p>
<p>3/31 - ec2등록 및 RDS등록 (http://3.36.7.192) 요금정책 확인 후 재등록) </p>
<p>4/10 - html 무료 템플릿 적용</p>
<img src="https://user-images.githubusercontent.com/110438208/230780762-61d31af6-c447-4080-924d-be63083f9fd0.png" width="500px" height="300px"/>
<img src="https://user-images.githubusercontent.com/110438208/230780829-9202a358-6866-43a2-a70d-d9f30ce26662.png" width="500px" height="300px"/>
<img src="https://user-images.githubusercontent.com/110438208/230780901-490280b6-2da2-4c24-94fd-fd0f825e7a61.png" width="500px" height="300px"/>
<p>4/11 - 채팅 구현</p>
<img src="https://user-images.githubusercontent.com/110438208/231190979-7ff55dfe-26fd-406f-b6e9-67a532c6f1f6.png" width="700px" height="300px"/>
<img src="https://user-images.githubusercontent.com/110438208/231192151-32850ebe-9591-404a-8557-bc461339c4f8.png" width="700px" height="500px"/>

---------------------------------------------------
<h4>얻은 지식 기록</h4>
<p>1. boot 는 내장 톰캣을 사용한다.(나중에 빌드해서 서버에서 돌릴 때 편함)</p>
<p>2. jsp파일을 사용하고 싶으면 war파일로 빌드해야한다.  </p>
<pre>
  2-1. boot+gradle+jsp로 작업을 하였다면 bootWar로 빌드하면 내장톰캣이면서 jsp사용가능
</pre>
<br/>
<p>3. AWS기본 계념  </p>
<pre>
  3-1. EC2, RDS 는 VPC 가상 pc안에 존재함
  3-2. VPC안에서 한번 더 '서브넷'이란 것으로 영역을 나눔
  3-3. 해당 영역들에 접근 하기위해 접근 권한을 열어줘야함
  3-4. 보안그룹, 라우팅(VPC)에서 해당 경로를 열어줘야함 (모든요청 허용은 0.0.0.0/0)
</pre>
<p>4. 리눅스 포트 리다이렉트(aws에서 80은 유저가 컨트롤 할 수 없게 설정해 놓았기 때문에 리다이렉트 해줘야함)</p>
