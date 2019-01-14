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
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/stock/popupModifyProd.js"></script>
<title>Insert title here</title>
</head>
<body>
      <div class="contentsWrap">
          <div>
              <div class="col-lg-12">
                  <h1 class="page-header"></h1>
                  <input type="hidden" id="inputFlag" value="${inputFlag}"/>
              </div>
          </div>
          
          <div class="prodModifyWrap">
          		<c:forEach var="item" items="${modyStockList}" varStatus="status">
          			  <div class="form-group input-group record" prodCode=${item.prodCode}>
			              <span class="input-group-addon prodName">${item.prodName}</span>
			              <input type="number" class="form-control prodCnt" placeholder="개수를 입력하세요.">
			              <button type="button" class="close btnRemove">×</button>
			          </div>
          		</c:forEach>
          </div>
          
          <div class="panel panel-default">
          	<div class="panel-heading">출고자 정보</div>
	          <div class="panel-body">
		          <div class="table-bordered">
		          	
			          <table class="table table-striped table-bordered">
			             <thead>
			                 <tr>
			                     <th><span class="required">*</span>출고사유</th>
			                     <th>비고</th>
			                 </tr>
			             </thead>
			             <tbody>
			                 <tr>
<!-- 			                     <td><input class="form-control" id="inpUserName" placeholder="출고자명을 입력하세요."></td> -->
			                     <td><input class="form-control" id="inpReason" placeholder="출고사유를 입력하세요."></td>
			                     <td><input class="form-control" id="inpEtc"placeholder="비고를 입력하세요."></td>
			                 </tr>
			             </tbody>
			         </table>
		          </div>
		     </div>
          </div>
          
         
         <div class="btnArea_center">
	         <button type="button" id="btnModyProd" class="btn btn-primary btn-lg"></button>
         </div>
      </div>
</body>
</html>