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
	<link href="${pageContext.request.contextPath}/resources/css/state.css" rel="stylesheet" >
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common/jsLoader.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/state/inoutState.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
	        <%@ include file ="/WEB-INF/jspf/menu.jspf"%>
		</div>
		
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">입/출고 현황</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="form-group">
	            <label>
	            	<span>제품명</span>
	            	<input class="form-control" placeholder="제품명을 입력하세요.">
	            </label>
	            <label>
	            	<span>직원명</span>
	            	<input class="form-control" placeholder="입/출고자명을 입력하세요.">
	            </label>
	            <label>
	            	<span>날짜</span>
	            	<input class="form-control" placeholder="조회 시작일(YYYYMMDD)">
	            </label>
	            <label>
	            	<span>~</span>
	            	<input class="form-control" placeholder="조회 마지막일(YYYYMMDD)">
	            </label>
	            <label>
	            	<span>분류</span>
	            	<select class="form-control">
                        <option>CCTV</option>
                    </select>
	            </label>
	        </div>
            <div class="btnArea">
	            <button type="button" class="btn btn-primary btnSearch">검색</button>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">입/출고 현황</div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>제품명</th>
                                        <th>재고량</th>
                                        <th>입/출고자</th>
                                        <th>수량</th>
                                        <th>구분</th>
                                        <th>날짜</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>CCTV1</td>
                                        <td>3</td>
                                        <td>홍길동</td>
                                        <td>2</td>
                                        <td>출고</td>
                                        <td>2018-11-21</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>CCTV1</td>
                                        <td>3</td>
                                        <td>홍길동</td>
                                        <td>2</td>
                                        <td>출고</td>
                                        <td>2018-11-21</td>
                                    </tr>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                            <div class="row">
                            	<div class="col-sm-6">
                            		<div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                            			<ul class="pagination">
                            				<li class="paginate_button previous" id="dataTables-example_previous"><span>Previous</span></li>
                            				<li class="paginate_button active"><span>1</span></li>
                            				<li class="paginate_button"><span>2</span></li>
                            				<li class="paginate_button"><span>3</span></li>
                            				<li class="paginate_button"><span>4</span></li>
                            				<li class="paginate_button"><span>5</span></li>
                            				<li class="paginate_button next" id="dataTables-example_next"><span>Next</span></li>
                            			</ul>
                            		</div>
                            	</div>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
    </div>
</body>
</html>