
function sortByDocTypeId(a,b){
  if (a.documenttype_id < b.documenttype_id)
    return -1;
  if (a.documenttype_id > b.documenttype_id)
    return 1;
  return 0;
};

function sortByDocCode(a,b){
  if (a.doccode < b.doccode)
    return -1;
  if (a.doccode > b.doccode)
    return 1;
  return 0;
};

function sortByDocName(a,b){
  if (a.docname < b.docname)
    return -1;
  if (a.docname > b.docname)
    return 1;
  return 0;
};

function createTableRow(doctype, index){
	var cls = ( index%2 == 0) ? 'even': 'odd';
	return '<tr class="' + cls +'">' +
	'<td>' +doctype.documenttype_id + '</td>' + 
	'<td>' +doctype.doccode +   '</td>' + 
	'<td>' +doctype.docname +  '</td>' + 
	'<td>' +doctype.term_give +  '</td>' +
	'<td>' +doctype.term_working +  '</td>' +
	'<td>' +doctype.fullname +  '</td>' +
	'<td>' +doctype.termgive_enddate +  '</td>' +
	'<td>' +doctype.dt_accountreg_id +  '</td>' +
	'<td>' +doctype.kt_accountreg_id +  '</td>' +
	'<td>' +doctype.isalwaccepting +  '</td>' +
	'<td>' +doctype.kinddoc +  '</td>' +
	'<td>' +doctype.isinc +  '</td>' +
	'<td>' +doctype.interest +  '</td>' +
	'<td>' +doctype.overinterest +  '</td>' +
	'<td>' +doctype.instnumber +  '</td>' +
	'</tr>'; 
};

function recreateTable(sortfunction){
	var d = document.getElementById('tableDiv');
	var tableStr='<table class="register">';
	var header='<tr class="header">' + '<td>' + '<a href="#" onclick="recreateTable(sortByDocTypeId);" > documenttype_id</a>' +  
	'</td>' +  '<td>' + '<a href="#" onclick="recreateTable(sortByDocCode);" > docCode</a>' + 
	'</td>' +  '<td>' + '<a href="#" onclick="recreateTable(sortByDocName);"> DocName</a>' + '</td>' +  
	'<td>' + 'term_give' + '</td>' +  
	'<td>' + 'term_working' + '</td>' +  
	'<td>' + 'fullname' + '</td>' +  
	'<td>' + 'termgive_enddate' + '</td>' +  
	'<td>' + 'dt_accountreg_id' + '</td>' +  
	'<td>' + 'kt_accountreg_id' + '</td>' +  
	'<td>' + 'isalwaccepting' +  '</td>' +
	'<td>' + 'kinddoc' + '</td>' +  
	'<td>' + 'isinc' + '</td>' +  
	'<td>' + 'interest' + '</td>' +  
	'<td>' + 'overinterest' + '</td>' +  
	'<td>' + 'instnumber' + '</td>' + 
	'</tr>';
	tableStr+=header;
	doctypes.sort(sortfunction);
	for(i=0; i < doctypes.length; i++){tableStr+=(createTableRow(doctypes[i],i));}
	tableStr+='</table>';
	d.innerHTML = tableStr;
};