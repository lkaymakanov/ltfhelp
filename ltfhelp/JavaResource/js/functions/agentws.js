function sortByMunicipality(a,b){
  if (a.municipality < b.municipality)
    return -1;
  if (a.municipality > b.municipality)
    return 1;
  return 0;
};

function sortByAddress(a,b){
  if (a.address < b.address)
    return -1;
  if (a.address > b.address)
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
	return '<tr class="' + cls +'">' +
	'<td>' + ws.municipality + '</td>' +  '<td>' + '<a href="' + ws.address +'" target="_blank">' + ws.address + '</a>' +   '</td>' + '<td>' +ws.contacts +  '</td>' + '</tr>'; 
}

function recreateTable(sortfunction){
	var d = document.getElementById('tableDiv');
	var tableStr='<table class="register">';
	var header='<tr class="header">' + 
	'<td>' + '<a href="#" onclick="recreateTable(sortByMunicipality);" > Municipality</a>' +  '</td>' + 
	'<td>' + '<a href="#" onclick="recreateTable(sortByAddress);" > Address</a>' + '</td>' + 
	'<td>' + '<a href="#" onclick="recreateTable(sortByContacts);" > Contacts</a>' + '</td>' +  
	'</tr>';
	tableStr+=header;
	agentws.sort(sortfunction);
	for(i=0; i < agentws.length; i++){tableStr+=(createTableRow(agentws[i], i));}
	tableStr+='</table>';
	d.innerHTML = tableStr;
}