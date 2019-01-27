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
	            	<input class="form-control" id="prodName" placeholder="제품명을 입력하세요.">
	            </label>
	            <label>
	            	<span>직원명</span>
	            	<input class="form-control" id="memberNm" placeholder="입/출고자명을 입력하세요.">
	            </label>
	            <label>
	            	<span>날짜</span>
	            	<input type="number" maxlength="8" id="stdDate" class="form-control" placeholder="조회 시작일(YYYYMMDD)">
	            </label>
	            <label>
	            	<span>~</span>
	            	<input type="number" maxlength="8" id="endDate" class="form-control" placeholder="조회 마지막일(YYYYMMDD)">
	            </label>
	            <label>
	            	<span>분류</span>
	            	<select class="form-control" id="prodCategory">
                        <option>CCTV</option>
                    </select>
	            </label>
	        </div>
            <div class="btnArea">
	            <button type="button" class="btn btn-primary btnSearch" id="btnSearch">검색</button>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">입/출고 현황</div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="stockInOutHistory">
                                <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>제품명</th>
                                        <th>입/출고자</th>
                                        <th>수량</th>
                                        <th>구분</th>
                                        <th>출고사유</th>
                                        <th>비고</th>
                                        <th>날짜</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<tr id="noData" class="hide">
                                		<td colspan="8">등록된 제품이 없습니다.</td>
                                	</tr>
                                    <tr class="record">
                                        <td class="no"></td>
                                        <td class="prodName"></td>
                                        <td class="userNm"></td>
                                        <td class="inoutCnt"></td>
                                        <td class="gubun"></td>
                                        <td class="stockMemo"></td>
                                        <td class="stockEtc"></td>
                                        <td class="regDate"></td>
                                    </tr>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                            <div class="row">
                            	<div class="col-sm-6">
                            		<div class="dataTables_paginate paging_simple_numbers" id="dataTables_paginate">
                            			<ul class="pagination">
                            				<li class="paginate_button previous" id="dataTables-example_previous"><span>Previous</span></li>
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