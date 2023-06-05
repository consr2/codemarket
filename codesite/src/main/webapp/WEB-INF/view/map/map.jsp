<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4fc23156db700d5c1f900c14f06f68db"></script>
<body>
	<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript">
	
		//카카오 맵 생성
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(37.555575, 126.9805556), //지도의 중심좌표.
			level: 8 //지도의 레벨(확대, 축소 정도)
		};
		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		
		
		//geoJson파일 가져오기
		let geoJson = null;
		let xmlhttp = new XMLHttpRequest();
		xmlhttp.open("GET", "../geojson/kor.json", false);
		xmlhttp.send();
		//파일 로드 성공 시 파일에서 읽은 텍스트를 content에 담음
		if (xmlhttp.status == 200) { 
			geoJson = xmlhttp.responseText;
		}
		geoJson = JSON.parse(geoJson)
		console.log(geoJson.features[0].geometry.coordinates);
		
		
		// 다각형을 구성하는 좌표 배열입니다. 이 좌표들을 이어서 다각형을 표시합니다
		var polygonPath = [
		    new kakao.maps.LatLng(37.555575, 126.9805556),
		    new kakao.maps.LatLng(37.556575, 126.9805356),
		    new kakao.maps.LatLng(37.557575, 126.9805256),
		];

		// 지도에 표시할 다각형을 생성합니다
		var polygon = new kakao.maps.Polygon({
		    path:polygonPath, // 그려질 다각형의 좌표 배열입니다
		    strokeWeight: 3, // 선의 두께입니다
		    strokeColor: '#39DE2A', // 선의 색깔입니다
		    strokeOpacity: 0.8, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
		    strokeStyle: 'longdash', // 선의 스타일입니다
		    fillColor: '#A2FF99', // 채우기 색깔입니다
		    fillOpacity: 0.7 // 채우기 불투명도 입니다
		});

		// 지도에 다각형을 표시합니다
		polygon.setMap(map);
		
		
		
		
		
	</script>
</body>
</html>