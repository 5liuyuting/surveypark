$(function() {
	var surveyId = $("#sId").val();
	$("#single").click(
			function() {
				$.post("/surveypark/question_createQuestion.action",
						"questionType=1&surveyId=" + surveyId, function() {
							window.location.reload();
						});
			});
	$("#multiple").click(
			function() {
				$.post("/surveypark/question_createQuestion.action",
						"questionType=2&surveyId=" + surveyId, function() {
							window.location.reload();
						});
			});
	$("#single_blank").click(
			function() {
				$.post("/surveypark/question_createQuestion.action",
						"questionType=3&surveyId=" + surveyId, function() {
							window.location.reload();
						});
			});
	$("#multiple_blank").click(
			function() {
				$.post("/surveypark/question_createQuestion.action",
						"questionType=4&surveyId=" + surveyId, function() {
							window.location.reload();
						});
			});
	$("#matrix_single").click(
			function() {
				$.post("/surveypark/question_createQuestion.action",
						"questionType=5&surveyId=" + surveyId, function() {
							window.location.reload();
						});
			});
	$("#matrix_multiple").click(
			function() {
				$.post("/surveypark/question_createQuestion.action",
						"questionType=6&surveyId=" + surveyId, function() {
							window.location.reload();
						});
			});
	$(":text").change(
			function() {
				var id = this.id;
				if (id.indexOf("q_") != -1) {
					id = id.split("q_")[1];
					$.post("/surveypark/question_updateTitle.action", "id="
							+ id + "&title=" + this.value);
				}
				if (id.indexOf("op_") != -1) {
					id = id.split("op_")[1];
					$.post("/surveypark/option_updateText.action", "id=" + id
							+ "&text=" + this.value);
				}
			});

	$("a").click(
			function() {
				var id = this.id;
			//alert(id);
				if (id.indexOf("add_") != -1) {
					id = id.split("add_")[1];
					$.post("/surveypark/option_add.action", "questionId=" + id,
							function() {
								window.location.reload();
							});
				}
				if (id.indexOf("del_") != -1) {
					id = id.split("del_")[1];
					$.post("/surveypark/option_delete.action", "id=" + id,
							function() {
						window.location.reload();
					});
				}
				if (id.indexOf("vsort_") != -1) {
					id = id.split("vsort_")[1];
					$.post("/surveypark/option_verticalSort.action", "questionId=" + id,
							function() {
						window.location.reload();
					});
				}
				if (id.indexOf("hsort_") != -1) {
					id = id.split("hsort_")[1];
					$.post("/surveypark/option_ horizontalSort.action", "questionId=" + id,
							function() {
						window.location.reload();
					});
				}
				
				if (id.indexOf("delq_") != -1) {
					id = id.split("delq_")[1];
					$.post("/surveypark/question_delete.action", "id=" + id,
							function() {
						window.location.reload();
					});
				}
				if (id.indexOf("moveup_") != -1) {
					id = id.split("moveup_")[1];
					$.post("/surveypark/question_moveUp.action", "id=" + id,
							function() {
						window.location.reload();
					});
				}
				if (id.indexOf("movedown_") != -1) {
					id = id.split("movedown_")[1];
					$.post("/surveypark/question_moveDown.action", "id=" + id,
							function() {
						window.location.reload();
					});
				}
				if (id.indexOf("addh_") != -1) {
					id = id.split("addh_")[1];
					$.post("/surveypark/option_add.action", "questionId=" + id+"&type=0",
							function() {
						window.location.reload();
					});
				}
				if (id.indexOf("addv_") != -1) {
					id = id.split("addv_")[1];
					$.post("/surveypark/option_add.action", "questionId=" + id+"&type=1",
							function() {
						window.location.reload();
					});
				}
		});

	$(":input").focus(function() {
		var id = this.id;
		$("#" + id).css("border", "1px solid red");
		if (id.indexOf("op_") != -1) {
			id = id.split("op_")[1];
			$("#dop_" + id).show();
		}
	});
	
	$(":input").blur(function() {
		var id = this.id;
		$("#" + id).css("border", "0");
		if (id.indexOf("op_") != -1) {
			id = id.split("op_")[1];
			$("#dop_" + id).hide("slow");
			
		}
	});
	$(".s_blank").css("border", "1px solid #77a5b4");
	
	var oldSite=new Object();
    oldSite.left=$("#leftDiv").offset().left;
    oldSite.top=$("#leftDiv").offset().top;
    $(window.document).scroll(function () {
        var scrolltop = $(document).scrollTop();
        var top=oldSite.top+scrolltop;
        $("#leftDiv").offset({ top: top });
    });
    
   
});