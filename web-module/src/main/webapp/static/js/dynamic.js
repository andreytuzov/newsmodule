function editArticle(id) {
	location.href = '/news/modify/' + id; 
} 


function visibleButton() {
	var checkboxes = $('input:checkbox');
	if (checkboxes.length == 0) {
		$('#delete-list-article').css('display', 'none');
	}
}

$(document).ready(function() {
	visibleButton();
	 
	$.ajaxSetup({
		headers: {"X-CSRF-TOKEN" : $("meta[name='_csrf']").attr("content")}     
	}); 
});



function deleteListArticle() {
	// Собираем какие id выбраны
	var data = '';
	$('input:checkbox:checked').each(function() {
		data += $(this).closest('li').data('id') + ",";
	});
	
	if (data.length == 0) {
		alert(messages["script.delete.empty"]);
		return; 
	} 
	
	data = data.substring(0, data.length - 1);
	
	var result = confirm(messages["script.delete.confirm"]);
	
	if (result) {
		$.ajax({
			type: "post",
			url: "/news/deletelist", 
			data: {stringIDs : data},     
			success: function() { 
				alert(messages["script.delete.success"])
				// Удаляем ранее выделенные checkbox
				$('input:checkbox:checked').each(function() {
					$(this).closest('li').remove();
				});		
				visibleButton();
			},
			error: function() {
				alert(messages["script.delete.error"])
			}
		});
	}
}

function deleteArticle(articleId) {
	
	var result = confirm(messages["script.delete.confirm"]);
	
	if (result) {
		$.ajax({
			type: "post", 
			url: "/news/delete",
			data: {id : articleId},
			success: function() {
				alert(messages["script.delete.success"]) 
				location.href = '/news/list';
			},
			error: function() {
				alert(messages["script.delete.error"])
			}
		});
	}
}

function goback() {
	location.href = document.referrer;
}