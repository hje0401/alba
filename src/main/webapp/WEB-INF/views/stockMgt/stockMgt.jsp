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
	<link href="${pageContext.request.contextPath}/resources/css/stockMgmt.css" rel="stylesheet" >
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common/jsLoader.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/stockMgt/stockMgtList.js"></script>
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
                    <h1 class="page-header">재고관리</h1>
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
	            	<span>분류</span>
	            	<select class="form-control" id="prodCategory">
                        <option value="">전체</option>
                        <option value="01">CCTV</option>
                        <option value="02">DOORLOCK</option>
                        <option value="03">ETC</option>
                    </select>
	            </label>
	            <label>
	            	<span>날짜</span>
	            	<input class="form-control" id="searchDate" placeholder="날짜를 입력하세요.(YYYYMMDD)">
	            </label>
	        </div>
            <div class="btnArea">
            	<button type="button" class="btn btn-primary btnSearch" id="btnRgt">등록</button>
	            <button type="button" class="btn btn-primary btnSearch" id="btnSearch">검색</button>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">재고현황</div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table class="table table-striped table-bordered table-hover" id="stockMgtList">
                                <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>제품명</th>
                                        <th>판매가</th>
                                        <th>원가</th>
                                        <th>재고</th>
                                        <th>재고 수정일</th>
                                        <th>재고 수정자</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<tr id="noData" class="hide">
                                		<td colspan="7">등록된 제품이 없습니다.</td>
                                	</tr>
                                    <tr class="record">
                                        <td class="no"></td>
                                        <td class="prodName"></td>
                                        <td class="salePrice"></td> 
                                        <td class="originPrice"></td>
                                        <td class="prodCnt"></td>
                                        <td class="updDate"></td>
                                        <td class="updId"></td>
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