<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
	<meta name="format-detection" content="telephone=no" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" >
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common/jsLoader.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/login/login.js"></script>
	<title>Insert title here</title>
</head>
<body>
	<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" name="form1" method="post" >
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="ID를 입력해 주세요."  name="userId" id="userId" type="text" value="${userId}" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="비밀번호를 입력해 주세요." name="userPw" id="userPw" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me" id="cbSaveId" <c:if test='${userId != "" && userId != null}'>checked="checked"</c:if>>ID 저장
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="button" id="btnLogin" class="btn btn-lg btn-success btn-block">Login</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>