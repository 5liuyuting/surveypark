function add() {
	//$("#dialog1").hide();
	 popupDiv("pop-div");
}

function popupDiv(div_id) {
    var div_obj = $("#"+div_id);
    var windowWidth = document.documentElement.clientWidth;    
    var windowHeight = document.documentElement.clientHeight;    
    var popupHeight = div_obj.height();    
    var popupWidth = div_obj.width(); 
    //添加并显示遮罩层
    $("<div id='mask'></div>").addClass("mask")
                              .width(windowWidth * 0.99)
                              .height(windowHeight * 0.99)
                              .click(function() {hideDiv(div_id); })
                              .appendTo("body")
                              .fadeIn(200);
    div_obj.css({"position": "absolute"})
           .animate({left: windowWidth/2-popupWidth/2, 
                     top: windowHeight/2-popupHeight/2, opacity: "show" }, "slow");
}
$(function(){
	var sObj=$("#state");
	sObj.change(function(){
		var sVal=sObj.val();
		alert(sVal);
	});
	
	$("form").submit(function(){
		if($.trim($("#title").val()).length==0){
			return false;
		}
	});
});