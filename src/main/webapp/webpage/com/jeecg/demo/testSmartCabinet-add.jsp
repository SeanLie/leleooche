<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>测试智能柜基础表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,layer,validform,webuploader,bootstrap-form,DatePicker,easyui,tools"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="testSmartCabinetController.do?doAdd" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id"/>
		<div class="form-group">
			<label for="smartCabCode" class="col-sm-3 control-label">智能柜编号：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="smartCabCode" name="smartCabCode" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入智能柜编号"  datatype="*"  ignore="checked" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="smartCabProv" class="col-sm-3 control-label">智能柜提供商：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
		      		<input id="smartCabProv" name="smartCabProv" onclick="popupClick(this,'departname','smartCabProv','wise_partner');" type="text" maxlength="40" class="form-control input-sm" placeholder="请输入智能柜提供商"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="smartCabDoors" class="col-sm-3 control-label">智能柜箱门数：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="smartCabDoors" name="smartCabDoors" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入智能柜箱门数"  datatype="n" ignore="checked" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="smartCabAddr" class="col-sm-3 control-label">智能柜投放地址：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="smartCabAddr" name="smartCabAddr" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入智能柜投放地址"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="smartCabStatus" class="col-sm-3 control-label">智能柜状态：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<t:dictSelect field="smartCabStatus" type="list" extendJson="{class:'form-control input-sm'}"  datatype="*"   typeGroupCode="sc_status"  hasLabel="false"  title="智能柜状态"></t:dictSelect>     
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="smartCabSetdate" class="col-sm-3 control-label">智能柜投放时间：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
				<input name="smartCabSetdate" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="form-control laydate-datetime"  ignore="ignore"  />
				<span class="input-group-addon" ><span class="glyphicon glyphicon-calendar"></span></span>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="smartCabRent" class="col-sm-3 control-label">智能柜租金：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="smartCabRent" name="smartCabRent" type="text" maxlength="20" class="form-control input-sm" placeholder="请输入智能柜租金"  datatype="d" ignore="checked" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="smartCabPic" class="col-sm-3 control-label">智能柜图片：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
				<t:webUploader name="smartCabPic" outJs="true" auto="true" showImgDiv="filediv_smartCabPic"></t:webUploader>
				<div class="form" id="filediv_smartCabPic"></div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="smartCabPerson" class="col-sm-3 control-label">智能柜维护用户：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
		      		<input id="smartCabPerson" name="smartCabPerson" type="text" maxlength="40" class="form-control input-sm" placeholder="请输入智能柜维护用户"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="smartCabInstock" class="col-sm-3 control-label">智能柜是否在库：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<t:dictSelect field="smartCabInstock" type="radio" extendJson="{class:'i-checks'}"  typeGroupCode="sc_stock"  hasLabel="false"  title="智能柜是否在库"></t:dictSelect>		
				</div>
			</div>
		</div>
					<div class="form-group">
						<label for="smartCabDesc" class="col-sm-3 control-label">智能柜描述：</label>
						<div class="col-sm-7">
				    <div class="input-group" style="width:100%">
						  	 	<textarea name="smartCabDesc" value = "${testSmartCabinet.smartCabDesc}" class="form-control input-sm" rows="6"  ignore="ignore" ></textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">智能柜描述</label>
			          </div>
						</div>
	</form>
	</div>
 </div>
<script type="text/javascript">
var subDlgIndex = '';
$(document).ready(function() {
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