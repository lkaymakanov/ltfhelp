
function sortByMunicipality(a,b){
  if (a.municipality < b.municipality)
    return -1;
  if (a.municipality > b.municipality)
    return 1;
  return 0;
};

function sortByMunicipalityId(a,b){
  if (a.municipalityid < b.municipalityid)
    return -1;
  if (a.municipalityid > b.municipalityid)
    return 1;
  return 0;
};

function sortByContacts(a,b){
  if (a.contacts < b.contacts)
    return -1;
  if (a.contacts > b.contacts)
    return 1;
  return 0;
};

function createTableRow(ws, index){
	var cls = ( index%2 == 0) ? 'even': 'odd';
	var redirectcontent='-----';
	var rowCnt;
	rowCnt = '<tr class="' + cls +'">' +
	'<td>' + ws.municipalityid + '</td>' +  
	'<td>' + ws.municipality + '</td>' +  
	'<td>' + '<a href="' + ws.address + '/' + ws.context + '" target="_blank">' + ws.address  + '/' + ws.context +  '</a>' +  '</td>';
	if(!ws.redirectpolicy == '')  redirectcontent = '<a href="' + ws.redirectpolicy + '/' + ws.context +'" target="_blank">' + ws.redirectpolicy + '/' + ws.context + '</a>';
	return rowCnt + '<td>' + redirectcontent +  '</td>' +
	'</td>' + '<td>' +ws.contacts +  '</td>' + '</tr>'; 
}

function recreateTable(sortfunction){
	var d = document.getElementById('tableDiv');
	var tableStr='<table class="register">';
	var header='<tr class="header">' + 
	'<td>' + '<a href="#" onclick="recreateTable(sortByMunicipalityId);" > MunicipalityId</a>' +  '</td>' + 
	'<td>' + '<a href="#" onclick="recreateTable(sortByMunicipality);" > Municipality</a>' +  '</td>' + 
	'<td>' + 'Address' + '</td>' + 
	'<td>' + 'Redirect Policy' + '</td>' + 
	'<td>' + '<a href="#" onclick="recreateTable(sortByContacts);" > Contacts</a>' + '</td>' +  
	'</tr>';
	tableStr+=header;
	bankws.sort(sortfunction);
	for(i=0; i < bankws.length; i++){tableStr+=(createTableRow(bankws[i], i));}
	tableStr+='</table>';
	d.innerHTML = tableStr;
}