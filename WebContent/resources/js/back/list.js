//批量删除
function deleteBatch(basePath){
	$("#mainForm").attr("action",basePath+"deleteBatch");
	$("#mainForm").submit();
}