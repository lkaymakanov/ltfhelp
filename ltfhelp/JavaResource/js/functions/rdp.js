function sortByIndex(a,b){
  if (a.index < b.index)
    return -1;
  if (a.index > b.index)
    return 1;
  return 0;
};

function sortByMuniciaplity(a,b){
  if (a.municiaplity < b.municiaplity)
    return -1;
  if (a.municiaplity > b.municiaplity)
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



function createTableRow(rdp, index){
	var cls = ( index%2 == 0) ? 'even': 'odd';
	return '<tr class="' + cls +'">' +
	'<td>' + rdp.index + '</td>' +  
	'<td>' + rdp.municiaplity +   '</td>' + 
	'<td>' + rdp.address +  '</td>' + 
	'<td>' + rdp.tel +  '</td>' + 
	'<td>' + rdp.login +  '</td>' + 
	'<td>' + rdp.teamviewer +  '</td>' + 
	'<td>' + rdp.teampass +  '</td>' + 
	'<td>' + rdp.contacts +  '</td>' + 
	'</tr>'; 
}

function recreateTable(sortfunction){
	var d = document.getElementById('tableDiv');
	var tableStr='<table class="register">';
	var header='<tr class="header">' + '<td>' + '<a href="#" onclick="recreateTable(sortByIndex);" >Index</a>' + '</td>' +  
	'<td>' + '<a href="#" onclick="recreateTable(sortByMuniciaplity);" > Municipality</a>' + '</td>' +  
	'<td>' + '<a href="#" onclick="recreateTable(sortByAddress);" >Address</a>'  + '</td>' +  
	'<td>' + 'Tel' + '</td>' +  
	'<td>' + 'Login' + '</td>' + 
	'<td>' + 'TeamViewer' + '</td>' + 
	'<td>' + 'TeamPass' + '</td>' + 
	'<td>' + 'Contacts' + '</td>' + 
	'</tr>';
	tableStr+=header;
	rdps.sort(sortfunction);
	for(i=0; i < rdps.length; i++){tableStr+=(createTableRow(rdps[i], i));}
	tableStr+='</table>';
	d.innerHTML = tableStr;
}