<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Social Network Page</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<link rel="stylesheet" href="./css/upload-style.css">
	<link rel="stylesheet" href="./css/wireframe.css" type="text/css">
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		function imageLengthCheck() {
			var count = $('#media-list').children().length - 1;
			location.href = "insertBoardCommand.do?count="+count
		}
	</script>
</head>
<body>
	<c:forEach var="listBoard" items="${listBoardDto}">
		<div class="border border-info m-5 w-50" id="idBoard">
			<div class="row">
				<!-- 프로필 사진 -->
				<div class="col-md-2">
					<img class="img-fluid rounded-circle p-3" src="./boardImages/The-Rock.jpg" alt="Card image">
				</div>
				<div class="col-md-10 align-self-center">
					<c:forEach var="listBoardMember" items="${listBoardMemberDto}">
					<c:if test="${listBoard.bdNo == listBoardMember.bdNo }">
					<div class="row">
						<!-- 작성자 아이디  -->
						<div class="col-md-12">
							<p class="lead">${listBoardMember.mNm}</p>
						</div>
					</div>
					</c:if>
					</c:forEach>
				</div>
			</div>
			<div class="">
				<div class="row">
					<div class="col-md-12">
						<div class="carousel slide" data-ride="carousel${listBoard.bdNo}" id="carousel${listBoard.bdNo}">
							<div class="carousel-inner">
								<!-- 등록한 이미지 -->
								<c:forEach var="listBdImg" items="${listBdImgDto }">
									<c:if test="${listBoard.bdNo == listBdImg.bdNo }">
										<c:choose>
											<c:when test="${listBdImg.fNo <= 1}">
												<div class="carousel-item active">
													<img class="d-block img-fluid w-100" src="${listBdImg.imgUrl }">
												</div>
											</c:when>
											<c:otherwise>
												<c:if test="${listBdImg.fNo == 1 }">
												<div class="carousel-item active">
													<img class="d-block img-fluid w-100" src="${listBdImg.imgUrl }">
												</div>
												</c:if>
												<c:if test="${listBdImg.fNo >= 2 }">
												<div class="carousel-item">
													<img class="d-block img-fluid w-100" src="${listBdImg.imgUrl }">
												</div>
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
								</c:forEach>
							</div>
						</div> 
						<a class="carousel-control-prev" href="#carousel${listBoard.bdNo}" role="button" data-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a>
						<a class="carousel-control-next" href="#carousel${listBoard.bdNo}" role="button" data-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</div>
			<div class="py-2">
				<div class="w-25 p-0">
					<div class="row mx-1">
						<!-- 좋아요 로고 -->
						<div class="col-md-4">
							<img class="d-block img-fluid" src="./icon/like-icon.png">
						</div>
						<!-- 댓글 로고 -->
						<div class="col-md-4">
							<img class="d-block img-fluid" src="./icon/comment-icon.png">
						</div>
					</div>
				</div>
			</div>
			<div class="">
				<div class="row">
					<!-- 좋아요 수 -->
					<div class="col-md-12 px-4">
						<p class="lead">좋아요 ${listBoard.likeHits}</p>
					</div>
				</div>
			</div>
			<div class="">
				<div class="row">
					<!-- 글 내용 -->
					<c:forEach var="listBoardMember" items="${listBoardMemberDto}">
					<c:if test="${listBoard.bdNo == listBoardMember.bdNo }">
					<div class="col-md-12 px-4">
						<p class="lead"><b>${listBoardMember.mNm}</b> ${listBoard.bdContent} </p>
					</div>
					</c:if>
					</c:forEach>
				</div>
			</div>
			<div class="">
				<div class="row">
					<!-- 댓글 수 -->
					<c:choose>
						<c:when test="${listBoard.rplyHits < 1 }">
							<div class="col-md-12 px-4">
								<p class="lead">댓글 ${listBoard.rplyHits}개</p>
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-md-12 px-4">
								<p class="lead">댓글 ${listBoard.rplyHits}개 모두 보기</p>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="py-1">
				<div class="row">
					<!-- 댓글 -->
					<div class="col-md-12 px-4">
						<ul class="list-unstyled">
							<c:forEach var="listBdRplyMember" items="${listBdRplyMemberDto }">
								<c:if test="${listBoard.bdNo == listBdRplyMember.bdNo }">
									<li class=""><b>${listBdRplyMember.mNm}</b> ${listBdRplyMember.rplyContent }</li>		
								</c:if>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div class="py-1">
				<div class="row">
					<!-- 작성 날짜 -->
					<div class="col-md-12 px-4">
						<p class="lead">${listBoard.bdUpLdTime}</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 px-4">
					<!-- 댓글 입력 -->
					<form class="">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="text">
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</c:forEach>
	<br><br><br>
	

	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
			integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
			crossorigin="anonymous"></script>
	
	
	<div class="wrap-upload-buttons">
		<div class="container">
			<ul class="btn-nav">
				<li>
					<span>
						<img src="./icon/camera_ico.png" alt="upload" />
						<input type="file" class="picupload" name="" accept="image/*" click-type="type1" multiple="" />
					</span>
				</li>
			</ul>
		</div>
	</div>
	
	<!--boostatrp modal-->
    <div class="modal fade popups" id="hint_brand" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content clearfix">
                <div class="modal-body login-box clearfix">
                    <!--user post text -wrap-->
                    <div class="user-post-text-wrap">
                        <div class="user-pic-post">
                            <img src="https://unsplash.it/176/176/?random">
                        </div>
                        <div class="user-txt-post">
                            <textarea class="form-control upostTextarea" placeholder="What's on your mind"></textarea>
                        </div>
                    </div>
                    <!--user post text -wrap end-->
                    <ul id="media-list" class="clearfix">
                        <li class="myupload">
                            <span>
                            	<i class="fa fa-plus" aria-hidden="true" ></i>
                            	<input type="file" click-type="type2" id="picupload" class="picupload" name="imgUrl" multiple>
                            </span>
                        </li>
                    </ul>

                    <!--post btn wrap-->
                    <div class="user-post-btn-wrap clearfix">
                        <input type="submit" class="btn" value="post" onclick="imageLengthCheck()">
                    </div>
                    <!--post btn wrap end-->
                </div>
            </div>
        </div>
    </div>
    <!--bootstrap modal end-->	
</body>
 	<script src="./js/jquery-3.3.1.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/upload-app.js"></script>
	<script type="text/javascript">
		var _gaq = _gaq || [];
		  _gaq.push(['_setAccount', 'UA-36251023-1']);
		  _gaq.push(['_setDomainName', 'jqueryscript.net']);
		  _gaq.push(['_trackPageview']);

		  (function() {
		    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		  })();
	</script>
</html>