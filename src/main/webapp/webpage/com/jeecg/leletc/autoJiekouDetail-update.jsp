<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>智能柜接口明细</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="autoJiekouDetailController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${autoJiekouDetailPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								请求时间:
							</label>
						</td>
						<td class="value">
									   <input id="requestTime" name="requestTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${autoJiekouDetailPage.requestTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
						      	
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请求时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								响应时间:
							</label>
						</td>
						<td class="value">
									   <input id="responseTime" name="responseTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${autoJiekouDetailPage.responseTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
						      	
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">响应时间</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								请求内容:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="requestContent" style="height:auto;width:95%;" class="inputxt" rows="6" name="requestContent"  ignore="ignore" >${autoJiekouDetailPage.requestContent}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请求内容</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								响应内容:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="responseContent" style="height:auto;width:95%;" class="inputxt" rows="6" name="responseContent"  ignore="ignore" >${autoJiekouDetailPage.responseContent}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">响应内容</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/leletc/autoJiekouDetail.js"></script>		
