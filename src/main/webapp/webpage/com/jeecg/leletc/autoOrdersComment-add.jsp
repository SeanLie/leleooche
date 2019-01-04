<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>订单评论管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <style type="text/css">
  	.combo_self{height: 22px !important;width: 150px !important;}
  	.layout-header .btn {
	    margin:0;
	   float: none !important;
	}
	.btn-default {
	    height: 35px;
	    line-height: 35px;
	    font-size:14px;
	}
  </style>
  
  <script type="text/javascript">
	$(function(){
		$(".combo").removeClass("combo").addClass("combo combo_self");
		$(".combo").each(function(){
			$(this).parent().css("line-height","0px");
		});   
	});
  		
  		 /**树形列表数据转换**/
  function convertTreeData(rows, textField) {
      for(var i = 0; i < rows.length; i++) {
          var row = rows[i];
          row.text = row[textField];
          if(row.children) {
          	row.state = "open";
              convertTreeData(row.children, textField);
          }
      }
  }
  /**树形列表加入子元素**/
  function joinTreeChildren(arr1, arr2) {
      for(var i = 0; i < arr1.length; i++) {
          var row1 = arr1[i];
          for(var j = 0; j < arr2.length; j++) {
              if(row1.id == arr2[j].id) {
                  var children = arr2[j].children;
                  if(children) {
                      row1.children = children;
                  }
                  
              }
          }
      }
  }
  </script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="autoOrdersCommentController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${autoOrdersCommentPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							订单ID:
						</label>
					</td>
					<td class="value">
					     	 <input id="orderId" name="orderId" type="text" maxlength="36" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">订单ID</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							评论内容:
						</label>
					</td>
					<td class="value">
					     	 <input id="comments" name="comments" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">评论内容</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							服务星级:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="serverStarsLevel" type="list"  typeGroupCode="a_starts"  defaultVal="${autoOrdersCommentPage.serverStarsLevel}" hasLabel="false"  title="服务星级" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">服务星级</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							评论状态:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="commentStatus" type="list"  typeGroupCode="comstatus"  defaultVal="${autoOrdersCommentPage.commentStatus}" hasLabel="false"  title="评论状态" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">评论状态</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							评论时间:
						</label>
					</td>
					<td class="value">
							   <input id="commentTime" name="commentTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">评论时间</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							评论用户:
						</label>
					</td>
					<td class="value">
					     	 <input id="commentUserName" name="commentUserName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">评论用户</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/leletc/autoOrdersComment.js"></script>		
