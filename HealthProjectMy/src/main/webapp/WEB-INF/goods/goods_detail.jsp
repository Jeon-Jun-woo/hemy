<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
a.link:hover,img.img_click:hover{
  cursor: pointer;
}

.col{
            width: 50%; /* 각 컬럼이 화면의 절반을 차지하도록 설정 */
            float: left; /* 컬럼을 왼쪽으로 띄워 세로로 배치 */
            box-sizing: border-box; /* 컬럼의 경계를 포함하여 크기 설정 */
            padding: 20px; /* 내용과 경계 사이에 여백 설정 */
            border: 1px solid #ccc; /* 테두리 설정 */
}

.table1 td {
            padding: 10px; /* th 요소의 안쪽 여백 설정 */
            text-align: left; /* 텍스트를 왼쪽 정렬 */
}

ul.nav-tabs li a {
  padding: 10px 121.5px; /* 버튼의 위/아래 여백은 10px, 오른쪽/왼쪽 여백은 20px */
}

ul.nav-tabs li{
	background-color: #EEEEEE;
	color: black;
}
td.text-right h3{
	color: red;
	font-weight: bold;
}
table.table1 h3{
	color: red;
	font-weight: bold;
}
div.row ul.nav li{
	border: 1px solid #CCCCCC;
}
div.col h4{
	font-weight: bold;
}
div.col h5{
	font-weight: bold;
}
div.col h6{
	font-weight: bold;
	color:gray;
}
</style>
</head>
<body>

 <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <a href="#"><i class="fa fa-home"></i> Home</a>
                        <span>Shop</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    
<div class="wrapper row3" id="goodsApp">
  <main class="container clear">  
     <div class="row">
       <div class="col">
       	 <table class="table">
       	   <tr>
	         <td colspan="2" class="text-center">
	             <img :src="goods_detail.poster" style="height: 500px">
	         </td>
	       </tr>
	       <table class="table1">
	         <tr>
	           <th>리뷰수</th>
	           <td><h3>???</h3></td>
	           <th>찜수</th>
	           <td><h3>???</h3></td>
	         </tr>
	       </table>
       	 </table>
       </div>
       <div class="col">
           <table class="table">
           <tr>
	         <td><h5>{{goods_detail.brand1}}</h5></td>
	       </tr>
       	   <tr>
	         <td><h4>{{goods_detail.kname}}</h4></td>
	       </tr>
	       <tr>
	         <td><h6>{{goods_detail.ename}}</h6></td>
	       </tr>
	       <tr>
	         <td class="text-right"><h3>{{goods_detail.price}}원</h3></td>
	       </tr>
	       <table class="table2" style="">
	         <tr>
	          <td>goods_detail.</td>
	         </tr>
	       </table>
       	 </table>
       </div>
      </div>
      <div class="row">
		  <ul class="nav nav-tabs">
		    <li class="active"><a href="#">상세 정보</a></li>
		    <li><a href="#">리뷰</a></li>
		    <li><a href="#">Q&A</a></li>
		    <li><a href="#">약국지도</a></li>
		  </ul>
      </div>
      <div class="row">
        asdsasfafafa
        afssaffsaf
        fasfas
      </div>
    <div class="one_third"> 
       <!--<div id="map" style="width:100%;height:350px;"></div>-->
    </div>
    <div class="clear"></div>
    
  </main>
</div>
<script>
  let fApp=Vue.createApp({
	  data(){
		  return {
			  goods_detail:{},
			  gno:${gno}
		  }
	  },
	  mounted(){
		  axios.get('../goods/goods_detail_vue.do',{
			  params:{
				  gno:this.gno
			  }
		  }).then(response=>{
			  console.log(response.data)
			  this.goods_detail=response.data
			  
			  if(window.kakao && window.kakao.maps)
			  {
				  this.initMap()
			  }
			  else
			  {
				  this.addScript()
			  }
		  })
	  },
	  methods:{
		  addScript(){
			  const script=document.createElement("script")
			  
			  /*global kakao*/
			  script.onload=()=>kakao.maps.load(this.initMap)
			  script.src="http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9965c727d3306713c47391be682e4be9&libraries=services"
			  document.head.appendChild(script)
		  },
		  initMap(){
			  var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    		    mapOption = {
    		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    		        level: 3 // 지도의 확대 레벨
    		    };  

    		// 지도를 생성합니다    
    		var map = new kakao.maps.Map(mapContainer, mapOption); 

    		// 주소-좌표 변환 객체를 생성합니다
    		var geocoder = new kakao.maps.services.Geocoder();

    		// 주소로 좌표를 검색합니다
    		geocoder.addressSearch(this.food_detail.address, function(result, status) {

    		    // 정상적으로 검색이 완료됐으면 
    		     if (status === kakao.maps.services.Status.OK) {

    		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

    		        // 결과값으로 받은 위치를 마커로 표시합니다
    		        var marker = new kakao.maps.Marker({
    		            map: map,
    		            position: coords
    		        });

    		        // 인포윈도우로 장소에 대한 설명을 표시합니다
    		        var infowindow = new kakao.maps.InfoWindow({
    		            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+$("#name").text()+'</div>'
    		        });
    		        infowindow.open(map, marker);

    		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
    		        map.setCenter(coords);
    		    } 
    		 });    
		  },
		  goback(){
			  location.href="../goods/goods_list.do"
		  }
	  }
  }).mount("#goodsApp")
  
</script>
</body>
</html>