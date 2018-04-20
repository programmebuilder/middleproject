<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Social Network Page</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<link rel="stylesheet" href="./css/upload-style.css">
</head>
<body>
	<div class="wrap-upload-buttons">
		<div class="container">
			<ul class="btn-nav">
				<li>
					<span>
						<img src="./images/camera_ico.png" alt="upload" />
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
                            	<input type="file" click-type="type2" id="picupload" class="picupload" multiple>
                            </span>
                        </li>
                    </ul>

                    <!--post btn wrap-->
                    <div class="user-post-btn-wrap clearfix">
                        <input type="submit" class="btn" value="post">
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