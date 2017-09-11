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
});



function deleteListArticle() {
	// Собираем какие id выбраны
	var data = '';
	$('input:checkbox:checked').each(function() {
		data += $(this).closest('li').data('id') + ",";
	});
	
	if (data.length == 0) {
		alert('Не выбрано не одной статьи');
		return;
	} 
	
	data = data.substring(0, data.length - 1);
	
	var result = confirm('Вы уверены, что хотите выполнить удаление ?');
	
	if (result) {
		$.ajax({
			type: "post",
			url: "/news/deletelist",
			data: {stringIDs : data},
			success: function(msg) {
				alert(msg);
				// Удаляем ранее выделенные checkbox
				$('input:checkbox:checked').each(function() {
					$(this).closest('li').remove();
				});		
				visibleButton();
			},
			error: function() {
				alert("Ошибка при удалении")
			}
		});
	}
}

function deleteArticle(articleId) {
	
	var result = confirm('Вы уверены, что хотите удалить статью ?');
	
	if (result) {
		$.ajax({
			type: "post",
			url: "/news/delete",
			data: {id : articleId},
			success: function(msg) {
				location.href = '/news/list';
				alert(msg);
			},
			error: function() {
				alert("Ошибка при удалении статьи")
			}
		});
	}
}

function goback() {
	location.href = document.referrer;
}