<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>订单处理</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="ordersHandleController.do?doAdd" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id"/>
		<div class="form-group">
			<label for="orderId" class="col-sm-3 control-label">订单ID：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="orderId" name="orderId" type="text" maxlength="36" class="form-control input-sm" placeholder="请输入订单ID"  datatype="*"  ignore="checked" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="dealUserId" class="col-sm-3 control-label">处理人ID：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="dealUserId" name="dealUserId" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入处理人ID"  datatype="*"  ignore="checked" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="dealAct" class="col-sm-3 control-label">处理动作：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="dealAct" name="dealAct" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入处理动作"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="dealTime" class="col-sm-3 control-label">处理时间：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
				<input name="dealTime" type="text" class="form-control laydate-date"  ignore="ignore"  />
				<span class="input-group-addon" ><span class="glyphicon glyphicon-calendar"></span></span>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="dealDesc" class="col-sm-3 control-label">处理描述：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="dealDesc" name="dealDesc" type="text" maxlength="255" class="form-control input-sm" placeholder="请输入处理描述"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="dealUserName" class="col-sm-3 control-label">处理人名字：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="dealUserName" name="dealUserName" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入处理人名字"  ignore="ignore" />
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
		  elem: this,
		  format: 'yyyy-MM-dd HH:mm:ss',
		  type: 'datetime'
		});
	});
	$(".laydate-date").each(function(){
		var _this = this;
		laydate.render({
		  elem: this
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