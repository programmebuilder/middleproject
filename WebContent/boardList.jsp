<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->

	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>BoardList</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="FREEHTML5.CO" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<!-- Google Webfonts -->
	<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="./css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="./css/icomoon.css">
	<!-- Magnific Popup -->
	<link rel="stylesheet" href="./css/magnific-popup.css">
	<!-- Salvattore -->
	<link rel="stylesheet" href="./css/salvattore.css">
	<!-- Theme Style -->
	<link rel="stylesheet" href="./css/style.css">
	<!-- Modernizr JS -->
	<script src="./js/modernizr-2.6.2.min.js"></script>
  
	<!-- 글 작성을 위한 css 및 js -->
  	<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  	<link rel="stylesheet" href="./css/upload-style.css">
  	<link rel="stylesheet" href="./css/form-style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="./js/upload-app.js"></script>
	<script src="./js/board-list.js"></script>
	
	</head>
	<body>
	
	<header id="fh5co-header" role="banner">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<!-- 글 작성 modal과 연결 -->
					<a data-toggle="modal" href="#hint_brand" class="fh5co-menu-btn" >글쓰기 </a>	
				</div>
			</div>
		</div>
	</header>
	<!-- END .header -->
	
	<!--글 작성 시작 -->
	<form action="insertBoard.do" method="post" enctype="multipart/form-data">
    <div class="modal fade popups" id="hint_brand" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content clearfix">
                <div class="modal-body login-box clearfix">
                	
                    <div class="user-post-text-wrap">
                    	<!-- 프로필 사진 -->
                        <div class="user-pic-post">
                            <!-- <img src="https://unsplash.it/176/176/?random"> -->
                            <img src="./icon/default-profile-icon.png">
                            <!-- 데이터 값을 전달하기 위해서 선언 -->
                            <input type="hidden" name="mId">
                        </div>
                        
                        <!-- 내용 입력 -->
                        <div class="user-txt-post">
                            <textarea class="form-control upostTextarea" name="bdContent" placeholder="내용을 입력하세요..."></textarea>
                        </div>
                    </div>
                    
					<!-- 파일 업로드 -->
                    <ul id="media-list" class="clearfix">
                        <li class="myupload">
                            <span>
                            	<i class="fa fa-plus" aria-hidden="true" ></i>
                            	<input type="file" click-type="type1" id="picupload" class="picupload" name="imgUrl" multiple>
                            </span>
                        </li>
                    </ul>

                    <div class="user-post-btn-wrap clearfix">
                        <input type="submit" class="btn" value="post">
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form>
    <!-- 글 작성 끝 -->	
	
	<div id="fh5co-main">
		<div class="container">
			<div class="row">
        		<div id="fh5co-board" data-columns>
        			
        			<!-- 게시물의 이미지 출력 시작-->
        			<c:forEach var="listBoard" items="${listBoardDto}">
        			<div class="item">
        				<div class="animate-box">
        					<c:forEach var="listBdImg" items="${listBdImgDto}">
        					<c:if test="${listBoard.bdNo == listBdImg.bdNo}">
	        				<a href="#ContentNo-${listBoard.bdNo}" class="image-popup fh5co-board-img">
	        					<img src="${listBdImg.imgUrl }" alt="Thumbnail Image">
	        				</a>
	        				</c:if>
	        				</c:forEach>
        				</div>
        				<!-- 게시물의 내용 -->
        				<div class="fh5co-desc">${listBoard.bdContent}</div>
        			</div>
        			</c:forEach>
        			<!-- 게시물의 이미지 출력 끝 -->
        			
        			<!-- 상세 정보 시작 -->
        			<c:forEach var="listBoard" items="${listBoardDto}">
        			<form action="insertReply.do" id="ContentNo-${listBoard.bdNo}" class="white-popup-block mfp-hide" name="detailForm" method="post">
        				<!-- 이미지가 들어갈 공간 -->
        				<c:forEach var="listBdImg" items="${listBdImgDto}">
        				<c:if test="${listBoard.bdNo == listBdImg.bdNo}">
        				<div class="detail-div">
        					<img src="${listBdImg.imgUrl }" alt="Image">
        				</div>
        				</c:if>
        				</c:forEach>
        				
        				<!-- 정보가 들어갈 공간 -->
        				<div class="detail-div detailInfo-div">
	        				<!-- 프로필 사진과 이름이 들어갈 공간 -->
	        				<c:forEach var="listBoardMember" items="${listBoardMemberDto}">
	        				<c:if test="${listBoard.bdNo == listBoardMember.bdNo }">
	        				<div>
	        					<!-- 프로필 사진 -->
	        					<div>
	        						<img src="${listBoardMember.mImg}" alt="Profile Image">
	        					</div>
	        					<!-- 작성자 닉네임 -->
	        					<div class="userName">
	        						${listBoardMember.mNm}
	        					</div>
	        				</div>
	        				</c:if>
	        				</c:forEach>
	        				
	        				<!-- 본문이 들어갈 공간 -->
	        				<div>
	        					<ul class="reply-list">
	        						<!-- 작성자 닉네임과 글 내용 -->
	        						<c:forEach var="listBoardMember" items="${listBoardMemberDto}">
	        						<c:if test="${listBoard.bdNo == listBoardMember.bdNo }">
	        						<li>
	        							<b>${listBoardMember.mNm}</b> ${listBoard.bdContent}
	        						</li>
	        						</c:if>
	        						</c:forEach>
	        						
	        						<!-- 댓글 수 -->
	        						<c:choose>
	        						<c:when test="${listBoard.rplyHits < 1 }">
	        						<li class="commentNum">
	        							<!-- 댓글이 없을 때 -->
	        							댓글 ${listBoard.rplyHits}개
	        						</li>
	        						</c:when>
			        	
									<c:otherwise>	
									<li class="commentNum">
										<!-- 댓글이 있을 때 -->
										댓글 ${listBoard.rplyHits}개 모두 보기
									</li>
									</c:otherwise>		
									</c:choose>
									
									<!-- 댓글 작성자와 댓글 내용 -->
									<c:forEach var="listBdRplyMember" items="${listBdRplyMemberDto }">
									<c:if test="${listBoard.bdNo == listBdRplyMember.bdNo }">
									<li>
										<b>${listBdRplyMember.mNm}</b> ${listBdRplyMember.rplyContent }
									</li>
									</c:if>
									</c:forEach>
	        					</ul>
	        				</div>
	        				
	        				<!-- 좋아요 아이콘과 댓글 아이콘 -->
							<div class="like-and-comment">
								<span>
									<a href="#" role="button" onclick="mySubmit(1)">
										<img src="./icon/like-icon.png">
									</a>
								</span>
								<span class="comment-icon-span">
									<a href="#" role="button">
										<img src="./icon/comment-icon.png">
									</a>
								</span>
							</div>
							
							<!-- 좋아요 수 -->
							<div class="likeNum">
								좋아요 ${listBoard.likeHits}개
							</div>
							
							<!-- 글 작성 날짜 -->
							<div>
								${listBoard.bdUpLdTime}
							</div>
							
							<!-- 댓글 입력창 -->
							<div>
								<input type="hidden" name="bdNo" value="${listBoard.bdNo }">
								<input type="hidden" name="mId">
								<input type="text" id="commentForm" class="form-control" name="rplyContent" placeholder="댓글을 입력하세요...">
								<!-- <button id="commentButton" onclick="mySubmit(2)"></button> -->
							</div>
        				</div>
        				
					</form>
        			</c:forEach>
        			<!-- 상세 정보 끝 -->
        			
        		</div>
        	</div>
       </div>
	</div>


	<footer id="fh5co-footer">
		
		<div class="container">
			<div class="row row-padded">
				<div class="col-md-12 text-center">
					<p><small>&copy; Hydrogen Free HTML5 Template. All Rights Reserved. <br>Designed by: <a href="http://freehtml5.co/" target="_blank">FREEHTML5.co</a> | Images by: <a href="http://pexels.com" target="_blank">Pexels</a> </small></p>
				</div>
			</div>
		</div>
	</footer>


	<!-- jQuery -->
	<script src="./js/jquery-3.3.1.min.js"></script>
	<!-- jQuery Easing -->
	<script src="./js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="./js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="./js/jquery.waypoints.min.js"></script>
	<!-- Magnific Popup -->
	<script src="./js/jquery.magnific-popup.min.js"></script>
	<!-- Salvattore -->
	<script src="./js/salvattore.min.js"></script>
	<!-- Main JS -->
	<script src="./js/main.js"></script>
	
	

	</body>
	
</html>
