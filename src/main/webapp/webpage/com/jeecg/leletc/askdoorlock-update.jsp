<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>开关锁清单</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="smartCabinetLockLogController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${askdoorlockPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								箱门ID:
							</label>
						</td>
						<td class="value">
						    <input id="arkdoorId" name="arkdoorId" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore"  value='${askdoorlockPage.arkdoorId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱门ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								开关锁指令:
							</label>
						</td>
						<td class="value">
						    <input id="lockInstruct" name="lockInstruct" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${askdoorlockPage.lockInstruct}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开关锁指令</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								开关锁动作:
							</label>
						</td>
						<td class="value">
						    <input id="lockAct" name="lockAct" type="text" maxlength="4" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${askdoorlockPage.lockAct}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开关锁动作</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								开关锁时间:
							</label>
						</td>
						<td class="value">
									   <input id="lockTime" name="lockTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${askdoorlockPage.lockTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
						      	
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开关锁时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								开关锁动作结果:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="lockResult" type="list"  typeGroupCode=""   defaultVal="${askdoorlockPage.lockResult}" hasLabel="false"  title="开关锁动作结果" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开关锁动作结果</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								开关锁用户:
							</label>
						</td>
						<td class="value">
						    <input id="lockUser" name="lockUser" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${askdoorlockPage.lockUser}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开关锁用户</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/leletc/askdoorlock.js"></script>		
