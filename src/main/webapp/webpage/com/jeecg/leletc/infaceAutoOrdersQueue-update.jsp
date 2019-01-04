<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>预约队列</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="infaceAutoOrdersQueueController.do?doUpdate" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id" value="${infaceAutoOrdersQueue.id}"/>
	<div class="form-group">
		<label for="queueDate" class="col-sm-3 control-label">队列日期：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		    <input id="queueDate" name="queueDate" type="text" class="form-control input-sm laydate-date" placeholder="请输入队列日期"  ignore="ignore"  value="<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${infaceAutoOrdersQueue.queueDate}'/>" />
                <span class="input-group-addon" ><span class="glyphicon glyphicon-calendar"></span></span>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="queueNo" class="col-sm-3 control-label">排队编号：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="queueNo" name="queueNo" value='${infaceAutoOrdersQueue.queueNo}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入排队编号"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="queueUser" class="col-sm-3 control-label">排队用户：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="queueUser" name="queueUser" value='${infaceAutoOrdersQueue.queueUser}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入排队用户"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="queueStatus" class="col-sm-3 control-label">排队状态：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="queueStatus" name="queueStatus" value='${infaceAutoOrdersQueue.queueStatus}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入排队状态"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="createName" class="col-sm-3 control-label">创建人名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="createName" name="createName" value='${infaceAutoOrdersQueue.createName}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入创建人名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="createBy" class="col-sm-3 control-label">创建人登录名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="createBy" name="createBy" value='${infaceAutoOrdersQueue.createBy}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入创建人登录名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="createDate" class="col-sm-3 control-label">创建日期：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		    <input id="createDate" name="createDate" type="text" class="form-control input-sm laydate-date" placeholder="请输入创建日期"  ignore="ignore"  value="<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${infaceAutoOrdersQueue.createDate}'/>" />
                <span class="input-group-addon" ><span class="glyphicon glyphicon-calendar"></span></span>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="updateName" class="col-sm-3 control-label">更新人名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="updateName" name="updateName" value='${infaceAutoOrdersQueue.updateName}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入更新人名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="updateBy" class="col-sm-3 control-label">更新人登录名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="updateBy" name="updateBy" value='${infaceAutoOrdersQueue.updateBy}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入更新人登录名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="updateDate" class="col-sm-3 control-label">更新日期：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		    <input id="updateDate" name="updateDate" type="text" class="form-control input-sm laydate-date" placeholder="请输入更新日期"  ignore="ignore"  value="<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${infaceAutoOrdersQueue.updateDate}'/>" />
                <span class="input-group-addon" ><span class="glyphicon glyphicon-calendar"></span></span>
			</div>
		</div>
	</div>
	</form>
	</div>
 </div>
<script type="text/javascript">
var subDlgIndex = '';
$(document).ready(function() {
	$(".laydate-datetime").each(function(){
		var _this = this;
		laydate.render({
		  elem: _this,
		  format: 'yyyy-MM-dd HH:mm:ss',
		  type: 'datetime',
		  ready: function(date){
		  	 $(_this).val(DateJsonFormat(date,this.format));
		  }
		});
	});
	$(".laydate-date").each(function(){
		var _this = this;
		laydate.render({
		  elem: _this,
		  format: 'yyyy-MM-dd',
		  ready: function(date){
		  	 $(_this).val(DateJsonFormat(date,this.format));
		  }
		});
	});
	//单选框/多选框初始化
	$('.i-checks').iCheck({
		labelHover : false,
		cursor : true,
		checkboxClass : 'icheckbox_square-green',
		radioClass : 'iradio_square-green',
		increaseArea : '20%'
	});
	
	//表单提交
	$("#formobj").Validform({
		tiptype:function(msg,o,cssctl){
			if(o.type==3){
				validationMessage(o.obj,msg);
			}else{
				removeMessage(o.obj);
			}
		},
		btnSubmit : "#btn_sub",
		btnReset : "#btn_reset",
		ajaxPost : true,
		beforeSubmit : function(curform) {
		},
		usePlugin : {
			passwordstrength : {
				minLen : 6,
				maxLen : 18,
				trigger : function(obj, error) {
					if (error) {
						obj.parent().next().find(".Validform_checktip").show();
						obj.find(".passwordStrength").hide();
					} else {
						$(".passwordStrength").show();
						obj.parent().next().find(".Validform_checktip").hide();
					}
				}
			}
		},
		callback : function(data) {
			var win = frameElement.api.opener;
			if (data.success == true) {
				frameElement.api.close();
			    win.reloadTable();
			    win.tip(data.msg);
			} else {
			    if (data.responseText == '' || data.responseText == undefined) {
			        $.messager.alert('错误', data.msg);
			        $.Hidemsg();
			    } else {
			        try {
			            var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
			            $.messager.alert('错误', emsg);
			            $.Hidemsg();
			        } catch (ex) {
			            $.messager.alert('错误', data.responseText + "");
			            $.Hidemsg();
			        }
			    }
			    return false;
			}
		}
	});
});
</script>
</body>
</html>