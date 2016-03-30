$(function() {
	var flag1=true; //验证邮箱是否通过
	var flag2=true; //验证密码是否通过
	var flag3=true; //验证邮箱是否通过
	
	//验证用户名
	$("#signup_username").blur(function(){
		if($.trim($("#signup_username").val()).length==0){
			alert("用户名不能为空");
			flag3=false;
			return;
		}
		else{
			flag3=true;
		}
	});
	//验证邮箱
	$("#signup_email").blur(function(){
		var v=$.trim($("#signup_email").val());
		if(v.length==0){
			alert("邮箱不能为空");
			flag1=false;
			return;
		}
		var reg1=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;   
		if(!reg1.test(v)){
			alert("请输入正确的邮箱");
			flag1=false;
			return;
		}
		else{
			/*$.post("",function(data){
				if(data=="true"){
					flag1=true;
				}
				else{
					alert("该邮箱或电话已注册");
					flag1=false;
				}
			});*/
			
		}
	});
	//验证密码
	var pwd=$("#signup_password");
	pwd.blur(function(){
		var s_password=$.trim(pwd.val());
		if(s_password.length==0){
			alert("请输入密码");
			flag2=false;
			return;
		}else if(s_password.length<8||s_password.length>20||(pwd.val()).match(/\s+/)){
			alert("请输入8-20位数字、字母或常用符号，字母区分大小写");
			flag2=false;
			return;
		}else if(pwd.val()=="12345678"||pwd.val()=="abcdefgh"){
			alert("密码太弱");
			flag2=false;
			return;
		}
		else{
			flag2=true;
		}
	});
	
	$("#validStr").focus(function(){
		$("#mvalid").html("");
	});
	
	$("form").submit(function(){
		if(!flag1||!flag2||!flag3){
			alert('信息有误，无法提交');
			return false;
		}
		if(pwd.val()!=$("#signup_confirm_password").val()){
			alert("密码不一致");
			return false;
		}
	});

});